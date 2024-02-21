//6. lab6
public class CircularDoublyLinkedList<T> {
    private Node<T> head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null, null);

        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            head = newNode;
        } else {
            Node<T> tail = head.getPrevious();
            newNode.setNext(head);
            newNode.setPrevious(tail);
            head.setPrevious(newNode);
            tail.setNext(newNode);
        }

        size++;
    }

    public void remove(T value) {
        if (isEmpty()) {
            return;
        }

        Node<T> current = head;
        int count = 0;

        while (count < size && !current.getValue().equals(value)) {
            current = current.getNext();
            count++;
        }

        if (count == size) {
            return;
        }

        Node<T> previous = current.getPrevious();
        Node<T> next = current.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
        size--;
    }

    public void rotate() {
        if (isEmpty() || size == 1) {
            return;
        }

        head = head.getNext();
    }

    public void rotateBackward() {
        if (isEmpty() || size == 1) {
            return;
        }

        head = head.getPrevious();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> current = head;
        int count = 0;

        while (count < index) {
            current = current.getNext();
            count++;
        }

        return current.getValue();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}