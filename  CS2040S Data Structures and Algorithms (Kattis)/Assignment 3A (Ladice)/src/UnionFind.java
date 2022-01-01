import java.util.ArrayList;

class UnionFind {
    private int[] p;
    private int[] rank;
    private ArrayList<Characteristic> characteristic;

    //Added characteristic array list which contains Characteristic objects.
    UnionFind(int N) {
        this.p = new int[N];
        this.rank = new int[N];
        this.characteristic = new ArrayList<Characteristic>();
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
            characteristic.add(new Characteristic(1,0));
        }
    }

    //From Lecture notes.
    int findSet(int i) {
        if (p[i] == i)
            return i;
        else {
            p[i] = findSet(p[i]);
            return p[i];
        }
    }

    //From Lecture notes.
    boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    /*Modified, where if y is added under x then x's size and itemCount should add y's
    size and itemCount too. Vice versa for if x is added under y.*/
    void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                p[y] = x;
                Characteristic charY = characteristic.get(y);
                Characteristic charX = characteristic.get(x);
                charX.setSize(charX.getSize() + charY.getSize());
                charX.setItemCount(charX.getItemCount() + charY.getItemCount());
            } else {
                p[x] = y;
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y] + 1;
                }
                Characteristic charX = characteristic.get(x);
                Characteristic charY = characteristic.get(y);
                charY.setSize(charY.getSize() + charX.getSize());
                charY.setItemCount(charY.getItemCount() + charX.getItemCount());
            }
        }
    }

    //Getter for characteristic arraylist.
    ArrayList<Characteristic> getCharacteristic() {
        return this.characteristic;
    }

    //Determines if item can be added to drawer or not.
    boolean canAddOrNot(int parent) {
        Characteristic charTemp =  this.getCharacteristic().get(parent);
        int size = charTemp.getSize();
        int itemCount = charTemp.getItemCount();
        return size > itemCount;
    }

    //Simulates the addition of item to the drawer.
    void addedItem(int parent) {
        Characteristic charTemp =  this.getCharacteristic().get(parent);
        int itemCount = charTemp.getItemCount();
        charTemp.setItemCount(itemCount + 1);
    }
}
