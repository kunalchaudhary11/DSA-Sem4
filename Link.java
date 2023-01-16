// class Student for storing name rollno percentage
class Student {
    private String name;
    private String roll;
    private double pct;

    Student(String n, String r, double p) {
        name = n;
        roll = r;
        pct = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public double getPct() {
        return pct;
    }

    public void setPct(double pct) {
        this.pct = pct;
    }

    public static void main(String[] args) {
    }
}




// Main Class
public class Link {

    Node head;
    int length;

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;

        }

    }

    // display function for print data
    public void display() {
        Node p = head;
        while (p != null) {
            System.out.print("Name:"+p.data.getName() + " , Roll no:" + p.data.getRoll() + " , Percentage:" + p.data.getPct() + " ---> ");
            p = p.next;
        }
        System.out.println("null");
    }
    
    // addFirst function 
    public void addFirst(Student x) {
        Node p = new Node(x);
        length++;
        if (head == null) {
            head = p;

        } else {
            p.next = head;
            head = p;
        }

    }
 // delete at function 
    public void deleteAt(String r) {
        Node p = head;
        while (p.next != null) {

            if (p.next.data.getRoll() == r) {
                break;
            }
            p = p.next;
        }
        length--;
        p.next = p.next.next;
    }


    // set At function
    public void setAt(String r, double pct) {

        Node p = head;
        while (p.next != null) {

            if (p.next.data.getRoll() == r) {
                p.next.data.setPct(pct);
                break;
            }
            p = p.next;
        }
    }


    // Add Sorted Function 
    public void addSorted(Node new_node)
    {
        Node current;
  
      // To check Special Case
        if (head == null || head.data.getPct() >= new_node.data.getPct()) {
            new_node.next = head;
            head = new_node;
        }
        else {
  
         // Locate the Node
            current = head;
  
            while (current.next != null && current.next.data.getPct() < new_node.data.getPct()) {
                
              current = current.next;
            }
                  
            new_node.next = current.next;
            current.next = new_node;
        }
    }
    /* Function to create a node */
    Node newNode(Student data)
    {
        Node x = new Node(data);
        return x;
    }


// Main Function 
    public static void main(String[] args) {
        Student s2 = new Student("Kanishk Patel", "26", 90);
        Student s1 = new Student("Kunal", "63", 97);
        Student s3 = new Student("Ritik", "46", 88);
        Student s4 = new Student("anuj", "18", 67);
        Student s5 = new Student("Aayush", "12", 98);

        Link sl = new Link();
        sl.addFirst(s3);
        sl.addFirst(s4);
        sl.addFirst(s1);
        sl.addFirst(s5);
        sl.addFirst(s2);
        sl.display();
        sl.deleteAt("63");
        sl.display();
        sl.setAt("18", 9.99);
        sl.display();
        System.out.println("Length of the linked list is "+sl.length);
        // for AddSorted
        Student s21 = new Student("Kanishk_Patel", "26", 20);
        Student s11 = new Student("Kunal", "63", 97);
        Student s31 = new Student("Amnuj", "46", 88);
        Student s41 = new Student("Ritik", "18", 67);
        Student s51 = new Student("Ayush", "12", 98);
        Node new_node;
        Link llist=new Link();
        new_node = llist.newNode(s21);
        llist.addSorted(new_node);
        new_node = llist.newNode(s11);
        llist.addSorted(new_node);
        new_node = llist.newNode(s31);
        llist.addSorted(new_node);
        new_node = llist.newNode(s41);
        llist.addSorted(new_node);
        new_node = llist.newNode(s51);
        llist.addSorted(new_node);
        System.out.println("Linked list after addSorted accoding to percentage : ");
        llist.display();
    }
}
