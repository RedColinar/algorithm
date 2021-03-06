package princeton.unionfind;

public class QuickFindUF extends UF {

    final private int[] id;

    public QuickFindUF(int capacity) {
        super(capacity);
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
