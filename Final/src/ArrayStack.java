public class ArrayStack<T> implements Stack<T> {
    private int maxSize;
    private Object[] stackArray;
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }

    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        top++;
        stackArray[top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        T item = (T) stackArray[top];
        stackArray[top] = null;
        top--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        return (T) stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
    //4. lab 7
    public ArrayStack<T> clone() {
        ArrayStack<T> clonedStack = new ArrayStack<>(maxSize);
        // نسخ جميع العناصر من المكدس الأصلي إلى المكدس الجديد
        for (int i = 0; i <= top; i++) {
            clonedStack.stackArray[i] = stackArray[i];
        }

        clonedStack.top = top;

        return clonedStack;
    }
}