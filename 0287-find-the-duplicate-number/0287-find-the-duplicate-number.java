class Solution {
    public int findDuplicate(int[] nums) {
        // use two pointer slow and fast to detect the cycle once cycle is found
        // take another pointer slow1 or(use fast as another slow pointer) to nums[0] and then loop till slow and slow1 meet. return that element
        int fast = nums[0];
        int slow = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        // found the cycle
        fast = nums[0];
        while(slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;

    }
}