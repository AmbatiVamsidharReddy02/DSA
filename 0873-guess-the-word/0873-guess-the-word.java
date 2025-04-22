/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
    int[][] similarity = new int[wordlist.length][wordlist.length];
    for (int i = 0; i < wordlist.length; i++) {
        for (int j = 0; j < wordlist.length; j++) {
            similarity[i][j] = matches(wordlist[i], wordlist[j]);
        }
    }
    
    List<String> candidates = new ArrayList<>(Arrays.asList(wordlist));
    while (!candidates.isEmpty() && candidates.size() > 0) {
        int tryIndex = 0;
        int minMaxSize = candidates.size();
        for (int i = 0; i < candidates.size(); i++) {
            int[] groups = new int[7];
            for (String s : candidates) {
                groups[matches(candidates.get(i), s)]++;
            }
            int maxSize = Arrays.stream(groups).max().getAsInt();
            if (maxSize < minMaxSize) {
                minMaxSize = maxSize;
                tryIndex = i;
            }
        }
        
        String result = candidates.get(tryIndex);
        int similarityScore = master.guess(result);
        if (similarityScore == 6) return;
        
        List<String> nextRound = new ArrayList<>();
        for (String s : candidates) {
            if (matches(s, result) == similarityScore) {
                nextRound.add(s);
            }
        }
        candidates = nextRound;
    }
}

private int matches(String a, String b) {
    int matchCount = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == b.charAt(i)) {
            matchCount++;
        }
    }
    return matchCount;
}
}