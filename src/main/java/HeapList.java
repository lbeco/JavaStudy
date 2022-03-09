import java.util.AbstractList;

public class HeapList <E> extends AbstractList<E> {
    Object[] val;
    int size;
    public void HeapList(){
        size = 16;
        val = new Object[size];
    }
    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(int index, E element) {
        super.add(index, element);
    }

    public static void main(String[] args) {

    }
}
