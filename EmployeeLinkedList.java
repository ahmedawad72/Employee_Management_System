package projectds;
 
 
public class EmployeeLinkedList {
private class Node  {
    private Employee item;
    private Node next;
     
    //constructor
    public Node(){
        // NO arg constructor
    }
    public Node(Employee item, Node next) {
        this.item = item;
        this.next = next;
    }
}
 
  private Node head=null;
  private int length=0;
  public boolean insert(Employee employee){
      Node newNode =new Node ();
      newNode.item=employee;
      if(length==0) {
          head=newNode;
          newNode.next=null;
      }
      else {
          newNode.next=head;
          head=newNode;
      }
      length++;
      return true;
  }
 
  public boolean delete(String employee_name) {
        if( length==0) {
            return false;
        }
        else if(head.item.getName().equals(employee_name)) {
            head = head.next;
            length--;
            return true;
        }
        else{
            Node previous = head, current = head.next;
 
            while(current != null) {
 
                if(current.item.getName().equals(employee_name)) {
                    previous.next = current.next;
                    length--;
                    current = current.next;
                    previous = previous.next;
                    return true;

                }

            }
        } return false;
    }
  public Employee linear_search(String employee_name) {
        if(length==0)
            return null;
 
        Node current = head;
        while(current != null) {
            if(current.item.getName().equals(employee_name)) {
                return current.item;
            }
            current = current.next;
        }
        return null;
    }
 
    public void bubble_ascending_sort_by_name(){
        if (length > 1) {
            for (int i = 0; i < length; i++ ) {
                Node current = head;
                Node nextNode= head.next;
                for (int j = 0; j < length - 1; j++) {
                    if (current.item.compareTo( nextNode.item)) {
                        Employee temp = current.item;
                        current.item = nextNode.item;
                        nextNode.item = temp;
                    }
                    current = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }
 
    public void bubble_descending_sort_by_name(){
        if (length > 1) {
            for (int i = 0; i < length; i++ ) {
                Node current = head;
                Node nextNode= head.next;
                for (int j = 0; j < length - 1; j++) {
                    if (nextNode.item.compareTo( current.item)) {
                        Employee temp = current.item;
                        current.item = nextNode.item;
                        nextNode.item = temp;
                    }
                    current = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }
 
    public void bubble_ascending_sort_by_ID(){
        if (length > 1) {
            for (int i = 0; i < length; i++ ) {
                Node current = head;
                Node nextNode= head.next;
                for (int j = 0; j < length - 1; j++) {
                    if (current.item.getId() > nextNode.item.getId()){
                        Employee temp = current.item;
                        current.item = nextNode.item;
                        nextNode.item = temp;
                    }
                    current = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }
 
    public void bubble_descending_sort_by_ID(){
        if (length > 1){
            for (int i = 0; i < length; i++) {
                Node current = head;
                Node nextNode= head.next;
                for (int j = 0; j < length - 1; j++) {
                    if (nextNode.item.getId() >current.item.getId()) {
                        Employee temp = current.item;
                        current.item = nextNode.item;
                        nextNode.item = temp;
                    }
                    current = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }
 
 
 
    public void selection_ascending_sort_by_name() {
        Node current = head;
 
        while (current != null) {
            Node min = current;
            Node nextNode = current.next;
 
            while (nextNode != null) {
                if (min.item.compareTo(nextNode.item))
                    min = nextNode;
 
                nextNode = nextNode.next;
            }
 
            Employee temp = current.item;
            current.item = min.item;
            min.item = temp;
            current = current.next;
        }
    }
     public void selection_descending_sort_by_name() {
        Node current = head;
 
        while (current != null) {
            Node min = current;
            Node nextNode = current.next;
 
            while (nextNode != null) {
                if (nextNode.item.compareTo(min.item))
                    min = nextNode;
 
                nextNode = nextNode.next;
            }
 
            Employee temp = current.item;
            current.item = min.item;
            min.item = temp;
            current = current.next;
        }
    }
 
    public void selection_ascending_sort_by_ID() {
        Node current = head;
 
        while (current != null) {
            Node min = current;
            Node nextNode = current.next;
 
            while (nextNode != null) {
                if (min.item.getId() > nextNode.item.getId())
                    min = nextNode;
 
                nextNode = nextNode.next;
            }
            Employee temp = current.item;
            current.item = min.item;
            min.item = temp;
            current = current.next;
        }
    }
    public void selection_descending_sort_by_ID() {
        Node current = head;
 
        while (current != null) {
            Node min = current;
            Node nextNode = current.next;
 
            while (nextNode != null) {
                if (nextNode.item.getId() > min.item.getId())
                    min = nextNode;
 
                nextNode = nextNode.next;
            }
            Employee temp = current.item;
            current.item = min.item;
            min.item = temp;
            current = current.next;
        }
    }
 
    public void display(){
        Node cur =head;
        while(cur!=null)
        {
            System.out.println(cur.item.line());
            cur=cur.next;
        }
    }
    public int size(){
        return length;
    }
    public Employee get(int index) {
           if(index < 0 || index >= length) 
               return null;
 
           Node current = head;
           while (index-- != 0)
               current = current.next;
 
           return current.item;
       }
}