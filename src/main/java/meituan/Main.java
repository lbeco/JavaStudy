package meituan;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        char[] chars = s.toCharArray();
        int [] count = new int[26];

        for(char c : chars){
            count[c-'a']++;
        }

        int min = Integer.MAX_VALUE;

        min =  Math.min(count[0]-1,min);
        min =  Math.min(count[1],min);
        min =  Math.min(count[2]/3,min);
        System.out.println(min);


    }



}
