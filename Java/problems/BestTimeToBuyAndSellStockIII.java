package problems;

public class BestTimeToBuyAndSellStockIII {
	/*
	 * ���������Ƚ��������Խ���k�ν��׵��㷨��Ȼ����������������ֻ��Ҫ��kȡ��2���ɡ����ǻ���ʹ�á��ֲ����ź�ȫ�����Žⷨ��������ά����������
	 * һ���ǵ�ǰ�����i�����������j�ν���
	 * ����õ������Ƕ��٣�global[i][j]������һ���ǵ�ǰ�����i�죬���ɽ���j�ν��ף��������һ�ν����ڵ�����������õ������Ƕ���
	 * ��local[i][j]��������������������ʽ��ȫ�ֵıȽϼ򵥣�
	 * global[i][j]=max(local[i][j],global[i-1][j])��
	 * Ҳ����ȥ��ǰ�ֲ���õģ��͹���ȫ����õ��д���Ǹ�����Ϊ���һ�ν������������ǰ��һ���ھֲ���õ�����
	 * ������һ���ڹ���ȫ�����ŵ����棩�����ھֲ�������ά��������ʽ��
	 * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)��
	 * Ҳ���ǿ���������
	 * ��һ����ȫ�ֵ�i-1�����j-1�ν��ף�Ȼ����Ͻ���Ľ��ף����������׬Ǯ�Ļ���Ҳ����ǰ��ֻҪj-1�ν��ף����һ�ν���ȡ��ǰ�죩��
	 * �ڶ���������ȡlocal��i
	 * -1��j�ν��ף�Ȼ����Ͻ���Ĳ�ֵ��������Ϊlocal[i-1][j]���������i-1�������Ľ��ף��������ڱ�ɵ�i������
	 * �����������ӽ��״�����������������diff�ǲ��Ǵ���0��һ��Ҫ���ϣ���Ϊ����Ͳ�����local[i][j]���������һ�������������ˣ���
	 * ������㷨�ж���������Ҫһ��ɨ��
	 * ����ÿ��Ҫ�Խ��״������е���ʽ��⣬����ʱ�临�Ӷ���O(n*k)����������������ν��ף���ô���ӶȻ���O(n)���ռ���ֻ��Ҫά���������ݽԿ���
	 * ��������O(k)����k=2������O(1)���������£�
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] local = new int[3];
		int[] global = new int[3];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = 2; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0),
						local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[2];
	}
}