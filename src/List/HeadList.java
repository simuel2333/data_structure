package List;

/**
 * 带头结点的链表
 *
 * @param <T>
 * @author huangcheng
 */
public class HeadList<T> {

    private class Node<T> {
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.element = null;
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;

    public HeadList() {
        head = new Node<>();
    }

    /**
     * 尾插
     *
     * @param element fds
     */
    public void append(T element) {
        Node node = head;
        while (node.getNext() != null) node = node.getNext();
        node.setNext(new Node(element));
    }

    /**
     * 头插
     *
     * @param element
     */
    public void insert(T element) {
        Node node = new Node(element, head.getNext());
        head.setNext(node);
    }

    public boolean isEmpty() {
        if (head.getNext() == null)
            return true;
        else
            return false;
    }

    public int size() {
        Node node = head;
        int size = 0;
        while (node.getNext() != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > Integer.MAX_VALUE) {
            throw new Exception("out of border");
        }
        Node node = head;
        int i = 0;
        while (node.getNext() != null) {
            node = node.getNext();
            if (i == index) {
                return (T) node.getElement();
            }
            i++;
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        HeadList<Integer> list = new HeadList<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
