package interview;

public class CoinChange {

	final static int[] coins = {25, 21, 10, 5, 1};
	
	public static int coinChange(int amount) {
		if(amount < 0) return -1;
		if(amount == 0) return 0;
		
		int[] minCoinUsed = new int[amount + 1];
		minCoinUsed[0] = 0;
		
		for(int value = 1; value <= amount; value++) {
			int minNum = Integer.MAX_VALUE;
			for(int coinType = 0; coinType < coins.length; coinType++) {
				if(coins[coinType] <= value) {
					int tmp = minCoinUsed[value - coins[coinType]] + 1;
					if(tmp < minNum) {
						minCoinUsed[value] = tmp;
						minNum = tmp;
					}
				}
			}
		}
		return minCoinUsed[amount];
	}
	
	public static void main(String[] args) {
		System.out.println(coinChange(63));
	}
}
