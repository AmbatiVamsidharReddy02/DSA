class Solution {

    public int findKthLargest(int[] nums, int k) {
        // Min-heap with initial capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            // Add current number to heap
            minHeap.add(num);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the min-heap is the kth largest element
        return minHeap.peek();
    }
}
