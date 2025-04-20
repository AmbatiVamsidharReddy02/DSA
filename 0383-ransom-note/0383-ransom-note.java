class Solution {
   

public boolean canConstruct(String ransomNote, String magazine) {
    // Create a map to store character frequencies from the magazine.
    Map<Character, Integer> magazineFreq = new HashMap<>();
    
    // Fill the frequency map with characters from the magazine.
    for (char ch : magazine.toCharArray()) {
        magazineFreq.put(ch, magazineFreq.getOrDefault(ch, 0) + 1);
    }
    
    // Check against the frequency map with each character from ransomNote.
    for (char ch : ransomNote.toCharArray()) {
        // Check if the character is missing or not enough in the magazine.
        if (!magazineFreq.containsKey(ch) || magazineFreq.get(ch) == 0) {
            return false;
        }
        // Decrease the frequency count for the current character.
        magazineFreq.put(ch, magazineFreq.get(ch) - 1);
    }
    
    return true;
}
}