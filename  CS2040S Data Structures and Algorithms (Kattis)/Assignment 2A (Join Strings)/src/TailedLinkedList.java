class TailedLinkedList implements ListInterface {
  // attributes
  public ListNode head;
  public ListNode tail;
  public int num_nodes;

  // interface methods

  // Return true if list is empty; otherwise return false.
  public boolean isEmpty() { return (num_nodes == 0); }

  // Return number of items in list
  public int size() { return num_nodes; }

  // return index of item if item is found in the list, otherwise return -1
  public int indexOf(String item) {
    int index = 0;

    for (ListNode cur = head; cur != null; cur = cur.getNext()) {
      if (cur.getItem() == item) 
        return index;
      else 
        index++;
    }
    return -1;
  }

  // return true if item is in the list false otherwise
  public boolean contains(String item) {
    if (indexOf(item) != -1)
      return true;
    return false;
  }

  // get item at index
  public String getItemAtIndex(int index) {
    ListNode cur = head;

    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }    
    if (index == size()-1)
      return tail.getItem();
    else {
      for (int counter = 0; counter != index; counter++)
        cur = cur.getNext();
      return cur.getItem();
    }
  }

  // Return first item
  public String getFirst() { return getItemAtIndex(0); }

  // Return last item
  public String getLast() { return getItemAtIndex(size()-1); }

  // add item at position index, shifting all current items from index onwards to the right by 1 
  // pre: 0 <= index <= size()
  public void addAtIndex(int index, String item) {
    ListNode cur;
    ListNode newNode = new ListNode(item);

    if (index >= 0 && index <= size()) {
      if (index == 0) // insert in front
        insert(null,newNode);
      else if (index == size()) // insert at the back, don't have to move all the way to the back
        insert(tail,newNode);
      else {
        cur = getNodeAtIndex(index-1); // access node at index-1
        insert(cur,newNode);
      }
    }
    else { // index out of bounds
      System.out.println("invalid index");
      System.exit(1);
    }
  } 

  // Add item to front of list
  public void addFront(String item) { addAtIndex(0,item); }

  // Add item to back of list
  public void addBack(String item) { addAtIndex(size(),item); }

  // remove item at index and return it
  // pre: 0 <= index < size()
  public String removeAtIndex(int index) {
    ListNode cur;
    String item = "";

    // index within bounds and list is not empty
    if (index >= 0 && index < size()) {
      if (index == 0) // remove 1st item
        item = remove(null);
      else {
        cur = getNodeAtIndex(index-1); // access node at index-1
        item = remove(cur);
      }
    }
    else { // index out of bounds
      System.out.println("invalid index or list is empty");
      System.exit(1);
    }
    return item;
  }

  // Remove first node of list
  public String removeFront() { return removeAtIndex(0); }

  // Remove last node of list
  public String removeBack() { return removeAtIndex(size()-1); }

  // Print values of nodes in list.
  public void print() {
      ListNode cur = head;
      System.out.print(cur.getItem());
      for (int i=1; i < num_nodes; i++) {
        cur = cur.getNext();
        System.out.print(cur.getItem());
      }
  }

  // non-interface helper methods
  public ListNode getHead() { return head; }
  public ListNode getTail() { return tail; }

  /* return the ListNode at index */
 public ListNode getNodeAtIndex(int index) {
    ListNode cur = head;

    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }    
    for (int counter = 0; counter != index; counter++)
      cur = cur.getNext();

    return cur;
  }

  public ListNode getLastNode() {
   return tail;
  }

  // insert newNode after the node referenced by cur 
  public void insert(ListNode cur, ListNode n) {
    // insert in front
    if (cur == null) {
      n.setNext(head);
      head = n; // update head
      if (tail == null) // update tail if list originally empty
        tail = head;
    }
    else { // insert anywhere else
      n.setNext(cur.getNext());
      cur.setNext(n);
      if (cur == tail) // update tail if inserted new last item
        tail = tail.getNext();
    }
    num_nodes++;
  }

  // remove the node referenced by cur.next, and return the item in the node 
  // if cur == null, remove the first node 
  public String remove(ListNode cur) {
    String value;

    if (cur == null) { // remove 1st node
      value = head.getItem();
      head = head.getNext(); // update head
      if (num_nodes == 1) // update tail to null if only item in list is removed
        tail = null;
    }
    else { // remove any other node
      value = cur.getNext().getItem();
      cur.setNext(cur.getNext().getNext());
      if (cur.getNext() == null) // update tail if last item is removed
        tail = cur;
    }
    num_nodes--;

    return value;
  }

  //Set pointer of last node of current linked list to point to head of linked list b
  //Set last node of current linked list to the last node of linked list b
  //Update the number of nodes for the new appended linked list
  public void append(TailedLinkedList b) {
   this.tail.setNext(b.head);
   this.tail = b.tail;
   this.num_nodes = this.num_nodes + b.num_nodes;
  }

  //For debugging purposes
  @Override
  public String toString() {
    return "{" +
            "head=" + head +
            ", num_nodes=" + num_nodes +
            '}';
  }

}
