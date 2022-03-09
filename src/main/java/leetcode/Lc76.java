package leetcode;

class Lc76 {
    public String minWindow(String s, String t) {
        int[] charIns = new int[128];
        int[] target = new int[128];
        for(int i=0;i<t.length();i++){
            target[t.charAt(i)] += 1;
        }
        int left = 0;
        int right = -1;
        int compIndex = 0;
        String res = "";
        int min = 88888888;

        while(right<s.length()){
            if (target[compIndex] > charIns[compIndex]){
                right++;
                charIns[s.charAt(right)]++;

            }else {
                if(compIndex==(int)'z'){
                    while(true){
                        if(target[s.charAt(left)] < charIns[s.charAt(left)]){

                            charIns[s.charAt(left)]--;
                            left++;
                        }else{
                            break;
                        }
                    }
                    if(right-left<min){
                        res = s.substring(left,right+1);
                        min  = right-left;
                    }
                    left = right+1;
                    compIndex = 0;
                    charIns = new int[128];
                }else{
                    compIndex++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc76 m = new Lc76();
        m.minWindow("ADOBECODEBANC", "ABC");
    }
}