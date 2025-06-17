import java.util.*;

public class CalculatorWithSortedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter expression (or type 'exit'): ");
            String expr = scanner.nextLine();

            if (expr.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Evaluate expression
                double result = evaluate(expr);
                System.out.println("Result: " + result);

                // Extract numbers, sort, and print
                List<Double> numbers = extractNumbers(expr);
                Collections.sort(numbers);
                System.out.println("Numbers in expression sorted: " + numbers);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Evaluate expression logic (same as before)
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
        }
        return 0;
    }

    private static double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) {
                i++;
                continue;
            }

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                       (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Double.parseDouble(sb.toString()));
                continue;
            }

            else if (ch == '(') {
                ops.push(ch);
            }

            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    double b = values.pop();
                    double a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                if (!ops.isEmpty()) ops.pop();
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    double b = values.pop();
                    double a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.push(ch);
            }

            i++;
        }

        while (!ops.isEmpty()) {
            double b = values.pop();
            double a = values.pop();
            char op = ops.pop();
            values.push(applyOp(a, b, op));
        }

        return values.pop();
    }

    // Extract all numbers from the expression into a list
    public static List<Double> extractNumbers(String expression) {
        List<Double> numbers = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                       (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                numbers.add(Double.parseDouble(sb.toString()));
                continue;
            }
            i++;
        }
        return numbers;
    }
}
