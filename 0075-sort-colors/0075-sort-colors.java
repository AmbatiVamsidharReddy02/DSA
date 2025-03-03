class Solution {

    public void sortColors(int[] a) {
        int pRed = 0;
        int pWhite = 0;
        int pBlue = a.length-1;

        while(pWhite<=pBlue){
            if(a[pWhite]==0){
                swap(a, pWhite, pRed);
                pWhite++;
                pRed++;
            }else if(a[pWhite]==1){
                pWhite++;
            }else{
                swap(a, pBlue, pWhite);
                pBlue--;
            }
        }


    }

    public void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
