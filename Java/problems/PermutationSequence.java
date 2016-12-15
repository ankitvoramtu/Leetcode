package problems;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence a = new PermutationSequence();
		System.out.println(a.getPermutation(3, 4));
	}

	public String getPermutation(int n, int k) {
		List<Integer> num = new ArrayList<Integer>();
		StringBuilder ret = new StringBuilder();
		int factor = 1;
		k--;
		for (int i = 1; i < n; i++) {
			factor *= i;
		}
		for (int i = 1; i <= n; i++) {
			num.add(i);
		}
		for (int i = n - 1; i >= 0; i--) {
			int index = k / factor;
			k = k % factor;

			ret.append(num.get(index));
			num.remove(index);
			if (i > 0) {
				factor = factor / i;
			}
		}
		return ret.toString();
	}
}
