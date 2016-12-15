package problems;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null) {
			return -1;
		}
		int total = 0;
		int index = 0;
		int local = 0;
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
			local += gas[i] - cost[i];
			if (local < 0) {
				local = 0;
				index = i + 1;
			}
		}
		if (total >= 0) {
			return index;
		} else {
			return -1;
		}

	}
}
