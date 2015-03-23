public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (num == null || num.length == 0) {
            return res;
        }
        
        Arrays.sort(num);
        int target = 0;
        
        
        for (int i = 0; i < num.length - 2; i++) {
            
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = num.length - 1;
            
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(num[i]);
                    item.add(num[left]);
                    item.add(num[right]);
                    res.add(item);
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
					    right--;
					}
                }
            }
        }
        
        return res;
    }
}