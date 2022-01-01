public class Vertex {

    //Attributes for each vertex in AVL.
    public Group key;
    public int height;
    public int size;
    public Vertex parent;
    public Vertex left;
    public Vertex right;

    //Constructor for each vertex.
    Vertex(Group v) {
        this.key = v;
        this.parent = this.left = this.right = null;
        this.height = 0;
        this.size = 1;
    }

    //Checks if two vertices are the same.
    boolean isEqual(Vertex v) {
        return this.key.teamNum == v.key.teamNum;
    }

    //Maintains the height for the particular vertex.
    void maintainHeight() {
        if(this.right != null && this.left != null) {
            this.height = Math.max(this.left.height , this.right.height) + 1;
        } else if(this.right != null) {
            this.height = this.right.height + 1;
        } else if(this.left != null) {
            this.height = this.left.height + 1;
        } else {
            this.height = 0;
        }
    }

    //Maintains the size for the particular vertex.
    void maintainSize() {
        if(this.right != null && this.left != null) {
            this.size = this.left.size + this.right.size + 1;
        } else if(this.right != null) {
            this.size = this.right.size + 1;
        } else if(this.left != null) {
            this.size = this.left.size + 1;
        } else {
            this.size = 1;
        }
    }
}
