package problems;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ret = new LinkedList<Integer>();
		int c1 = 0;
		int c2 = 0;
		int m1 = 0;
		int m2 = 1;
		for (int n : nums) {
			if (m1 == n) {
				c1++;
			} else if (m2 == n) {
				c2++;
			} else if (c1 == 0) {
				m1 = n;
				c1 = 1;
			} else if (c2 == 0) {
				m2 = n;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}
		c1 = 0;
		c2 = 0;
		for (int n : nums) {
			if (n == m1) {
				c1++;
			}
			if (n == m2) {
				c2++;
			}
		}
		if (c1 > nums.length / 3) {
			ret.add(m1);
		}
		if (c2 > nums.length / 3) {
			ret.add(m2);
		}
		return ret;
	}

}
