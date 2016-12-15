package problems;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
    	int ret = 0; 
    	for (int i = 0; i < s.length(); i++) {
    		int val = s.charAt(i) - 'A' + 1;
    		ret = ret * 26 + val;
    	}
    	return ret;
    }
}
