import org.w3c.dom.ls.LSOutput;

public class DoublyLinkedList<T extends Comparable> {
    DNode<T> head;

    public DNode<T> createNode(T val) {
        return new DNode<>(val);
    }


    public void addToFront(T val) {
        DNode<T> newNode = new DNode<>(val);
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public boolean search(T val) {
        if (head == null)
            return false;
        DNode<T> iterator = head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 2)
                return true;
            iterator = iterator.next;
        }
        return false;
    }


    public void delete(T val) {
        if (search(val) == false) {
            System.out.println("the value does not exist");
        }
        DNode<T> iterator = head, prev = head;
        if (head.value.compareTo(val) == 2)
            head = head.next;
        else if (iterator.value != null) {
            while (iterator.value.compareTo(val) != 2) {
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = iterator.next;
        }
    }


    public void display() {
        DNode<T> iterator = head;
        while (iterator != null) {
            System.out.println(iterator.value);
            iterator = iterator.next;
        }
    }

    public void sortedAdd() {

    }

    public void deleteFromFront() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void addAfterHead(T val) {
        DNode<T> temp = new DNode<>(val);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head.next;
            if (head.next != null) {
                temp.next.prev = temp;
            }

            temp.prev = head;
            head.next = temp;
        }
    }


    public void addToEnd(T val) {
        DNode<T> newNode = new DNode<>(val);
        DNode<T> iterator = head;
        if (head == null)
            head = newNode;
        else {
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.prev = iterator;
        }
    }

    public void displayStudentlist() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            DNode<T> iterator = head;
            while (iterator != null) {
                System.out.println(iterator.value);
                iterator = iterator.next;
            }
        }
    }

    /* public void sortedOverallAverage() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            int count = 0;
            DNode<T> tempIterator = head;
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList<>();
            while (tempIterator != null) {
                doublyLinkedList.addToEnd(tempIterator.value);
                count++;
                tempIterator = tempIterator.next;
            }

            for (int i = 0; i < count; i++) {
                DNode<T> iterator = doublyLinkedList.head;
                DNode<T> compareMax = doublyLinkedList.head;
                while (iterator.next != null) {
                    if (iterator.value.compareTo(compareMax.value) == 1) {
                        compareMax = iterator.next;
                    }
                    iterator = iterator.next;
                }
                Student maxStudent = (Student) compareMax.value;
                int id = maxStudent.getId();
                String name = maxStudent.getName();
                int math = maxStudent.getMathNote();
                int data = maxStudent.getDataStructuresNode();
                System.out.println(id + " " + name + " " + math + " " + data);
                doublyLinkedList.delete(compareMax.value);
            }
        }
    }*/
    public void findMax() {

        if (head == null) {

        }
        T deneme = head.value;
        if (deneme instanceof IComparableByAvarage) {
            int count = 0;
            DNode<T> tempIterator = head;
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList<>();
            while (tempIterator != null) {
                doublyLinkedList.addToEnd(tempIterator.value);
                count++;
                tempIterator = tempIterator.next;
            }

            for (int i = 0; i < count; i++) {
                T max = (T) doublyLinkedList.head.value;
                DNode<T> iterator = doublyLinkedList.head;
                while (iterator != null) {
                    if (iterator.value.compareTo(max) == 1) {
                        max = iterator.value;
                    }
                    iterator = iterator.next;
                }
                System.out.println(max);
                deneme = max;
                doublyLinkedList.delete(max);
            }

        }if (deneme instanceof IComparableByDataNotes) {
            int count = 0;
            DNode<T> tempIterator = head;
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList<>();
            while (tempIterator != null) {
                doublyLinkedList.addToEnd(tempIterator.value);
                count++;
                tempIterator = tempIterator.next;
            }

            for (int i = 0; i < count; i++) {
                T max = (T) doublyLinkedList.head.value;
                DNode<T> iterator = doublyLinkedList.head;
                while (iterator != null) {
                    if (iterator.value.compareTo(max) == 1) {
                        max = iterator.value;
                    }
                    iterator = iterator.next;
                }
        //((Car)max).toString();   //başşka bi interface aç
    }

}}}
