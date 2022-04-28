import java.lang.reflect.*;

public class AssistantDecoder {
    private Assistant assistant;

    AssistantDecoder(Assistant assistant) {
        this.assistant = assistant;
    }

    public void addPersonToRecommendations(String name) throws Exception {
        Method m = assistant.getClass().getDeclaredMethod("addPersonToRecommendations", String.class);
        m.setAccessible(true);
        m.invoke(assistant, name);
    }

    public int getSalary() throws Exception {
        Field salary = assistant.getClass().getDeclaredField("salary");
        salary.setAccessible(true);
        int assistant_salary = salary.getInt(assistant);
        return assistant_salary;
    }
}