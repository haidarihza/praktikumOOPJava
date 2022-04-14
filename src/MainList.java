public class MainList {
    public static void main(String[] args) {
        ListMap lm = new ListMap();
        lm.set("Jokowi", "18765432345");
        lm.set("Anies", "12345623");
        lm.set("Jokowi", "187654");
        lm.set("Budi", "12343");
        lm.set("Marsono", "187432345");
        System.out.println(lm.get("Jokowi"));
        System.out.println(lm.size());
    }
    
}
