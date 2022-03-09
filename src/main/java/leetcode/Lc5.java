package leetcode;

public class Lc5 {
    int maxLength;
    int len, left, right;
    String res;
    char[] charList;

    public String longestPalindrome(String s) {
        len = s.length();
        maxLength = 0;
        charList = s.toCharArray();
        
        for (int i = 0; i < len; i++) {
            count(i);
        }
        for (int i = 0; i < len - 1; i++) {
            countInMiddle(i);
        }
        return s.substring(left, right + 1);

    }

    public void countInMiddle(int mid) {

        int start = 0;
        while (mid - start >= 0 && mid + 1 + start < len) {
            if (charList[mid - start] == charList[mid + 1 + start]) {
                start++;

            } else {
                break;
            }
        }
        start--;
        if (start + 2 > maxLength) {
            maxLength = start + 2;
            left = mid - start;
            right = mid + 1 + start;
        }

    }

    public void count(int mid) {
        int start = 0;
        while (mid - start >= 0 && mid + start < len) {
            if (charList[mid - start] == charList[mid + start]) {
                start++;
            } else {
                break;
            }
        }
        start--;
        if (start + 1 > maxLength) {
            maxLength = start + 1;
            left = mid - start;
            right = mid + start;
        }
    }

    public static void main(String[] args) {
        Lc5 lc5 = new Lc5();
        lc5.longestPalindrome("ababa");
        System.out.println(lc5.maxLength);
    }
}
