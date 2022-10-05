package jd;

public class getPossible {
    int result;
    public static void main(String[] args) {

        getPossible get = new getPossible();
        StringBuffer sb = new StringBuffer();
        sb.append( "13");
        for (int i = 0; i < 20; i++) {

            get.run(sb.toString());
            sb.insert(0,"1");
        }

    }
    public int run(String s){
        result = 0;
        int res = search(s,0);
        System.out.println(s);
        System.out.println(result);
        return res;
    }

    public  int search(String s,int i){
        if(i >= s.length()){
            result++;
            return 0;
        }
        if(i+1<=s.length()){
            search(s,i+1);
        }
        if(i+2<=s.length()){
            search(s,i+2);
        }
    return 0;
    }
}
