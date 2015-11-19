package chapter1.partial1.union_find;

import libs.StdIn;

/**
 * Fast Find
 * in [0, 1, 2, 3]
 * out for {2 3,0 3} -> [3, 1, 3, 3] 2 components
 */
public class FastFind extends UnionFind {
    public FastFind(int N)
    {
        super(N);
    }

    public int find(int p)
    {
        return id[p];
    }

    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;

        count--;
    }

    public static void main(String[] args)
    {
        int N  = StdIn.readInt();
        FastFind ff = new FastFind(N);
        ff.test();
    }
}
