public class AVL {
        //Attribute.
        public Vertex root;

        //Constructor for AVL.
        public AVL() {
            this.root = null;
        }

        //Modified from lecture notes.
        // helper method to perform search
        public Vertex search(Vertex T, Group v) {
            if (T == null) {
                return null;                     // not found
            }
            int determinant = new GroupComparator().compare(v, T.key);
            if (determinant > 0) {
                return search(T.left, v);                        // found
            } else if (determinant < 0) {
                return search(T.right, v);       // search to the right
            } else {
                return T;        // search to the left
            }
        }

        //Modified from lecture notes.
        // helper method to perform findMin
        // Question: What happens if BST is empty?
        public Group findMin(Vertex T) {
            if (T.left == null) {
                return T.key;                    // this is the min
            } else {
                return findMin(T.left);           // go to the left
            }
        }

        //Modified from lecture notes.
        // public method to find successor to given value v in BST.
        public Group successor(Group v) {
            Vertex vPos = search(this.root, v);
            return vPos == null ? null : successor(vPos);
        }

        //Modified from lecture notes.
        // helper recursive method to find successor to for a given vertex T in BST
        public Group successor(Vertex T) {
            if (T.right != null)                       // this subtree has right subtree
                return findMin(T.right);  // the successor is the minimum of right subtree
            else {
                Vertex par = T.parent;
                Vertex cur = T;
                // if par(ent) is not root and cur(rent) is its right children
                while ((par != null) && (cur.isEqual(par.right))) {
                    cur = par;                                         // continue moving up
                    par = cur.parent;
                }
                return par == null ? null : par.key;           // this is the successor of T
            }
        }

        //Modified from lecture notes.
        // public method called to insert a new key with value v into BST
        public void insert(Group v) { this.root = insert(this.root, v); }

        //Modified from lecture notes.
        // helper recursive method to perform insertion of new vertex into BST
        public Vertex insert(Vertex T, Group v) {
            if (T == null) {
                return new Vertex(v);          // insertion point is found
            }

            int determinant = new GroupComparator().compare(v, T.key);
            if (determinant < 0) {                                      // search to the right
                T.right = insert(T.right, v);
                T.right.parent = T;
            } else {                                                 // search to the left
                T.left = insert(T.left, v);
                T.left.parent = T;
            }

            T.maintainHeight();
            T.maintainSize();
            T = balance(T);
            return T;                                          // return the updated BST
        }

        //Modified from lecture notes.
        // public method to delete a vertex containing key with value v from BST
        public void delete(Group v) { this.root = delete(this.root, v); }

        //Modified from lecture notes.
        // helper recursive method to perform deletion
        public Vertex delete(Vertex T, Group v) {
            if (T == null) { return null;}              // cannot find the item to be deleted

            int determinant = new GroupComparator().compare(v, T.key);
            if (determinant < 0) {                                // search to the right
                T.right = delete(T.right, v);
            } else if (determinant > 0) {                               // search to the left
                T.left = delete(T.left, v);
            } else {                                            // this is the node to be deleted
                if (T.left == null && T.right == null) {                  // this is a leaf
                    T = null;                                      // simply erase this node
                } else if (T.left == null) {   // only one child at right
                    T.right.parent = T.parent;
                    T = T.right;                                                 // bypass T
                } else if (T.right == null) {    // only one child at left
                    T.left.parent = T.parent;
                    T = T.left;                                                  // bypass T
                } else {                                 // has two children, find successor
                    Group successorV = successor(v);
                    T.key = successorV;         // replace this key with the successor's key
                    T.right = delete(T.right, successorV);      // delete the old successorV
                }
            }
            if(T != null) {
                T.maintainHeight();
                T.maintainSize();
            }
            T = balance(T);
            return T;                                          // return the updated BST
        }

        //Calculates the balance factor for a given vertex.
        int balanceFactor(Vertex T) {
            if (T == null) {
                return 0;
            } else {
                if(T.left != null && T.right != null) {
                    return T.left.height - T.right.height;
                } else if(T.left != null) {
                    return T.left.height;
                } else if(T.right != null) {
                    return -T.right.height;
                } else {
                    return 0;
                }
            }
        }

        //Left rotation for a particular vertex.
        Vertex rotateLeft (Vertex T) {
            if(T == null || T.right == null) {
                return null;
            }
            Vertex w = T.right;
            w.parent = T.parent;
            T.parent = w;
            T.right = w.left;
            if (w.left != null) {
                w.left.parent = T;
            }
            w.left = T;
            T.maintainHeight();
            T.maintainSize();
            w.maintainHeight();
            w.maintainSize();

            return w;
        }

        //Right rotation for a particular vertex.
        Vertex rotateRight (Vertex T) {
            if(T == null || T.left == null) {
                return null;
            }
            Vertex w = T.left;
            w.parent = T.parent;
            T.parent = w;
            T.left = w.right;
            if (w.right != null) {
                w.right.parent = T;
            }
            w.right = T;
            T.maintainHeight();
            T.maintainSize();
            w.maintainHeight();
            w.maintainSize();

            return w;
        }

        //Balances a given vertex.
        Vertex balance(Vertex T) {
            int factor = balanceFactor(T);
            if(factor == 2){
                if(balanceFactor(T.left) == -1) {
                    T = leftRight(T);
                } else {
                    T = leftLeft(T);
                }
            } else if(factor == -2) {
                if(balanceFactor(T.right) == 1) {
                    T = rightLeft(T);
                } else {
                    T = rightRight(T);
                }
            }
            return T;
        }

        //Left - Left combination case.
        Vertex leftLeft(Vertex T) {
            T = rotateRight(T);
            return T;
        }

        //Left - Right combination case.
        Vertex leftRight(Vertex T) {
            T.left = rotateLeft(T.left);
            T = rotateRight(T);
            return T;
        }

        //Right - Right combination case.
        Vertex rightRight(Vertex T) {
            T = rotateLeft(T);
            return T;
        }

        //Right - Left combination case.
        Vertex rightLeft(Vertex T) {
            T.right = rotateRight(T.right);
            T = rotateLeft(T);
            return T;
        }

        //Calculates the number of groups that are below a given group.
        int findRank(Group team, Vertex T) {
            int determinant = new GroupComparator().compare(team, T.key);
            if (determinant == 0) {
                return T.left == null ? 1 : T.left.size + 1;
            } else if (determinant > 0) {
                return findRank(team, T.left);
            } else {
                return T.left == null ? 1 + findRank(team, T.right) : T.left.size + 1 + findRank(team, T.right);
            }
        }

        /*Using the total number of groups, calculate the rank by taking the difference between the
        total number of groups and the number of groups below the given group. Account for the over subtraction
        of 1 by adding back 1.*/
        int rank(Group team, int total) {
            return total - findRank(team, this.root) + 1;
        }
}
