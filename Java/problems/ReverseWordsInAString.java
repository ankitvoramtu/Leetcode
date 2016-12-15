package problems;

public class ReverseWordsInAString {
	public String reverseWords3(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] arr = s.trim().toCharArray();
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1 && arr[i] == arr[i + 1] && arr[i] == ' ') {
				continue;
			} else {
				arr[len++] = arr[i];
			}
		}
		reverse(arr, 0, len - 1);

		int l = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] == ' ') {
				reverse(arr, l, i - 1);
				l = i + 1;
			}
		}
		reverse(arr, l, len - 1);
		return new String(arr, 0, len);
	}

	public void reverse(char[] arr, int l, int r) {
		while (l < r) {
			char tmp = arr[l];
			arr[l++] = arr[r];
			arr[r--] = tmp;
		}
	}

	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	public String reverseWords1(String s) {
		if (s == null) {
			return null;
		}
		s = s.trim();
		if (s.length() == 0) {
			return "";
		}
		StringBuilder ret = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i != s.length() - 1 && s.charAt(i) == ' '
					&& s.charAt(i) == s.charAt(i + 1)) {
				continue;
			}
			ret.append(s.charAt(i));
		}
		int left = 0;
		int right = 0;
		while (right < ret.length()) {
			while (right < ret.length() && ret.charAt(right) != ' ') {
				right++;
			}
			int next = right + 1;
			right = right - 1;
			while (left < right) {
				char temp = ret.charAt(left);
				ret.setCharAt(left++, ret.charAt(right));
				ret.setCharAt(right--, temp);
			}
			left = next;
			right = next;
		}
		return ret.toString();
	}
}
