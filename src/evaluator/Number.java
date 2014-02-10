
package evaluator;

public class Number implements Expresion{
    private String representation;

    Number(String string) {
        representation = string;
    }

    @Override
    public int getResult() {
        return 1;
    }
    
}
