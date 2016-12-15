package problems;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] list1 = version1.split("\\.");
		String[] list2 = version2.split("\\.");

		int n = Math.max(list1.length, list2.length);
		for (int i = 0; i < n; i++) {
			int val1 = i >= list1.length ? 0 : Integer.parseInt(list1[i]);
			int val2 = i >= list2.length ? 0 : Integer.parseInt(list2[i]);
			if (val1 < val2) {
				return -1;
			}
			if (val1 > val2) {
				return 1;
			}
		}
		return 0;
	}
}
