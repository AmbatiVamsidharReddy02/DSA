class Solution {
    public int[] dailyTemperatures(int[] ar) {
        int[] output = new int[ar.length];
        Stack<Integer> s = new Stack<Integer>();

        for(int i=0;i<ar.length;i++){
            if(s.isEmpty()){
                s.push(i);
            }

            while(!s.isEmpty() && ar[s.peek()]<ar[i]){
                int index = s.pop();
                output[index] = i - index;
            }

            s.push(i);
        }

        return output;
    }
}