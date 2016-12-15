package problems;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
    	if (n <= 0) {
    		return 0;
    	}
    	int ret = 0;
    	while (n > 0) {
    		ret = ret + n / 5;
    		n = n / 5;
    	}
        return ret;
    }
}
