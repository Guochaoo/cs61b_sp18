public class LinkedListDeque<T> {
    public class TNode {
        private TNode prev;
        private T item;
        private TNode next;

        public TNode(TNode m, T i, TNode n) {
            prev = m;
            item = i;
            next = n;

        }
    }

    private TNode first;
    private int size;
    //哨兵
    private TNode sentinel = new TNode(null, null, null);


    public LinkedListDeque(T x) {
        first = new TNode(sentinel, x, null);
        sentinel.next = first;
        size = 1;
    }

    public LinkedListDeque() {
        first = null;
        size = 0;
    }

    public void addFirst(T x) {
        first = new TNode(sentinel, x, first);
        sentinel.next = first;
        size += 1;
    }

    public void addLast(T x) {
        TNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new TNode(p, x, null);
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        TNode p = first;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }


    public T removeFirst() {
        T temp = first.item;
        first.prev = null;
        first = first.next;
        size -= 1;
        return temp;
    }

    public T removeLast() {
        TNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        T temp = p.item;
        p = p.prev;
        p.next = null;
        size -= 1;
        return temp;
    }

    public T get(int index) {
        TNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return p.item;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public TNode getp = sentinel.next;
    public int num = 0;

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        if (num == index) {
            T temp = getp.item;
            getp = sentinel.next;
            num = 0;
            return temp;
        } else {
            num++;
            return getRecursive(index);
        }
    }
}
