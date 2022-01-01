//Adapted from Lecture notes for union find disjoint sets.
public class UnionFind {
    int[] p;
    int[] rank;

    UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    int findSet(int i) {
        if(p[i] == i) {
            return i;
        } else {
            p[i] = findSet(p[i]);
            return p[i];
        }
    }

    boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    void unionSet(int i, int j) {
        if(!isSameSet(i, j)) {
            int x = findSet(i);
            int y = findSet(j);

            if(rank[x] > rank[y]) {
                p[y] = x;
            } else {
                p[x] = y;
                if(rank[x] == rank[y]) {
                    rank[y] = rank[y] + 1;
                }
            }
        }
    }

}
