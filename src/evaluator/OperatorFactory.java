package evaluator;


import evaluator.Operators.Operator;

import java.util.HashMap;

public class OperatorFactory {
    private HashMap<String, String> operatorNameDictionary;

    public OperatorFactory() {
        operatorNameDictionary = new HashMap<>();
        initDictionary();
    }
    
    public Operator create(String symbol,Object left, Object right){
        try {
            return (Operator) Class.forName(getClassName(symbol, left, right)).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getClassName(String symbol, Object left, Object right) {
        String operatorName = operatorNameDictionary.get(symbol);
        return "evaluator.Operators."+ operatorName +"."+ left.getClass().getSimpleName() + right.getClass().getSimpleName() + operatorName;
    }

    private void initDictionary(){
        operatorNameDictionary.put("+", "Sum");
        operatorNameDictionary.put("-", "Subtraction");
        operatorNameDictionary.put("/", "Division");
        operatorNameDictionary.put("*", "Multiplication");
        operatorNameDictionary.put("<", "LessThan");

    }
}
