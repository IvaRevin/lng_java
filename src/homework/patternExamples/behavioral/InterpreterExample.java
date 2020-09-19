package homework.patternExamples.behavioral;

public class InterpreterExample {
    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = context.evaluate("1-2+3");
        System.out.println(expression.interpret());
    }
}

interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return 0;
    }
}

class MinusExpression implements Expression {
    Expression right;
    Expression left;

    public MinusExpression(Expression right, Expression left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class PlusExpression implements Expression {
    Expression right;
    Expression left;

    public PlusExpression(Expression right, Expression left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Context {
    Expression evaluate(String str) {
        int pos = str.length() - 1;
        while (pos > 0) {
            if (Character.isDigit(str.charAt(pos))) {
                pos--;
            } else {
                Expression left = evaluate(str.substring(0, pos));
                Expression rigth = new NumberExpression(Integer.valueOf(str.substring(pos + 1, str.length())));
                char operator = str.charAt(pos);
                switch (operator) {
                    case '-':
                        return new MinusExpression(left, rigth);
                    case '+':
                        return new PlusExpression(left, rigth);
                }
            }
        }
        int result = Integer.valueOf(str);
        return new NumberExpression(result);
    }
}