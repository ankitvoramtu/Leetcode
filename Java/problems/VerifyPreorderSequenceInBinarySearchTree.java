package problems;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyPreorderSequenceInBinarySearchTree {
	public boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE, i = -1;
		for (int p : preorder) {
			if (p < low)
				return false;
			while (i >= 0 && p > preorder[i])
				low = preorder[i--];
			preorder[++i] = p;
		}
		return true;
	}

	public boolean verifyPreorder1(int[] preorder) {
		int low = Integer.MIN_VALUE;
		Deque<Integer> path = new LinkedList<Integer>();
		for (int p : preorder) {
			if (p < low)
				return false;
			while (!path.isEmpty() && p > path.peek())
				low = path.pop();
			path.push(p);
		}
		return true;
	}

}
