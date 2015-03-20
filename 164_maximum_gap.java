public class Solution {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
            
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
        
        int[] bucket_min = new int[num.length - 1];
        int[] bucket_max = new int[num.length - 1];
        
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        
        for (int i : num) {
            if (i == max)
                continue;
                
            int bucket_index = (i - min) / gap;
            bucket_min[bucket_index] = Math.min(i, bucket_min[bucket_index]);
            bucket_max[bucket_index] = Math.max(i, bucket_max[bucket_index]);
        }
        
        int max_gap = Integer.MIN_VALUE;
        int prev = min;
        
        for (int i = 0; i < bucket_min.length; i++) {
            if (bucket_min[i] == Integer.MAX_VALUE && bucket_max[i] == Integer.MIN_VALUE)
                continue;
                
            max_gap = Math.max(max_gap, bucket_min[i] - prev);
            prev = bucket_max[i];
        }
        max_gap = Math.max(max_gap, max - prev);
        
        return max_gap;
    }
}