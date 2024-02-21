public class SinglyLinkedList<E>{
    private Node<E> head=null;
    private Node<E> tail=null;
    private int size=0;

    private static class Node<E>{
        public boolean data;
        private E element;
        private Node<E>next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
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
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return head.getElement();
    }

    public E last(){
        if (isEmpty())return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
            size++;
        }
    }
    public void addLast(E e){
        Node<E> newset=new Node<>(e,null);
        if (size==0)head=newset;
        else
            tail.setNext(newset);
        tail=newset;
        size++;
    }

    public E removeFirst(){
        E deleted =head.getElement();
        if (isEmpty())return null;
        head=head.getNext();
        size--;
        if (size==0)tail=null;
        return deleted;
    }
    //1. lab 4
    @Override
    public boolean equals(Object obj) {
        // التحقق من أن obj هو نفس فئة SinglyLinkedList
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // التحقق من نفسية عدد العناصر في القوائم
        SinglyLinkedList otherList = (SinglyLinkedList) obj;
        if (size() != otherList.size()) {
            return false;
        }

        // التحقق من نفسية المحتوى لكل عنصر في القوائم
        Node currentNode = head;
        Node otherNode = otherList.head;
        while (currentNode != null) {
            if (currentNode.data != otherNode.data) {
                return false;
            }
            currentNode = currentNode.next;
            otherNode = otherNode.next;
        }

        return true;
    }
//2. lab4
    public Node<E> PenultimateElement (){
        while (head.next!=null){
            if (head.next.next!=null){
                head=head.next;
            }
            else {
                return head.next;
            }
        }
        return head.next;
    }
//3. lab 4
    public int sizeOtherWay() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
    //4. lab 4
    public void rotate() {
        if (head == null || head.next == null) {
            return; // No need to rotate if the list is empty or has only one node
        }

        Node firstNode = head;
        Node secondNode = head.next;

        head = secondNode;
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = firstNode;
        firstNode.next = null;
    }

//5. lab 4
//الكود المستخدم لدمج سلسلتين
public SinglyLinkedList concatenateLists(SinglyLinkedList L, SinglyLinkedList M) {
    // Create a new empty linked list L'
    SinglyLinkedList L_prime = new SinglyLinkedList();

    // If either list L or M is empty, set L' to be the other list and return
    if (L.isEmpty()) {
        L_prime.head = M.head;
        return L_prime;
    } else if (M.isEmpty()) {
        L_prime.head = L.head;
        return L_prime;
    }

    // Set L_prime.head to point to the head of list L
    L_prime.head = L.head;

    // Move the current pointer to the end of list L
    Node current = L_prime.head;
    while (current.next != null) {
        current = current.next;
    }

    // Set current.next to point to the head of list M
    current.next = M.head;

    return L_prime;
}


//الكود المستخدم لعكس سنقلي لنكد ليست باستخدام كميه ثابته من الذاكره
//6. lab 4
public SinglyLinkedList reverseList(SinglyLinkedList L) {
    // If the list is empty or has only one node, return it as is
    if (L.isEmpty() || L.head.next == null) {
        return L;
    }

    Node previous = null;
    Node current = L.head;

    while (current != null) {
        Node next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }

    L.head = previous;

    return L;
}
}

