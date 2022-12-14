
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
    public void findMaxAvarage() {
        if (head == null) {
        } else {
            T deneme = head.value;
            if (deneme instanceof Student) {
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
                    doublyLinkedList.delete(max);
                }
            }
        }

    }

    public void findMaxDataNotes() {
        if (head == null) {
        } else {
            T deneme = head.value;
            if (deneme instanceof Student) {
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
                        Student student = (Student) iterator.value;
                        if (student.compareByDataNotes(max) == 1) {
                            max = iterator.value;
                        }
                        iterator = iterator.next;
                    }
                    System.out.println(max);
                    doublyLinkedList.delete(max);
                }
            }
        }

    }

    public void findMathAvarage() {
        int avarage = 0;
        int studentCount = 0;
        DNode<T> iterator = head;
        if (head == null) {
            System.out.println("This linkedlist are empty");
        } else {
            if (iterator.value instanceof Student) {
                while (iterator != null) {
                    Student student = (Student) iterator.value;
                    avarage += student.getMathNote();
                    studentCount++;
                    iterator = iterator.next;
                }
                System.out.println("Math avarage is : " + avarage / studentCount);
            }
        }
    }

    public void findLowestDataStructuresNoteStudents() {
        DNode<T> iterator = head;
        if (head == null) {
            System.out.println("This linkedlist are empty");
        } else {
            if (iterator.value instanceof Student) {
                Student student = (Student) iterator.value;
                while (iterator != null) {
                    if (student.getDataStructuresNode() > ((Student) iterator.value).getDataStructuresNode()) {
                        student = (Student) iterator.value;
                    }
                    iterator = iterator.next;
                }
                iterator = head;
                while (iterator != null) {
                    if (student.getDataStructuresNode() == ((Student) iterator.value).getDataStructuresNode()) {
                        student = (Student) iterator.value;
                        System.out.println("Student information who has lowest data Structures grade is : " + student.getId() + " " + student.getName() + " " + student.getMathNote() + " " + student.getDataStructuresNode());
                    }
                    iterator = iterator.next;
                }
            }
        }
    }

    public void deleteStudent(int id) {
        DNode<T> iterator = head;
        if (head == null) {
            System.out.println("This linkedlist are empty");
        } else {
            if (iterator.value instanceof Student) {
                Student student = (Student) iterator.value;
                while (iterator != null) {
                    if (student.getId() == id) {
                        delete((T) student);
                        break;
                    }
                    iterator = iterator.next;
                    student = (Student) iterator.value;
                }
            }
        }
    }

    public void insertStudent(Student student) {
        addToEnd((T) student);
    }

    public int displayStudentCount() {
        DNode<T> iterator = head;
        if (head == null) {
            System.out.println("This linkedlist are empty");
        } else {
            if (iterator.value instanceof Student) {
                int studentCount = 0;
                while (iterator != null) {
                    studentCount++;
                    iterator = iterator.next;
                }
                return studentCount;
            }
        }
        return 0;
    }

    public void displaySuccessfulStudents() {
        if (head == null) {
        } else {
            T deneme = head.value;
            if (deneme instanceof Student) {
                int studentCount = 0;
                int mathSum = 0;
                int dataSum = 0;
                DNode<T> iterator = head;
                while (iterator != null) {
                    Student student = (Student) iterator.value;
                    mathSum += student.getMathNote();
                    studentCount++;
                    iterator = iterator.next;
                }
                iterator = head;
                mathSum = mathSum / studentCount;
                while (iterator != null) {
                    Student student = (Student) iterator.value;
                    dataSum += student.getDataStructuresNode();
                    iterator = iterator.next;
                }
                int count1 = 0;
                iterator = head;
                dataSum = dataSum / studentCount;
                while (iterator != null) {
                    Student student = (Student) iterator.value;
                    if (student.getMathNote() > mathSum) {
                        if (count1 == 0) {
                            System.out.println("successful students for math course (Math course avarage) : " + mathSum);
                            count1++;
                        }
                        System.out.println(student.getId() + " " + student.getName() + " " + student.getMathNote() + " " + student.getDataStructuresNode());
                    }
                    iterator = iterator.next;
                }
                iterator = head;
                int count2 = 0;
                while (iterator != null) {
                    Student student = (Student) iterator.value;

                    if (student.getDataStructuresNode() > dataSum) {
                        if (count2 == 0) {
                            count2++;
                            System.out.println("successful students for data stuctures course (Data s. course avarage) : " + dataSum);
                        }
                        System.out.println(student.getId() + " " + student.getName() + " " + student.getMathNote() + " " + student.getDataStructuresNode());
                    }
                    iterator = iterator.next;
                }
                int count3 = 0;
                iterator = head;
                while (iterator != null) {
                    Student student = (Student) iterator.value;
                    if (student.getDataStructuresNode() > dataSum && student.getMathNote() > mathSum) {
                        if (count3 == 0) {
                            System.out.println("successful students for every course (Data s. course avarage : " + dataSum + (") (Math course avarage : "+ mathSum+ " )"));
                            count3++;
                        }
                        System.out.println(student.getId() + " " + student.getName() + " " + student.getMathNote() + " " + student.getDataStructuresNode());
                    }
                    iterator = iterator.next;
                }

            }
        }
    }
}