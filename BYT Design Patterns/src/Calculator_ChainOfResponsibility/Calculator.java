package Calculator_ChainOfResponsibility;

public class Calculator {
    public static void main(String[] args) {
        CalculatorHandler multiplyDivideHandler = new MultiplicationDivisionHandler();
        CalculatorHandler addSubtractHandler = new AdditionSubtractionHandler();

        multiplyDivideHandler.setNextHandler(addSubtractHandler);

        Expression expression = new Expression("2 - 30 + 15 / 2 * 3 - 16 + 25.89");
        multiplyDivideHandler.process(expression);

        System.out.println(expression.getResult());
    }
}
