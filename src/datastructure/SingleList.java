package datastructure;

public class SingleList {
    int N = 1010;

    int head, idx;
    int[] e = new int[N];
    int[] ne = new int[N];

    public void init() {
        head = -1;
        idx = 0;
    }
    //在链表头插入一个节点
    public void insert(int a) {
        e[idx] = a;
        ne[idx] = head;
        head = idx++;
    }

    //将头节点删除
    public void remove() {
        head = ne[head];
    }

}
