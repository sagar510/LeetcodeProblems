class Solution {
    class Node implements Comparable<Node>{
        int k;
        int v;

        Node(int k, int v){
            this.k = k;
            this.v = v;
        }

        public int compareTo(Node other){
            return this.v - other.v;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        freq.forEach((key, value) -> {
            minHeap.add(new Node(key, value));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        });

        int[] res = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            res[i] = minHeap.poll().k;
            i += 1;
        }

        return res;
    }
}