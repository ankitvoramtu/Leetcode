package problems;

public class BulbSwitcher {
	public int bulbSwitch(int n) {
		if (n < 1) {
			return 0;
		}
		return (int) Math.sqrt(n);
	}
}
