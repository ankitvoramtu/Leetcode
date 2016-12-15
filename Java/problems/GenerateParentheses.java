package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	/*
	 * Catalan numbers C(n) = (2n)! / ((n+1)!n!)
	 * 
	 * 1, 1, 2, 5, 14, 42...
	 * 
	 * Or think this way
	 * 
	 * C(0) = 1; C(n+1) = Sigma (C_i * C_n-i), i = 0..n
	 */

	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
		List<String> ret = a.generateParenthesis(3);
		System.out.println(ret);
	}

	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		if (n <= 0) {
			return ret;
		}
		generateParenthesis(n, n, "", ret);
		return ret;
	}

	public void generateParenthesis(int l, int r, String item, List<String> ret) {
		if (l == 0 && r == 0) {
			ret.add(item);
			return;
		}
		if (l > 0) {
			generateParenthesis(l - 1, r, item + "(", ret);
		}
		if (l < r) {
			generateParenthesis(l, r - 1, item + ")", ret);
		}
	}

}
