public class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] leftFreq = new int[26];
        int[] rightFreq = new int[26];
        
        // Initialize right frequency table
        for (char c : s.toCharArray()) {
            rightFreq[c - 'a']++;
        }
        
        int leftUnique = 0;
        int rightUnique = 0;
        
        // Count initial unique characters in right part
        for (int count : rightFreq) {
            if (count > 0) {
                rightUnique++;
            }
        }
        
        int goodSplits = 0;

        // Process each split point
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            // Move character from right to left
            if (leftFreq[c - 'a'] == 0) {
                leftUnique++;
            }
            leftFreq[c - 'a']++;
            
            rightFreq[c - 'a']--;
            if (rightFreq[c - 'a'] == 0) {
                rightUnique--;
            }
            
            // Check for good split
            if (leftUnique == rightUnique) {
                goodSplits++;
            }
        }
        return goodSplits;
    }
}