class Solution {

    public int maxProfit(int[] prices) {
        // Note to future self, don't overthink!!!
        // solution is to check for the profits we make at each step and then add the profits to get the answer.
        /*
        Greedy algorithms are a class of algorithms that make locally optimal choices at each step with the hope of finding a global optimum solution. In these algorithms, decisions are made based on the information available at the current moment without considering the consequences of these decisions in the future. The key idea is to select the best possible choice at each step, leading to a solution that may not always be the most optimal but is often good enough for many problems.
         */

        int profit = 0;
         for(int i=1; i< prices.length;i++){
            // if we see a price with more than the previous day price we sell and get the profit
            if(prices[i] > prices[i-1]){
                // sell the previous day one and add the profit
                profit = profit + (prices[i] - prices[i-1]);
            }
         }
         return profit;
    }
}
