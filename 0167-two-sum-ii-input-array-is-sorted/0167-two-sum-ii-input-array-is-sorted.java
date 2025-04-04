class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int p2= numbers.length-1;
        for(int i=0;i<numbers.length && p2>=0;){
            int sum = numbers[i] + numbers[p2];

            if(sum==target){
                return new int[]{i+1, p2+1};
            }
            else if(sum>target){
                p2--;
            }else{
                i++;
            }
        }

        return new int[]{-1,-1};
    }
}