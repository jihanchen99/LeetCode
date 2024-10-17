public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int wealthSum = 0;  // Reset wealthSum for each customer
            for (int j = 0; j < accounts[i].length; j++) {
                wealthSum += accounts[i][j];
            }
            if (wealthSum > maxWealth) {
                maxWealth = wealthSum;
            }
        }

        return maxWealth;
    }
}
