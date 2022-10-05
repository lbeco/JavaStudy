package netease;

import java.util.Scanner;

public class netEase2 {
    int[] p = new int[]{0,0,1,20,299,4000-30,50000-600,600000-12000,7000000-240000};
    public static void main(String[] args) {
        netEase2 netEase2 = new netEase2();
        netEase2.run();;
    }

    public int pow(int times){
        int res =1;
        for(int i=0;i<times;i++){
            res *= 10;
        }
        return res;

    }

    public int calc(int n){
        int res =0;
        int temp = n;
        int[] ten = new int[32];
        int index = 0;
        while(n > 0){
            ten[index] = n%10;
            n = n/10;
            index++;
        }
        n = temp;

        index = index-1;
        int level = 1;
        for(int i=0;i<=index;i++){
            if(i>=2){
                if(ten[i] > 0){

                    res+=p[i] * (ten[i]);



                }
                level = level*10;

            }

            if(ten[i]>=2 && i>0){
                if(ten[i]==2 && ten[i-1]==5){
                    int nex = i-2;
                    int addUp = 0;
                    while(nex>=0){
                        addUp = addUp*10+ten[nex];
                        nex--;
                    }
                    res += addUp+1 - calc(n%(pow(i-1)));
                }else if(ten[i] * 10 + ten[i-1]>25){

                    res += pow((i-1));
                }

            }
        }
        return res;
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        for(int i=1;i<=100000;i++){
//            if(calc(i) - calc(i-1) !=1 && (calc(i) - calc(i-1) !=0)){
//                System.out.print(i);
//                System.out.print(" ");
//                System.out.print(calc(i));
//                System.out.print(" ");
//
//                System.out.print(i-1);
//                System.out.print(" ");
//                System.out.println(calc(i-1));
//            }
//
//        }
        System.out.println(calc(2525));




    }
}
