package princeton.unionfind;

import princeton.std.StdIn;
import princeton.std.StdOut;

import java.io.*;

public class DynamicConnectivity {

    public static void main(String[] args) {
        System.setIn(ClassLoader.getSystemResourceAsStream("princeton/unionfind/tinyUF.txt"));
        StdIn.resync();

        int N = StdIn.readInt();
        // UF uf = new QuickFindUF(N);
        UF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int q = StdIn.readInt();
            int p = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
        }

        System.setIn(ClassLoader.getSystemResourceAsStream("princeton/unionfind/testUF.txt"));
        StdIn.resync();
        String answer = StdIn.readLine();
        StdOut.println(answer);

        while (!StdIn.isEmpty()) {
            int q = StdIn.readInt();
            int p = StdIn.readInt();
            StdOut.print(uf.connected(p, q) + " ");
        }
    }
}
