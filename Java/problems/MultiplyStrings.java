package problems;

public class MultiplyStrings {
	/**
	 * 这道题属于数值操作的题目，其实更多地是考察乘法运算的本质。基本思路是和加法运算还是近似的，只是进位和结果长度复杂一些。
	 * 我们仍然是从低位到高位对每一位进行计算
	 * ，假设第一个数长度是n，第二个数长度是m，我们知道结果长度为m+n或者m+n-1（没有进位的情况）。对于某一位i
	 * ，要计算这个位上的数字，我们需要对所有能组合出这一位结果的位进行乘法，即第1位和第i位，第2位和第i-1位，...
	 * ，然后累加起来，最后我们取个位上的数值
	 * ，然后剩下的作为进位放到下一轮循环中。这个算法两层循环，每层循环次数是O(m+n)，所以时间复杂度是O((m+
	 * n)^2)。算法中不需要额外空间，只需要维护一个进位变量即可，所以空间复杂度是O(1)。
	 */

	public static void main(String[] args) {
		MultiplyStrings a = new MultiplyStrings();
		// System.out.println(a.multiply("98", "9"));
		System.out.println(a.multiply("6", "501"));
		// System.out.println(a.multiply(
		// "61480723987857250303867015585644902996295272",
		// "17149437458129895288707346085"));
	}

	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			return "";
		}
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
			return "0";
		}
		int l1 = num1.length();
		int l2 = num2.length();
		StringBuilder ret = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < l1 + l2 - 1; i++) {
			for (int j = 0; j <= i; j++) {
				int k = i - j;
				if (j < l1 && k < l2) {
					int v1 = (int) (num1.charAt(l1 - 1 - j) - '0');
					int v2 = (int) (num2.charAt(l2 - 1 - k) - '0');
					carry += v1 * v2;
				}
			}
			ret.append(carry % 10);
			carry = carry / 10;
		}
		if (carry != 0) {
			ret.append(carry);
		}
		return ret.reverse().toString();
	}

}
