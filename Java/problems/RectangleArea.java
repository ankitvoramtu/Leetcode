package problems;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int y1 = Math.max(B, F);
		int y2 = Math.min(H, D);
		int x1 = Math.max(A, E);
		int x2 = Math.min(C, G);
		int ret = (C - A) * (D - B) + (G - E) * (H - F);
		if (y2 >= y1 && x2 >= x1) {
			ret -= (x2 - x1) * (y2 - y1);
		}
		return ret;
	}
}
