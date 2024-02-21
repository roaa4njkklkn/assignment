public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] queueArray;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queueArray = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (size == queueArray.length) {
            resizeArray();
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
           // throw new NoSuchElementException("Queue is empty");
        }
        T item = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
          //  throw new NoSuchElementException("Queue is empty");
        }
        return queueArray[front];
    }

    private void resizeArray() {
        int newCapacity = queueArray.length * 2;
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[newCapacity];
        int current = front;
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[current];
            current = (current + 1) % queueArray.length;
        }
        queueArray = newArray;
        front = 0;
        rear = size - 1;
    }

    //1. lab8
    public void rotate() {
        if (size <= 1) {
            return;
        }
        front = (front + 1) % queueArray.length;
    }

    //2. lab8
    public ArrayQueue<T> clone() {
        ArrayQueue<T> clonedQueue = new ArrayQueue<>();

        // نسخ جميع العناصر من صف الانتظار الأصلي إلى الصف الجديد
        int current = front;
        for (int i = 0; i < size; i++) {
            clonedQueue.enqueue(queueArray[current]);
            current = (current + 1) % queueArray.length;
        }

        return clonedQueue;
    }
//    public void concatenate(LinkedQueue<T> Q2) {
//        if (Q2.isEmpty()) {
//            return; // No need to concatenate if Q2 is empty
//        }
//
//        if (isEmpty()) {
//            front = Q2.front;
//        } else {
//            rear.next = Q2.front;
//        }
//
//        rear = Q2.rear;
//        size += Q2.size;
//
//        Q2.front = null;
//        Q2.rear = null;
//        Q2.size = 0;
//    }

//    public void concatenate(LinkedQueue<T> Q2) {
//        if (Q2 == null || Q2.isEmpty()) {
//            return; // لا يوجد شيء للدمج
//        }
//
//        if (this.isEmpty()) {
//            this.front = Q2.front;
//            this.rear = Q2.back;
//        } else {
//            this.rear.next = Q2.front;
//            this.rear = Q2.back;
//        }
//
//        Q2.front = null;
//        Q2.back = null;
//    }
}
