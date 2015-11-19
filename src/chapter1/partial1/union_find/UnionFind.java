package chapter1.partial1.union_find;

import libs.StdIn;
import libs.StdOut;

/**
 * UnionFind
 */
public abstract class UnionFind {
    protected int[] id;
    protected int count;

    public UnionFind(int N)
    {
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);

    public void test()
    {
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (connected(p, q)) continue;

            union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(count() + " components");

        for (int i = 0; i < id.length; i++)
            StdOut.print(id[i] + ' ');

        StdOut.println();
    }
}
