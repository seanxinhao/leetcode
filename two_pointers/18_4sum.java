public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (num == null || num.length == 0) {
            return res;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i - 1] == num[i]) {
                continue;
            }
            
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j - 1] == num[j]) {
                    continue;
                }
                
                int left = j + 1;
                int right = num.length - 1;
                
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[left]);
                        item.add(num[right]);
                        res.add(item);
                        
                        left++;
                        right--;
                        
                        while (left < right && num[left - 1] == num[left]) {
                            left++;
                        }
                        
                        while (left < right && num[right + 1] == num[right]) {
                            right--;
                        }
                    }
                }
            }
        }
        
        return res;
    }
}