package problems;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows < 2) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int len = s.length();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j = j + size) {
                ret.append(s.charAt(j));
                if (i != 0 && i != (nRows - 1) && (j + size - 2 * i) < len) {
                    ret.append(s.charAt(j + size - 2 * i));
                }
            }
        }
        return ret.toString();
    }
}
