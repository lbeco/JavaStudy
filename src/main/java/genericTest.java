import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class Foo{
    public String fooString;
    Foo(){

    }
    Foo(String s){
        this.fooString = s;
    }
}

class Foo2 extends Foo{

    Foo2(){

    }

}

public class genericTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<? extends Foo> list2 = new ArrayList<>();

        System.out.println(list.getClass() == list2.getClass()); // 类型擦除

        // list2.add(new Foo()); 有上界的啥也放不进去，
        // list2.add(new Foo2());// 子类也别想

        List<Foo> list4 = new ArrayList<>();// 正常做法
        list4.add(new Foo2()); // 正常做法

        List<? super Foo2> list5 = new ArrayList<>(); // 合法
        // list5.add(new Foo()); // 非法
        list5.add(new Foo2());  // 放得进去
        Object res = list5.get(0);  // 会丢失所有的类型信息，只有Object能够承载



        List<Foo> list3 = new ArrayList<Foo>();
        list3.add(new Foo("123"));
        list2 =list3; // 这样倒是有用
        // list2.add(new Foo()); 有上界的还是啥也放不进去，
        System.out.println(list2.get(0).fooString); // 拿倒是可以拿

        Point2<String> point2 = new Point2<>();
        Point3 point3 = new Point3<>();
        Field[] fields2 = point2.getClass().getDeclaredFields();
        for(Field field: fields2){
            System.out.println(field.getType().getName()); // Object
        }

        Field[] fields3 = point3.getClass().getDeclaredFields();
        for(Field field: fields3){
            System.out.println(field.getType().getName()); // 擦除只到Foo
        }
        System.out.println("end");
    }
}
class Point3<T extends Foo> {
    private T x;
    private T y;

    public void setX(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getY() {
        return y;
    }
}


class Point2<T> {
    private T x;
    private T y;

    public void setX(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getY() {
        return y;
    }
}

//class Point4<T super Foo2> {
//    private T x;
//    private T y;
//
//    public void setX(T x) {
//        this.x = x;
//    }
//
//    public T getX() {
//        return x;
//    }
//
//    public void setY(T y) {
//        this.y = y;
//    }
//
//    public T getY() {
//        return y;
//    }
//}