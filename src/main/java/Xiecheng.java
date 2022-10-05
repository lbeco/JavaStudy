import java.util.ArrayList;
import java.util.List;

public class Xiecheng {
    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();
        data.add(2);
        data.add(1);
        data.add(8);
        data.add(7);
        data.add(5);
        data.add(4);
        data.add(6);
        data.add(9);
        data.add(3);

        List<List<Integer>> mergeList = new ArrayList<>();

        for(int i : data){
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            mergeList.add(newList);
        }
        while(mergeList.size()>1){
            List<List<Integer>> newMergeList = new ArrayList<>();
            for(int i=0;i<mergeList.size()-1;i+=2){
                List<Integer> list1 = mergeList.get(i);
                List<Integer> list2 = mergeList.get(i+1);
                int index1 = 0;
                int index2 = 0;
                List<Integer> newSortedList=new ArrayList<>();
                while(index1<list1.size() && index2<list2.size()){
                    if(list1.get(index1) > list2.get(index2)){
                        newSortedList.add(list1.get(index1));
                        index1++;
                    }else{
                        newSortedList.add(list2.get(index2));
                        index2++;
                    }
                }
                while(index1<list1.size()){
                    newSortedList.add(list1.get(index1));
                    index1++;
                }
                while(index2<list2.size()){
                    newSortedList.add(list2.get(index2));
                    index2++;
                }
                newMergeList.add(newSortedList);


            }
            if(mergeList.size()%2==1){
                newMergeList.add(mergeList.get(mergeList.size()-1));
            }
            mergeList.clear();
            mergeList.addAll(newMergeList);
        }
        for(int i : mergeList.get(0)){
            System.out.println(i);
        }


    }
}
