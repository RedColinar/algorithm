import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.LinkedList;
import java.util.List;

/**
 * 200 trails: percolation cost:0.8s
 * mean                    =0.5930779999999998
 * stddev                  =0.026163373762440607
 * 95% confidence interval =[0.5894519413947964,0.5967040586052031]
 *
 * with path compress
 * 200 trails: percolation cost:0.786s
 * mean                    =0.5903359999999999
 * stddev                  =0.025336788832480504
 * 95% confidence interval =[0.5868245002213999,0.5938474997785999]
 * 200 trails:0.788s
 *
 * */
public class PercolationStats {

    private int n;
    private int trials;
    private double[] results;
    private double mMean;
    private double mStddev;

    private List<Integer> openIndex = new LinkedList<>();

    /**
     * n 表示 n * n trials 表示试验次数
     **/
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 1) throw new IllegalArgumentException();
        this.n = n;
        this.trials = trials;
        results = new double[trials];

        starStat();
    }

    private void starStat() {
        long s = System.currentTimeMillis();
        for (int i = 0; i < trials; i++) {
            initOpenIndex();
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int index = StdRandom.uniform(openIndex.size());
                int mOpenIndex = openIndex.get(index);

                int row = mOpenIndex / n + 1;
                int col = (mOpenIndex % n) + 1;

                openIndex.remove(index);
                percolation.open(row, col);
            }
            results[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        long e = System.currentTimeMillis();
        StdOut.println(trials + " trails: percolation cost:" + (e - s) / 1000.0 + "s");

        mMean = meanInter();
        mStddev = stddevInter();

        StdOut.println("mean                    =" + mMean);
        StdOut.println("stddev                  =" + mStddev);
        StdOut.println("95% confidence interval =[" + confidenceLo() + "," + confidenceHi() + "]");
    }

    private void initOpenIndex() {
        openIndex.clear();
        for (int i = 0; i < n * n; i++) {
            openIndex.add(i);
        }
    }

    public double mean() {
        return mMean;
    }

    private double meanInter() {
        double mean = 0.0;
        for (int i = 0; i < results.length; i++) {
            mean += results[i];
        }
        return mean / results.length;
    }

    public double stddev() {
        return mStddev;
    }

    private double stddevInter() {
        double s = 0.0;
        for (int i = 0; i < results.length; i++) {
            s += (results[i] - mMean) * (results[i] - mMean);
        }
        return Math.sqrt(s / (results.length - 1));
    }

    public double confidenceLo() {
        return mMean - 1.96 * mStddev / Math.sqrt(results.length);
    }

    public double confidenceHi() {
        return mMean + 1.96 * mStddev / Math.sqrt(results.length);
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int t = Integer.valueOf(args[1]);
        new PercolationStats(n, t);
    }
}