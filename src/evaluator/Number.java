package evaluator;

public class Number implements Expresion{
    private String representation;

    public Number(String representation) {
        this.representation = representation;
    }
    
    public int getResult(){
        return Integer.valueOf(representation);
    }
}
