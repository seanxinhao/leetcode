public class Solution {
    public int reverse(int x) {
        int res = 0;
        
        while (x != 0) {
            int next_res = res * 10 + x % 10;
            
            if (((next_res - x % 10) / 10) != res) {
                return 0;
            } else {
                res = next_res;
            }
            
            x /= 10;
        }
        
        return res;
    }
}