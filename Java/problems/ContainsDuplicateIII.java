package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		ContainsDuplicateIII a = new ContainsDuplicateIII();
		// a.containsNearbyAlmostDuplicate(new int[] { -3, 3 }, 2, 4);
		a.containsNearbyAlmostDuplicate(new int[] { -1, 2147483647 }, 1,
				2147483647);
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0) {
			return false;
		}
		long bucketSize = (long) t + 1;
		Map<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < nums.length; i++) {
			long bucket = ((long) nums[i] - Integer.MIN_VALUE) / bucketSize;
			if (map.get(bucket) != null
					|| (map.get(bucket - 1) != null && (nums[i]
							- map.get(bucket - 1) <= t))
					|| (map.get(bucket + 1) != null && (map.get(bucket + 1)
							- nums[i] <= t))) {
				return true;
			}
			map.put(bucket, (long) nums[i]);
			if (i >= k) {
				map.remove(((long) nums[i - k] - Integer.MIN_VALUE)
						/ bucketSize);
			}
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0) {
			return false;
		}
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer floor = set.floor(nums[i] + t);
			Integer ceil = set.ceiling(nums[i] - t);
			while ((floor != null && floor >= nums[i])
					|| (ceil != null && ceil <= nums[i])) {
				return true;
			}
			if (i >= k) {
				set.remove(nums[i - k]);
			}
			set.add(nums[i]);
		}
		return false;

	}
}
