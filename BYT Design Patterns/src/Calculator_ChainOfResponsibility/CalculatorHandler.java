package Calculator_ChainOfResponsibility;

public interface CalculatorHandler {
    void setNextHandler(CalculatorHandler nextHandler);
    void process(Expression expression);
}

