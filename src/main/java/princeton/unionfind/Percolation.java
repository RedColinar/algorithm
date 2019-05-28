package princeton.unionfind;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class Percolation {

    private final int n;
    private final int[] squareOpen;
    private final int[] squareConn;
    private int openNum = 0;
    private final int size;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.n = n;
        size = n * n;
        squareOpen = new int[size];
        squareConn = new int[size + 2];
        // squareConn[size] and squareConn[size + 1] are top and bottom

        for (int i = 0; i < n; i++) {
            squareConn[i] = size;
        }

        for (int i = n; i < size - n; i++) {
            squareConn[i] = i;
        }

        for (int i = size - n; i < size; i++) {
            squareConn[i] = size + 1;
        }

        squareConn[size] = size;
        squareConn[size + 1] = size + 1;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        check(row, col);
        if (!isOpen(row, col)) {
            squareOpen[getIndex(row, col)] = 1;
            openNum++;

            if (col != 1 && isOpen(row, col - 1)) union(getIndex(row, col - 1), getIndex(row, col));
            if (col != n && isOpen(row, col + 1)) union(getIndex(row, col + 1), getIndex(row, col));
            if (row != 1 && isOpen(row - 1, col)) union(getIndex(row - 1, col), getIndex(row, col));
            if (row != n && isOpen(row + 1, col)) union(getIndex(row + 1, col), getIndex(row, col));
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        check(row, col);
        return squareOpen[getIndex(row, col)] == 1;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        check(row, col);
        return false;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openNum;
    }

    // does the system percolate?
    public boolean percolates() {
        return root(size) == root(size + 1);
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private void check(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException();
    }

    private void union(int i1, int i2) {
        squareConn[root(i1)] = root(i2);
    }

    private int root(int i) {
        while (i != squareConn[i]) {
            i = squareConn[i];
        }
        return i;
    }
}
