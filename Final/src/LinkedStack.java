public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
          //  throw new EmptyStackException();
        }

        T item = top.getData();
        top = top.getNext();
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            //throw new EmptyStackException();
        }

        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false; // Linked stack cannot be full
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    //1. lab 7
    public void transfer(Stack<T> sourceStack, Stack<T> targetStack) {
        // نقل العناصر من المكدس الأصلي (S) إلى المكدس الهدف (T)
        while (!sourceStack.isEmpty()) {
            T item = sourceStack.pop();
            targetStack.push(item);
        }
    }
    //2. lab 7
    public void removeElements(Stack<T> stack) {
        if (!stack.isEmpty()) {
            stack.pop(); // إزالة عنصر من المكدس

            // استدعاء الدالة نفسها بشكل متكرر لإزالة العناصر الأخرى
            removeElements(stack);
        }
    }
}
