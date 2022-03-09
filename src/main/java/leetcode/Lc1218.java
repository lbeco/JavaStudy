package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Lc1218 {
    public int longestSubsequence(int[] arr, int difference) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.get(i - difference) != null) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            } else {
                map.put(i, 0);
            }
        }
        int max = 0;
        for (int j : arr) {
            if (map.get(j) == 0) {
                int res = 1;
                int re = j + difference;
                while (true) {
                    if (map.get(re) != null && map.get(re) > 0) {
                        res += map.get(re);
                        re += difference;
                    } else {
                        break;
                    }
                }
                max = Math.max(res, max);
            }
        }
        return max;


    }


    public static void main(String[] args) {
        Lc1218 lc = new Lc1218();
        int[] p1 = new int[]{4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};

        lc.longestSubsequence(p1, 0);
    }
}
