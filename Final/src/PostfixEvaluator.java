import java.util.Stack;

//q3
public class PostfixEvaluator {
    public static int evaluate(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else if (c == ' ') {
                continue;
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    // Add more cases for other operators if needed
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "5 2 + 8 3 - * 4 /";
        int result = evaluate(postfixExpression);
        System.out.println("Result: " + result);  // Output: 6
    }
}