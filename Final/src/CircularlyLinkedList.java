public class CircularlyLinkedList<E> {
    private int size = 0;
    private Node<E> tail = null;

    public CircularlyLinkedList() {
    }

    private static class Node<E> {
        private E element;
        Node<E> next;

        public E getElement() {
            return element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;

    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    //1 lab5
    public void addFirstOtheWay(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // يتم ربط العقدة بنفسه بشكل دائري
        } else {
            tail.setNext(new Node<>(e, tail.getNext()));
            tail = tail.getNext(); // نحديث المؤشر على العقدة الأخيرة لتكون العقدة الجديدة
        }
        size++;
    }
}


