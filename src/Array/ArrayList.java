package Array;


import java.util.Arrays;

/**
 * @param <E> 支持动态扩容和动态增删改
 * @author hc
 */
public class ArrayList<E> {
    private int size = 0;
    private Object elementData[];
    private static final Object[] EMPTYP_ARRAY = {};
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.elementData = EMPTYP_ARRAY;
    }

    public ArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }


    public boolean add(E e) {
        grow(size);
        elementData[size++] = e;
        return true;
    }

    public int remove(Object e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (e.equals(elementData[i])) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.remove(index);
        }
        return index;
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elementData[i] = elementData[i + 1];
            }
            elementData[--size] = null;
            return true;
        }
        return false;
    }

    public E instead(E e, int index) {
        E oldE = (E) elementData[index];
        elementData[index] = e;
        return oldE;
    }

    private int oldCapacity;

    private void grow(int capacity) {
        if (elementData == EMPTYP_ARRAY) {
            elementData = new Object[DEFAULT_CAPACITY];
            oldCapacity = DEFAULT_CAPACITY;
        }
        if (capacity >= oldCapacity) {
            System.out.print("扩容前:" + oldCapacity);
            capacity = oldCapacity + (capacity >> 1); //扩容1.5倍
            System.out.println(" 扩容后:" + capacity);
            oldCapacity = capacity;
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = 5;
        for (int i = 0; i < 100; i++) {
            list.add(new Integer(i));
        }
    }

}
