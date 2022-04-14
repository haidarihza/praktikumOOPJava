import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Worker {
	public static int run(List<Integer> durations, int machineCount) {
		// implementation here
        ArrayList<Integer> machines = new ArrayList<Integer>();
        for (int i = 0; i < machineCount; i++) {
            machines.add(0);
        }
        for (int i = 0; i < durations.size(); i++) {
            int minIndex = machines.indexOf(Collections.min(machines));
            machines.set(minIndex, machines.get(minIndex)+durations.get(i));
        }

        int max = Collections.max(machines);
		return max;
	}
}