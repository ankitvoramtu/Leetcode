package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length <= 2) {
			return ret; // ret is null
		}
		Arrays.sort(num);
		for (int i = num.length - 1; i >= 2; i--) {
			if ((i < num.length - 1) && (num[i] == num[i + 1])) {
				continue;
			}
			List<List<Integer>> curRet = twoSum(num, i - 1, -num[i]);
			ret.addAll(curRet);
		}
		return ret;
	}

	public List<List<Integer>> twoSum(int[] num, int right, int target) {
		int left = 0;
		List<List<Integer>> curRet = new ArrayList<List<Integer>>();
		while (left < right) {
			if (num[left] + num[right] == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(num[left]);
				list.add(num[right]);
				list.add(-target);
				curRet.add(list);
				left++;
				right--;
				while (left < right && num[left] == num[left - 1]) {
					left++;
				}
				while (left < right && num[right] == num[right + 1]) {
					right--;
				}
			} else if (num[left] + num[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return curRet;
	}
}
