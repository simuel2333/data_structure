package disjointSets;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集是一种树形的数据结构，用来处理一些不交集合并及查询的问题。
 * 有一个联合查找算法定义了两个用于此数据结构的操作：Find:确定元素属于哪一个子集，Union：合并两个子集。
 */
public class DisjointSets {

    private Map<Integer, Integer> parent = new HashMap<>(); //key:当前顶点，value：父节点
    private Map<Integer, Integer> rank = new HashMap<>(); //key:当前顶点，value：当前节点的高

    public boolean hasCircle(int[][] edges) {
        //构造parent树
        initialize(edges);

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) return true;
        }
        return false;
    }

    private void initialize(int[][] edges) {
        for (int[] edge : edges) {
            for (int v : edge) {
                parent.putIfAbsent(v, -1);
                rank.putIfAbsent(v, 0); //高的初值为0.
            }
        }
    }

    /**
     * 查找根节点
     *
     * @return root(x)
     */
    private int find(int val) {
        int root = val;
        if (parent.get(root) != -1) {
            root = parent.get(root);
        }
        return root;
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return true;
        if (rank.get(rootX) > rank.get(rootY)) {
            parent.put(rootY, rootX);
        } else if (rank.get(rootX) < rank.get(rootY)) {
            parent.put(rootX, rootY);
        } else {
            parent.put(rootY, rootX);
            rank.merge(rootX, 1, Integer::sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}, {3, 5}, {4, 6}, {5,6}};
        DisjointSets disjointSets = new DisjointSets();
        System.out.println(disjointSets.hasCircle(edges));
    }
}
