//5. lab5
public class CircularLinkedListSplitter {
    public static void main(String[] args) {
        // تجربة الكود
        Node<Integer> list = createCircularLinkedList(); // إنشاء القائمة المتصلة الدائرية

        System.out.println("Original List:");
        printCircularLinkedList(list); // طباعة القائمة المتصلة الدائرية الأصلية

        Node<Integer>[] splitLists = splitCircularLinkedList(list); // تقسيم القائمة المتصلة الدائرية

        System.out.println("List 1:");
        printCircularLinkedList(splitLists[0]); // طباعة List1

        System.out.println("List 2:");
        printCircularLinkedList(splitLists[1]); // طباعة List2
    }

    public static Node<Integer>[] splitCircularLinkedList(Node<Integer> list) {
        if (list == null || list.getNext() == null) {
            return new Node[]{list, null};
        }

        Node<Integer> slowPointer = list;
        Node<Integer> fastPointer = list;

        while (fastPointer.getNext() != list && fastPointer.getNext().getNext() != list) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }

        Node<Integer> list1 = list;
        Node<Integer> list2 = slowPointer.getNext();

        slowPointer.setNext(list1);
        fastPointer.setNext(list2);

        return new Node[]{list1, list2};
    }

    public static Node<Integer> createCircularLinkedList() {
        Node<Integer> head = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(head);

        return head;
    }

    public static void printCircularLinkedList(Node<Integer> list) {
        if (list == null) {
            return;
        }

        Node<Integer> current = list;

        do {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        } while (current != list);

        System.out.println();
    }
}

class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


}
