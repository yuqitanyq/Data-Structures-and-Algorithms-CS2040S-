class Characteristic {
    private int size;
    private int itemCount;

    //Constructor.
    Characteristic(int size, int itemCount) {
        this.size = size;
        this.itemCount = itemCount;
    }

    //Getter for size.
    int getSize() {
        return this.size;
    }

    //Getter for itemCount.
    int getItemCount() {
        return this.itemCount;
    }

    //Setter for size of Characteristic object.
    void setSize(int newSize) {
        this.size = newSize;
    }

    //Setter for itemCount of Characteristic object.
    void setItemCount(int newCount) {
        this.itemCount = newCount;
    }
}
