public class DNode<T extends IComparableByDataNotes> {

    public T value;
    public DNode<T> next,prev;

    public DNode(T val) {
        this.value = val;
        this.next = null;
        this.prev = null;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

}
