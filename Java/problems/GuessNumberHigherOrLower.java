package problems;

/* The guess API is defined in the parent class GuessGame.
 @param num, your guess
 @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
 int guess(int num); */
public class GuessNumberHigherOrLower {

	public int guessNumber(int n) {
		int l = 1;
		int r = n;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (guess(m) == 0) {
				return m;
			} else if (guess(m) == -1) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return 0;

	}

	private int guess(int m) {
		return 0;
	}

}
