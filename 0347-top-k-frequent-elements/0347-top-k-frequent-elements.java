
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> ar = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            ar.add(new int[] { i.getValue(), i.getKey() });
        }

        ar.sort((a,b )-> b[0] - a[0]); // sort in desc order based on count;

        for(int i=0;i<ar.size();i++){
            if(k>0){
                res[i] = ar.get(i)[1];
                k--;
            }
        }
        return res;
    }
}