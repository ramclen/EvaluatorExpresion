package evaluator;


import evaluator.operators.Operator;

public class OperatorFactory {
    private OperatorDictionary operatorDictionary;

    public OperatorFactory() {
        operatorDictionary = new OperatorDictionary();
    }

    public Operator create(String symbol,Object left, Object right){
        try {
            return (Operator) Class.forName(getClassName(symbol, left, right)).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getClassName(String symbol, Object left, Object right) {
        String operatorName = operatorDictionary.get(symbol);
        return getPathOfPackage(operatorName) + left.getClass().getSimpleName() + right.getClass().getSimpleName() + operatorName;
    }

    private String getPathOfPackage(String operatorName) {
        return "evaluator.operators." + operatorName.toLowerCase() + ".";
    }

}
