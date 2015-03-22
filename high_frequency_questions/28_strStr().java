public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        }
        
        if (needle.length() > haystack.length()) {
            return -1;
        }
        
        int i, j;
        
        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (j = i; j < i + needle.length(); j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
            }
            if ((j - i) == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
}