package priceton.unionfind;

import princeton.std.StdIn;
import princeton.std.StdOut;
import princeton.unionfind.QuickFindUF;
import princeton.unionfind.QuickUnionUF;
import princeton.unionfind.UF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DynamicConnectivity {

    public static void main(String[] args) {
        setStdIn("E:\\algorithm\\src\\test\\java\\priceton\\unionfind\\tinyUF.txt");

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

        setStdIn("E:\\algorithm\\src\\test\\java\\priceton\\unionfind\\testUF.txt");
        String answer = StdIn.readLine();
        StdOut.println(answer);

        while (!StdIn.isEmpty()) {
            int q = StdIn.readInt();
            int p = StdIn.readInt();
            StdOut.print(uf.connected(p, q) + " ");
        }
    }

    private static void setStdIn(String path) {
        try {
            FileInputStream input = new FileInputStream(path);
            System.setIn(input);
            StdIn.resync();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
