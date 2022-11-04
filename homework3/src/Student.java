public class Student implements Comparable {
    private int id;
    private String name;
    private int mathNote;
    private int dataStructuresNode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathNote() {
        return mathNote;
    }

    public void setMathNote(int mathNote) {
        this.mathNote = mathNote;
    }

    public int getDataStructuresNode() {
        return dataStructuresNode;
    }

    public void setDataStructuresNode(int dataStructuresNode) {
        this.dataStructuresNode = dataStructuresNode;
    }

    public Student(int id, String name, int mathNote, int dataStructuresNode) {
        this.id = id;
        this.name = name;
        this.mathNote = mathNote;
        this.dataStructuresNode = dataStructuresNode;
    }


    public String toString() {
        return this.id + " " + this.name + " " + this.mathNote + " " + this.dataStructuresNode;
    }

    public int compareByDataNotes(Object o) {
        Student student = ((Student) o);
        if (this.dataStructuresNode == student.dataStructuresNode && this.id != student.id)
            return 0;
        else if (this.dataStructuresNode == student.dataStructuresNode && this.id == student.id)
            return 2;
        else if (this.dataStructuresNode > student.dataStructuresNode && this.id != student.id)
            return 1;
        else if (this.dataStructuresNode < student.dataStructuresNode && this.id != student.id)
            return -1;
        else return -2;
    }

    @Override
    public int compareTo(Object o) {
        Student student = ((Student) o);
        double avarageThis = (((double) this.dataStructuresNode + this.mathNote) / 2);
        double avarageO = (((double) student.dataStructuresNode + student.mathNote) / 2);
        int thisId = this.id;
        int studentId = student.id;
        if (avarageThis == avarageO && thisId != studentId)
            return 0;
        else if (avarageThis == avarageO && thisId == studentId)
            return 2;
        else if (avarageThis > avarageO && thisId != studentId)
            return 1;
        else if (avarageThis < avarageO && thisId != studentId)
            return -1;
        else return -2;
    }
}
