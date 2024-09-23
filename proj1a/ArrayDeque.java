public class ArrayDeque<T> {
    private int size;
    T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void resize(int capacity) {

        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;


    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {

        return size;
    }

    public void printDeque() {

        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {

        T temp = items[0];
        T[] a = (T[]) new Object[size + 1];
        System.arraycopy(items, 1, a, 0, size);
        items = a;
        size -= 1;
        return temp;
    }

    public T removeLast() {
        T temp = items[size - 1];
        size -= 1;
        items[size] = null;
        return temp;
    }

    public T get(int index) {
        return items[index];
    }
}
