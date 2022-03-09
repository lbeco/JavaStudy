import java.util.*;

public class Two {
    public static void main(String[] args){
        int[] input = new int[]{0,4,2,3,5,1};
        Map<Integer,Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        int sum = 5;
        map.put(input[0],1);

        for(int i=1;i<input.length;i++){
            if(map.getOrDefault(sum-input[i],0)>0){
                for(int j=0;j<map.get(sum-input[i]);j++){
                    res.add(new int[]{input[i],sum-input[i]});
                }
            }
            map.put(input[i],1);
        }
        for(int[] out : res){
            System.out.print(out[0]);
            System.out.print(",");
            System.out.println(out[1]);
        }
        return;
    }
}
