import java.util.Stack;
public class Main {
    public static void main(String[] args) {
//1. lab 4 في كلاس السنقلي لينكد ليست
//2. lab 4 في كلاس السنقلي لينكد ليست
//3. lab 4 في كلاس السنقلي لينكد ليست
//4. lab 4 في كلاس السنقلي لينكد ليست
//5. lab 4 في كلاس السنقلي لينكد ليست
//6. lab 4 في كلاس السنقلي لينكد ليست

//1. lab5 في السيركلي لينكد ليست
//2. lab5 في السيركلي لينكد ليست
//3. lab5 في السيركلي لينكد ليست
//4. lab5 في السيركلي لينكد ليست
//5. lab5 في CircularLinkedListSplitter
//6. lab5 CircularlyLinkedList


//1. lab6 DoublyLinkedList
//2. lab6 DoublyLinkedList
//3. lab6 DoublyLinkedList
//4. lab6 DoublyLinkedList
//5. lab6 DoublyLinkedList
//6. lab6 CircularDoublyLinkedList

//1. lab 7 kinkedStack
//2. lab 7 kinkedStack
//4. lab 7 ArrayStack


//1. lab8 ArrayQueue
//2. lab8 ArrayQueue
//3. lab8 ArrayQueue
//4. lab8 JosephusProblem
//5. lab8 RoundRobinScheduling












//1.lab 7	 Implement a method with signature transfer(S, T) that transfers all elements from stack S onto stack T, so that the element that starts at the top of S is the first to be inserted onto T, and the element at the bottom of S ends up at the top of T.
        Stack<Integer> sourceStack = new Stack<>();
        sourceStack.push(1);
        sourceStack.push(2);
        sourceStack.push(3);


        Stack<Integer> destinationStack = new Stack<>();
        transfer(sourceStack, destinationStack);
        while (!sourceStack.isEmpty()){
            System.out.println( sourceStack.pop());
        }

//2.lab 7	Give a recursive method for removing all the elements from a stack

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        removeAllElements(stack);

        System.out.println("Stack after removal: " + stack);


//3.lab 7  كل واحد في كلاس لحاله
//

    }





    public static void transfer(Stack<Integer> source, Stack<Integer> destination) {
        while (!source.isEmpty()) {
            destination.push(source.pop());
        }
    }
    public static <T> void removeAllElements(Stack<T> stack) {
        if (!stack.isEmpty()) {
            stack.pop();
            removeAllElements(stack);
        }
    }
}