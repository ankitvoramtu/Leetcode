package problems;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int l = 0;
		int r = height.length - 1;
		int ret = 0;
		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			ret = Math.max(ret, area);
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return ret;
	}
}
