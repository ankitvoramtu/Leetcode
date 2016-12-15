package problems;

import java.util.Arrays;

public class MajorityElement {
	public int majorityElement1(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (count == 0) {
        		ret = nums[i];
        		count++;
        	}
        	else if (nums[i] == ret) {
        		count++;
        	}
        	else {
        		count--;
        	}
        }
        return ret;
    }

	public int majorityElement2(int[] num) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			int ones = 0, zeros = 0;
			for (int j = 0; j < num.length; j++) {
				if ((num[j] & (1 << i)) != 0) {
					++ones;
				} else
					++zeros;
			}
			if (ones > zeros)
				ret |= (1 << i);
		}
		return ret;
	}

	public int majorityElement3(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
