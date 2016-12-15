package problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> i1,
					Map.Entry<Integer, Integer> i2) {
				return i2.getValue() - i1.getValue();
			}
		};

		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(
				10, comp);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			q.offer(entry);
		}
		List<Integer> ret = new LinkedList<Integer>();
		while (ret.size() < k) {
			ret.add(q.poll().getKey());
		}
		return ret;

	}

	public List<Integer> topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new LinkedList<Integer>();
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			bucket[val].add(key);
		}
		List<Integer> ret = new LinkedList<Integer>();
		for (int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
			if (bucket[i].size() > 0) {
				ret.addAll(bucket[i]);
			}
		}
		return ret;

	}

}
