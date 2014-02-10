package evaluator;

public class Number {
    private String representation;

    Number(String representation) {
        this.representation = representation;
    }
    public int getResult(){
        return Integer.valueOf(representation);
    }
}
