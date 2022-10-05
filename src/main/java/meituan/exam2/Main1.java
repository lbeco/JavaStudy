package meituan.exam2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
