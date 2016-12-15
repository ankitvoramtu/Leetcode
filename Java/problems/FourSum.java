package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static void main(String[] args) {
		FourSum a = new FourSum();
		int[] num = new int[] { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> ret = a.fourSum(num, 0);
		System.out.println((ret));
		num = new int[] { 0, 0, 0, 0 };
		ret = a.fourSum(num, 0);
		System.out.println((ret));

	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length <= 3) {
			return ret; // ret is []
		}
		Arrays.sort(num);
		for (int i = num.length - 1; i >= 3; i--) {
			if (i < num.length - 1 && num[i] == num[i + 1]) {
				continue;
			}
			List<List<Integer>> curRet = threeSum(num, i - 1, target - num[i]);
			for (int j = 0; j < curRet.size(); j++) {
				curRet.get(j).add(num[i]);
			}
			ret.addAll(curRet);
		}
		return ret;
	}

	public List<List<Integer>> threeSum(int[] num, int right, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = right; i >= 2; i--) {
			if (i < right && num[i] == num[i + 1]) {
				continue;
			}
			List<List<Integer>> curRet = twoSum(num, i - 1, target - num[i]);
			for (int j = 0; j < curRet.size(); j++) {
				curRet.get(j).add(num[i]);
			}
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
