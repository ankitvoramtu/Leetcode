package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

	public int[] intersect1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i1 = 0;
		int i2 = 0;
		List<Integer> list = new LinkedList<Integer>();
		while (i1 < nums1.length && i2 < nums2.length) {
			if (nums1[i1] == nums2[i2]) {
				list.add(nums1[i1]);
				i1++;
				i2++;
			} else if (nums1[i1] < nums2[i2]) {
				i1++;
			} else {
				i2++;
			}
		}
		int[] ret = new int[list.size()];
		int i = 0;
		for (Integer l : list) {
			ret[i++] = l;
		}
		return ret;
	}

	public int[] intersect2(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			} else {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			}
		}
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] ret = new int[list.size()];
		int count = 0;
		for (Integer val : list) {
			ret[count++] = val;
		}
		return ret;
	}

}
