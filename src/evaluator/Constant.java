package evaluator;

public class Number implements Expression{
    private String representation;

    public Number(String representation) {
        this.representation = representation;
    }
    
    public int getResult(){
        return Integer.valueOf(representation);
    }
}
