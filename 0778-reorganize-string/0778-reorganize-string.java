class Solution {
    
public String reorganizeString(String S) {
    Map<Character, Integer> countMap = new HashMap<>();
    for (char c : S.toCharArray()) {
        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
    maxHeap.addAll(countMap.keySet());

    StringBuilder result = new StringBuilder();

    while (maxHeap.size() > 1) {
        char first = maxHeap.poll();
        char second = maxHeap.poll();

        result.append(first);
        result.append(second);

        countMap.put(first, countMap.get(first) - 1);
        countMap.put(second, countMap.get(second) - 1);

        if (countMap.get(first) > 0) {
            maxHeap.offer(first);
        }
        if (countMap.get(second) > 0) {
            maxHeap.offer(second);
        }
    }

    if (!maxHeap.isEmpty()) {
        char last = maxHeap.poll();
        if (countMap.get(last) > 1) {
            return "";
        }
        result.append(last);
    }

    return result.toString();
}
}