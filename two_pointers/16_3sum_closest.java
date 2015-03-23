public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        
        int closest = num[0] + num[1] + num[2];
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = num.length - 1;
            
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < target) {
                    left++;
                    if (Math.abs(closest - target) > (target - sum)) {
                        closest = sum;
                    }
                } else if (sum > target) {
                    right--;
                    if (Math.abs(closest - target) > (sum - target)) {
                        closest = sum;
                    }
                } else {
                    return sum;
                }
            }
        }
        
        return closest;
    }
}