import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Unit{
    public int a;
    public int b;
    public Unit(int a, int b){
        this.a = a;
        this.b = b;
    }

}

public class Sort {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,7,1,6,3,6,9};
        Arrays.sort(nums);
        
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        list.sort(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        List<Integer> list2 = new ArrayList<>(list);
        List<Unit> listOfUnit = new ArrayList<>();
        Unit unit1 = new Unit(1,2);
        listOfUnit.add(unit1);
        Unit unit2 = new Unit(2,9);
        listOfUnit.add(unit2);
        listOfUnit.add(new Unit(7,1));
        listOfUnit.sort((Unit a,Unit b)-> a.a - b.a);
        listOfUnit.stream().mapToInt((x)->x.a).forEach(System.out::println);
    }
}
