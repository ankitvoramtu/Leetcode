package problems;

public class JumpGameII {
	public static void main(String[] args) {
		JumpGameII a = new JumpGameII();
		System.out.println(a.jump(new int[] { 2, 3 }));
	}

	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int lastReach = 0;
		int reach = 0;
		int step = 0;
		for (int i = 0; reach >= i && i < A.length; i++) {
			if (i > lastReach) {
				step++;
				lastReach = reach;
			}
			reach = Math.max(reach, A[i] + i);
		}
		if (reach < A.length - 1) {
			return 0;
		}
		return step;
	}
}
