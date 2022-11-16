import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DoublyLinkedList<Student> studentList = readFileAndCreateLinkedList("students.txt");
        menu(studentList);
    }

    public static void menu(DoublyLinkedList list) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("*******************************************************************************");
            System.out.println("Press 1 to display LinkedList");
            System.out.println("Press 2 to display students by sorted overall average");
            System.out.println("Press 3 to display students by sorted data structures notes");
            System.out.println("Press 4 to display math avarage");
            System.out.println("Press 5 to display student(s) who has the lowest Data Structures grade");
            System.out.println("Press 6 to delete student with by entering id");
            System.out.println("Press 7 to insert a new student to the list");
            System.out.println("Press 8 to display the student count");
            System.out.println("Press 9 to display the successful students for each course");
            System.out.println("Press 0 to shut down program");
            System.out.println("*******************************************************************************");

            int x = scanner.nextInt();
            if (x == 1) {
                list.displayStudentlist();
            } else if (x == 2) {
                list.findMaxAvarage();
            } else if (x == 3) {
                list.findMaxDataNotes();
            } else if (x == 4) {
                list.findMathAvarage();
            } else if (x == 5) {
                list.findLowestDataStructuresNoteStudents();
            } else if (x == 6) {
                System.out.println("Please enter an id : ");
                int id = scanner.nextInt();
                list.deleteStudent(id);

            } else if (x == 7) {
                System.out.println("Please enter an id : (type must be integer) ");
                for (int i = 0; i < 1; i++) {
                    try {
                        int id = scanner.nextInt();
                        System.out.println("Please enter a name : (type must be string) ");
                        try {
                            String name = scanner.next();
                            System.out.println("Please enter a math note (type must be integer): ");
                            try {
                                int math = scanner.nextInt();
                                System.out.println("Please enter a data structures note (type must be integer): ");
                                try {
                                    int data = scanner.nextInt();
                                    System.out.println("Creating student");
                                    Student student = new Student(id, name, math, data);
                                    System.out.println("Adding " + student.getName());
                                    list.insertStudent(student);
                                    System.out.println("Added " + student.getName());
                                } catch (Exception e) {
                                    System.out.println("You must enter an integer value but you didn't.The program is shut down.");
                                }

                            } catch (Exception e) {
                                System.out.println("You must enter an integer value but you didn't.The program is shut down.");
                                i++;
                                run = false;
                            }

                        } catch (Exception e) {
                            System.out.println("You must enter an string value but you didn't.The program is shut down.");
                            i++;
                            run = false;
                        }


                    } catch (Exception e) {
                        System.out.println("You must enter an integer value but you didn't.The program is shut down.");
                        i++;
                        run = false;
                    }
                }
            } else if (x == 8) {
                System.out.println("number of students in the LinkedList : " + list.displayStudentCount());
            } else if (x == 9) {
                list.displaySuccessfulStudents();
            } else if (x == 0) {
                System.out.println("The program is shut down. GoodByeeeeeee");
                break;
            }
        }

    }

    public static DoublyLinkedList<Student> readFileAndCreateLinkedList(String string) throws FileNotFoundException {
        File file = new File(string);
        Scanner scanner = new Scanner(file);
        DoublyLinkedList<Student> doublyLinkedList = new DoublyLinkedList<Student>();
        while (scanner.hasNext()) {
            int id = Integer.parseInt(scanner.next());
            if (scanner.hasNext()) {
                String name = scanner.next();
                if (scanner.hasNext()) {
                    int mathNote = Integer.parseInt(scanner.next());
                    if (scanner.hasNext()) {
                        int dataStructuresNode = Integer.parseInt(scanner.next());
                        Student student = new Student(id, name, mathNote, dataStructuresNode);
                        doublyLinkedList.addToEnd(student);
                    }
                }
            }
        }
        return doublyLinkedList;
    }
}