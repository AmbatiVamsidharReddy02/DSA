class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows >= 1) {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            res.add(currList);
        }

        for (int i = 2; i <= numRows; i++) {
            // add leaf
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            // loop thru to find the calcuation nodes
            for (int j = 0; j < i - 2; j++) {
                currList.add(res.get(i - 2).get(j) + res.get(i - 2).get(j + 1));
            }
            currList.add(1);
            System.out.println(currList);
            res.add(currList);
        }
        return res;
    }
}