package problems;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			if (s == g) {
				bulls++;
			} else {
				if (numbers[s] < 0) {
					cows++;
				}
				if (numbers[g] > 0) {
					cows++;
				}
				numbers[s]++;
				numbers[g]--;
			}
		}
		return bulls + "A" + cows + "B";
	}

	public String getHint1(String secret, String guess) {
		int a = 0;
		int b = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 == c2) {
				a++;
			} else {
				if (map.containsKey(c1)) {
					map.put(c1, map.get(c1) + 1);
				} else {
					map.put(c1, 1);
				}
			}
		}
		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 != c2 && map.containsKey(c2) && map.get(c2) > 0) {
				b++;
				map.put(c2, map.get(c2) - 1);
			}
		}

		return a + "A" + b + "B";
	}

}
