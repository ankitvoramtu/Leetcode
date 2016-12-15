package problems;

public class IntegerToEnglishWords {
	private final String[] belowTen = new String[] { "", "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine" };
	private final String[] belowTwenty = new String[] { "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };
	private final String[] belowHundred = new String[] { "", "Ten", "Twenty",
			"Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		return helper(num);
	}

	private String helper(int num) {
		String result = new String();
		if (num < 10) {
			result = belowTen[num];
		} else if (num < 20) {
			result = belowTwenty[num - 10];
		} else if (num < 100) {
			result = belowHundred[num / 10] + " " + helper(num % 10);
		} else if (num < 1000) {
			result = helper(num / 100) + " Hundred " + helper(num % 100);
		} else if (num < 1000000) {
			result = helper(num / 1000) + " Thousand " + helper(num % 1000);
		} else if (num < 1000000000) {
			result = helper(num / 1000000) + " Million "
					+ helper(num % 1000000);
		} else {
			result = helper(num / 1000000000) + " Billion "
					+ helper(num % 1000000000);
		}
		return result.trim();
	}

	public String numberToWords1(int num) {
		StringBuilder ret = new StringBuilder();
		if (num == 0) {
			return "Zero";
		}
		int chunk = 0;
		if (num >= 1e9) {
			chunk = num / 1000000000;
			ret.append(myHelper(chunk)).append(" Billion");
			num = num % 1000000000;
		}
		if (num >= 1e6) {
			if (ret.length() != 0) {
				ret.append(" ");
			}
			chunk = num / 1000000;
			ret.append(myHelper(chunk)).append(" Million");
			num = num % 1000000;
		}
		if (num >= 1e3) {
			if (ret.length() != 0) {
				ret.append(" ");
			}
			chunk = num / 1000;
			ret.append(myHelper(chunk)).append(" Thousand");
			num = num % 1000;
		}
		if (num > 0) {
			if (ret.length() != 0) {
				ret.append(" ");
			}
			chunk = num;
			ret.append(myHelper(chunk));
		}
		return ret.toString();
	}

	public String myHelper(int chunk) {
		StringBuilder ret = new StringBuilder();
		if (chunk >= 100) {
			ret.append(map(chunk / 100)).append(" Hundred");
			chunk = chunk % 100;
		}
		if (ret.length() != 0 && chunk != 0) {
			ret.append(" ");
		}
		return ret.append(map(chunk)).toString();
	}

	public String map(int num) {
		switch (num) {
		case 0:
			return "";
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 15:
			return "Fifteen";
		case 18:
			return "Eighteen";
		case 14:
		case 16:
		case 17:
		case 19:
			return map(num - 10) + "teen";
		case 20:
			return "Twenty";
		case 30:
			return "Thirty";
		case 40:
			return "Forty";
		case 50:
			return "Fifty";
		case 60:
		case 70:
		case 90:
			return myHelper(num / 10) + "ty";
		case 80:
			return "Eighty";
		default:
			return map(num - num % 10) + " " + map(num % 10);
		}
	}
}
