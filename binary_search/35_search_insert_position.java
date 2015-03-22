public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
            
        if (target < A[0])
            return 0;
            
        int left = 0;
        int right = A.length - 1;
        int mid;
        
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[right] == target) {
            return right;
        }
        
        if (A[right] < target) {
            return right + 1;
        }
        
        if (A[left] == target) {
            return left;
        }
        
        return left + 1;
    }
}