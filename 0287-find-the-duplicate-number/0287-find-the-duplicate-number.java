class Solution {
    public int findDuplicate(int[] nums) {
        // use two pointer fast and slow to detect a cycle since the numbers in array are 
        // 1,n inclusive and having a duplicate meaning there will be a cycle. and all the
        // array elements are within the boundaries of the array length. 

        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = nums[0];
        while(fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}