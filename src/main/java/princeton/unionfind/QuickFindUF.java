package princeton.unionfind;

public class QuickFindUF extends UF {

    public QuickFindUF(int capacity) {
        super(capacity);

    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }
}
