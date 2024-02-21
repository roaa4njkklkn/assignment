public interface Queue<T> {
    boolean isEmpty();
    int size();
    void enqueue(T item);
    T dequeue();
    T peek();
}
