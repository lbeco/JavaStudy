package pdd;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.*;
public class Pdd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int times=0;times<t;times++){
            int l = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            int addUp = 0;
            boolean flag = false;
            List<Integer> powList = new ArrayList<>();

            for(int i=0;i<l;i++){
                if(flag){
                    if(s.charAt(i) == '*'){
                        int powVal = powList.get(addUp);
                        powVal += m;
                        powList.remove(powList.size()-1);
                        powList.add(powVal);
                        // addUp++;
                        flag = true;
                    }else{
                        flag = false;
                        addUp++;
                    }
                }else{
                    if(s.charAt(i) == '*'){
                        flag = true;
                        powList.add(m);

                    }else{
                        flag = false;
                    }
                }

            }
            if(flag){
                {
                    flag = false;
                    addUp++;
                }
            }
//             for(int i:powList){
//                 System.out.println(i);
//             }
            int[] addUpNum = new int[addUp];
            n--;
            for(int i=addUp-1;i>=0;i--){
                addUpNum[i] = n % (powList.get(i)+1);
                n = n/(powList.get(i)+1);
            }
            int index = 0;
            StringBuilder sb = new StringBuilder();
            flag = false;
            int curr = 0;
            for(int i=0;i<l;i++){
                if(flag){
                    if(s.charAt(i) == '*'){
                        // addUp++;
                        flag = true;
                    }else{
                        flag = false;
                        for(int k =0;k<addUpNum[curr];k++){
                            sb.append('y');
                        }
                        curr++;
                        sb.append(s.charAt(i));
                    }
                }else{
                    if(s.charAt(i) == '*'){
                        flag = true;


                    }else{
                        flag = false;
                        sb.append(s.charAt(i));
                    }
                }

            }
            if(flag){
                for(int k =0;k<addUpNum[curr];k++){
                    sb.append('y');
                }
                curr++;
            }
            System.out.println(sb);

        }
    }
}