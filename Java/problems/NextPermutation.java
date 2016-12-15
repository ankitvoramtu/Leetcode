package problems;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation a = new NextPermutation();
		a.nextPermutation(new int[] { 2, 3, 1 });
	}

	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1) {
			return;
		}
		int i;
		for (i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				break;
			}
		}
		if (i < 0) {
			reverse(num, 0);
			return;
		}
		for (int j = num.length - 1; j >= i; j--) {
			if (num[j] > num[i]) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				break;
			}
		}
		reverse(num, i + 1);

	}

	public void reverse(int[] num, int index) {
		int right = num.length - 1;
		while (index < right) {
			int temp = num[index];
			num[index++] = num[right];
			num[right--] = temp;
		}
	}
}
