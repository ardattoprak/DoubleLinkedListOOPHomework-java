import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        DoublyLinkedList<Student> studentList = readFileAndCreateLinkedList("students.txt");

        //studentList.displayStudentlist();
        //studentList.displayStudentlist();
        System.out.println("------------------");
        studentList.findMaxAvarage();
        System.out.println("------------------");
        studentList.findMaxDataNotes();
        System.out.println("------------------");
        studentList.findMathAvarage();

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