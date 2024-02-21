import java.net.DatagramPacket;

public class DoublyLinkedList<E>{
    private static class Node<E>{


    E element ;

    Node<E> prev;
    Node<E> next;

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }



    }


    private Node<E>header;
    private Node<E>trailer;
    private int size=0;

    public DoublyLinkedList(Node<E> header, Node<E> trailer, int size) {
        this.header = new Node<>(null,null,null);
        this.trailer = new Node<>(null,header,null);
       header.setNext(trailer);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty())return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E ee,Node<E>p,Node<E>n){
        Node<E>newest=new Node<>(ee,p,n);
        p.setNext(newest);
        n.setPrev(newest);
        size++;

    }
    public void addFirst(E ee){
        addBetween(ee,header,header.next);
    }

    public void addlast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public E remove(Node<E> x){
        Node<E>p=x.prev;
        Node<E>n=x.next;
        p.setNext(n);
        n.setPrev(p);
        size--;
        return x.element;
    }
    public E removeFirst(){
        if (isEmpty())return null;
        return remove(header.next);
    }

    public E removeLast(){
        if (isEmpty())return null;
        return remove(trailer.prev);
    }
    public Node<E> getHead()
    {
        return header;
    }
    public Node<E> getTail(){
        return trailer;
    }

    //1. lab6
    public Node findMiddleNode(DoublyLinkedList list) {
        Node slow = list.header.getNext(); // بداية المؤشر البطيء
        Node fast = list.header.getNext(); // بداية المؤشر السريع

        while (fast != list.trailer && fast.getNext() != list.trailer) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
    //2. lab6
    public int sizeOtherWay() {
        int count = 0;
        Node<E> current = header.getNext(); // البدء من العقدة الأولى بعد عقدة الرأس

        while (current != trailer) {
            count++;
            current = current.getNext();
        }

        return count;
    }
    //3. lab6
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DoublyLinkedList<?>)) {
            return false;
        }

        DoublyLinkedList<?> otherList = (DoublyLinkedList<?>) obj;


        if (this.size() != otherList.size()) {
            return false;
        }

        Node<E> currentNode = header.getNext();
        Node<?> otherCurrentNode = otherList.header.getNext();

        while (currentNode != trailer) {
            if (!currentNode.getElement().equals(otherCurrentNode.getElement())) {
                return false;
            }

            currentNode = currentNode.getNext();
            otherCurrentNode = otherCurrentNode.getNext();
        }

        return true;
    }
    //4. lab6
    public DoublyLinkedList<E> concatenateLists(DoublyLinkedList<E> L, DoublyLinkedList<E> M) {
        DoublyLinkedList<E> LPrime = new DoublyLinkedList<>();

        if (L.isEmpty()) {
            return M;
        }

        if (M.isEmpty()) {
            return L;
        }

        Node<E> LHead = L.getHead();
        Node<E> MHead = M.getHead();
        Node<E> LTail = L.getHead();

        LPrime.getHead().setNext(LHead.getNext());
        LHead.getNext().setPrev(LPrime.getHead());
        LPrime.getTail().setPrev(MHead.getPrev());
        MHead.getPrev().setNext(LPrime.getTail());

        LPrime.addlast((E) M);

        return LPrime;
    }
    //5. lab6
    private Node<E> sentinel;

    public DoublyLinkedList() {
        sentinel = new Node<>(null, null, null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value, sentinel.getNext(), sentinel);
        sentinel.getNext().setPrev(newNode);
        sentinel.setNext(newNode);
    }

}
