package problems;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i) {
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
			} else {
				set.remove(s.charAt(i));
			}
		}
		return set.size() == 0 || set.size() == 1;
	}

	public boolean canPermutePalindrome2(String s) {
		int[] arr = new int[256];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
		}
		int count = 0;
		for (int i = 0; i < 256; i++) {
			if (arr[i] % 2 == 1) {
				count++;
			}
		}
		return count == 1;
	}

}
