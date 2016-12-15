package problems;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
    	if (n <= 0) {
    		return "";
    	}
    	StringBuilder str = new StringBuilder();
    	while (n > 0) {
    	    n = n - 1;
    		int val = n % 26;
    		str.append((char) ('A' + val));
    		n = n / 26;
    	}
    	return str.reverse().toString();
    }
}
