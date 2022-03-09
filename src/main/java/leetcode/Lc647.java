package leetcode;

public class Lc647 {
    int res;
    int len;
    char []charList;
        public int countSubstrings(String s) {
            len = s.length();
            res = 0;
            charList = s.toCharArray();
            for(int i=0; i<len;i++){
                count(i);
            }
            for(int i=0;i<len-1;i++){
                countInMiddle(i);
            }

        return res;
    }
    public void countInMiddle(int mid){

        int start = 0;
        while(mid-start>=0 && mid+1+start<len){
            if(charList[mid-start] == charList[mid+1+start]){
                res++;
                start++;
            }else{
                break;
            }
        }
    }

    public void count(int mid){
            int start = 0;
            while(mid-start>=0 && mid+start<len){
                if(charList[mid-start] == charList[mid+start]){
                    res++;
                    start++;
                }else{
                    break;
                }
            }
    }

    public static void main(String[] args) {
        Lc647 lc647 = new Lc647();
        lc647.countSubstrings("aaa");
    }
}
