package princeton.unionfind;

public class QuickUnionUF extends UF {

    final private int[] id;

    public QuickUnionUF(int capacity) {
        super(capacity);
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
