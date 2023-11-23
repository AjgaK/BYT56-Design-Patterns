package Calculator_ChainOfResponsibility;

public class Expression {
    private String expression;
    private int multiplyNum = 0;
    private int divideNum = 0;
    private int addNum = 0;
    private int subtractNum = 0;
    public Expression(String expression) {
        this.expression = expression;
    }
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    public String getResult() {
        return "Result: " + expression
                + "\nNumber of performed multiplications: " + multiplyNum
                + "\nNumber of performed divisions: " + divideNum
                + "\nNumber of performed additions: " + addNum
                + "\nNumber of performed subtractions: " + subtractNum;
    }

    public void setMultiplyNum(int multiplyNum) {
        this.multiplyNum = multiplyNum;
    }

    public void setDivideNum(int divideNum) {
        this.divideNum = divideNum;
    }

    public void setAddNum(int addNum) {
        this.addNum = addNum;
    }

    public void setSubtractNum(int subtractNum) {
        this.subtractNum = subtractNum;
    }
}

