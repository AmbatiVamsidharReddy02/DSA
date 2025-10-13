class Solution {
    public List<List<Integer>> generate(int numRows) {
        // if numRows = 1
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        if (numRows == 1)
            return res;
        for (int i = 1; i < numRows; i++) {
            // add leaf node
            res.add(new ArrayList<>());
            res.get(i).add(1);
            for (int j = 0; j <= (i - 2); j++) {
                res.get(i).add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            // another leaf
            res.get(i).add(1);
        }
        return res;
    }
}