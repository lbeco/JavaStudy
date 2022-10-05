package xiecheng;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Xiecheng1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int[] s1 = new int[4];
            int[] s2 = new int[4];
            int c1 = 0;
            int c2 = 0;
            for (int j = 0; j < 4; j++) {
                s1[j] = in.nextInt();
                if (s1[j] == 1) c1++;
            }
            for (int j = 0; j < 4; j++) {
                s2[j] = in.nextInt();
                if(s2[j] >1){
                    while(true);
                }
                if (s2[j] == 1) c2++;
            }
            if (c1 != c2) {
                System.out.println(-1);
                continue;
            } else {
                if (c1 == 1) {
                    int p1 = -1;
                    int p2 = -1;
                    for (int j = 0; j < 4; j++) {
                        if (s1[j] == 1) {
                            p1 = j;
                        }
                    }
                    for (int j = 0; j < 4; j++) {
                        if (s2[j] == 1) {
                            p2 = j;
                        }
                    }
                    if (p1 == p2) {
                        System.out.println(0);
                        continue;
                    }
                    if (((p1 == 0 && p2 == 3) || (p2 == 0 && p1 == 3)
                            || (p1 == 1 && p2 == 2) || (p2 == 1 && p1 == 2))) {
                        System.out.println(2);
                        continue;
                    }
                    System.out.println(1);
                    continue;

                } else if (c1 == 2) {
                    int same = 0;
                    for (int j = 0; j < 4; j++) {
                        if (s1[j] == s2[j] && s1[j] == 1) {
                            same++;
                        }
                    }
                    System.out.println(2 - same);
                    continue;
                } else if (c1 == 3) {
                    int p1 = -1;
                    int p2 = -1;
                    for (int j = 0; j < 4; j++) {
                        if (s1[j] == 0) {
                            p1 = j;
                        }
                    }
                    for (int j = 0; j < 4; j++) {
                        if (s2[j] == 0) {
                            p2 = j;
                        }
                    }
                    if (p1 == p2) {
                        System.out.println(0);
                        continue;
                    }
                    if ((p1 == 0 && p2 == 3) || (p2 == 0 && p1 == 3)
                            || (p1 == 1 && p2 == 2) || (p2 == 1 && p1 == 2)) {
                        System.out.println(2);
                        continue;
                    }
                    System.out.println(1);
                    continue;
                } else {
                    System.out.println(0);
                    continue;

                }
            }


        }
    }
}