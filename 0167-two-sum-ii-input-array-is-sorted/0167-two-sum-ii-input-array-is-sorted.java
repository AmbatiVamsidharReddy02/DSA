class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int firstPointer = 0;
        int lastPointer = numbers.length-1;
        int found = -1;
        while(firstPointer< lastPointer){
            if(target - numbers[lastPointer] == numbers[firstPointer]){
                return new int[] {firstPointer+1, lastPointer+1};
            }

            // do BinarySearch on the range of fistPointer & lastPointer-1 to 
            // search for the value of targer-p2;
            found = Arrays.binarySearch(numbers, firstPointer, lastPointer, (target-numbers[lastPointer]));
            if(found>0){
                break;
            }
            lastPointer--;
        }
        return new int[] {found+1, lastPointer+1};
    }
}