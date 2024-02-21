import java.util.Stack;

public class PostfixCalculator {
    public static int evaluate(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    // Add more cases for other operators if needed
                }
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "5 2 + 8 3 - * 4 /";
        int result = evaluate(postfixExpression);
        System.out.println("Result: " + result);  // Output: 6
    }
}