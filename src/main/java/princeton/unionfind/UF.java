package princeton.unionfind;

public abstract class UF {

    UF(int capacity) {}

    public abstract void union(int p, int q);

    public abstract boolean connected(int p, int q);

    // int find(int p);

    // int count();
}
