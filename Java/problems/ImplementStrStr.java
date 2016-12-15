package problems;

public class ImplementStrStr {
	public static void main(String[] args) {
		ImplementStrStr a = new ImplementStrStr();
		System.out.println(a.strStr("mississippi", "issi"));
	}

	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length()) {
					return i;
				}
				if (i + j == haystack.length()) {
					return -1;
				}
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
		}
	}

	public int strStr1(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}
		if (haystack.length() < needle.length()) {
			return -1;
		}

		int base = 31;
		long highBase = 1;
		long needleHash = 0;
		long hayHash = 0;
		for (int i = 0; i < needle.length(); i++) {
			needleHash = base * needleHash + needle.charAt(i);
			hayHash = base * hayHash + haystack.charAt(i);
			highBase *= base;
		}
		highBase = highBase / base;
		if (needleHash == hayHash) {
			return 0;
		}
		for (int i = needle.length(); i < haystack.length(); i++) {
			hayHash = (hayHash - highBase
					* haystack.charAt(i - needle.length()))
					* base + haystack.charAt(i);
			if (needleHash == hayHash) {
				return i - needle.length() + 1;
			}
		}
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean flag = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				return i;
			}
		}
		return -1;

	}

}
