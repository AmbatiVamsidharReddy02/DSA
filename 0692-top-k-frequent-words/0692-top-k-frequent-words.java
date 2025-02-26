class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
    for (String word : words) {
        count.put(word, count.getOrDefault(word, 0) + 1);
    }
    
    // Step 2: Min-Heap to store top k frequent words
    PriorityQueue<String> heap = new PriorityQueue<>(
        (w1, w2) -> count.get(w1).equals(count.get(w2)) 
                    ? w2.compareTo(w1) 
                    : count.get(w1) - count.get(w2));
    
    for (String word : count.keySet()) {
        heap.offer(word);
        if (heap.size() > k) {
            heap.poll(); // Remove the word with the smallest frequency
        }
    }
    
    // Step 3: Form result list from the heap
    List<String> result = new ArrayList<>();
    while (!heap.isEmpty()) {
        result.add(heap.poll());
    }
    Collections.reverse(result); // Since we want the largest frequencies first
    return result;
    }
}