package Calculator_ChainOfResponsibility;
import java.util.ArrayList;
import java.util.List;

public class MultiplicationDivisionHandler implements CalculatorHandler {
    private CalculatorHandler nextHandler;
    private int multiplyNum = 0;
    private int divideNum = 0;
    @Override
    public void setNextHandler(CalculatorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void process(Expression expression) {
        String[] tokens = expression.getExpression().split(" ");
        List<String> newExpression = new ArrayList<>();

        int i = 0;
        while (i < tokens.length) {
            if (i < tokens.length - 1 && (tokens[i + 1].equals("*") || tokens[i + 1].equals("/"))) {
                double result = performOperation(tokens[i], tokens[i + 2], tokens[i + 1]);
                tokens[i + 2] = String.valueOf(result);
                i += 2;
            } else {
                newExpression.add(tokens[i]);
                i++;
            }
        }

        expression.setExpression(String.join(" ", newExpression));
        expression.setMultiplyNum(multiplyNum);
        expression.setDivideNum(divideNum);

        if (nextHandler != null) {
            nextHandler.process(expression);
        }
    }
    private double performOperation(String operand1, String operand2, String operator) {
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);
        multiplyNum += operator.equals("*") ? 1 : 0;
        divideNum += operator.equals("/") ? 1 : 0;
        return operator.equals("*") ? num1 * num2 : num1 / num2;
    }
}

