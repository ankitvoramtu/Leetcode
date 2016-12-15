package problems;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		Set<Integer> s1 = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			s1.add(nums1[i]);
		}
		Set<Integer> s2 = new HashSet<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (s1.contains(nums2[i])) {
				s2.add(nums2[i]);
			}
		}
		int[] ret = new int[s2.size()];
		int count = 0;
		for (Integer val : s2) {
			ret[count++] = val;
		}
		return ret;
	}

}
