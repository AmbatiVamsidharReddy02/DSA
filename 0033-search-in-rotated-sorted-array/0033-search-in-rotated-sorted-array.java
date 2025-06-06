class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        System.out.println(left+" "+ right);
        while(left<=right){
            int mid = left + (right-left)/2;
            System.out.println(1/2);
            if(nums[mid]==target){
                return mid;
            }else if (nums[left]<=nums[mid]){
                if(target>nums[mid] || target<nums[left]){
                    left = mid + 1;
                }else{
                    right = mid-1;
                }
            }else{
                if(target<nums[mid] || target> nums[right]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}