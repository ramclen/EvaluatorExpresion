package evaluator;


import evaluator.Operators.Division.DoubleIntegerDivision;
import evaluator.Operators.Division.IntegerDoubleDivision;
import evaluator.Operators.Division.DoubleDoubleDivision;
import evaluator.Operators.Division.IntegerIntegerDivision;
import evaluator.Operators.Multiplication.DoubleIntegerMultiplication;
import evaluator.Operators.Multiplication.IntegerIntegerMultiplication;
import evaluator.Operators.Multiplication.DoubleDoubleMultiplication;
import evaluator.Operators.Multiplication.IntegerDoubleMultiplication;
import evaluator.Operators.Substraction.IntegerIntegerSubstraction;
import evaluator.Operators.Sum.IntegerIntegerSum;
import evaluator.Operators.Sum.IntegerDoubleSum;
import evaluator.Operators.Operator;
import evaluator.Operators.Substraction.DoubleDoubleSubstraction;
import evaluator.Operators.Substraction.DoubleIntegerSubstraction;
import evaluator.Operators.Substraction.IntegerDoubleSubstraction;
import evaluator.Operators.Sum.DoubleDoubleSum;
import evaluator.Operators.Sum.DoubleIntegerSum;
import evaluator.Operators.lessThan.DoubleDoubleLessThan;
import evaluator.Operators.lessThan.DoubleIntegerLessThan;
import evaluator.Operators.lessThan.IntegerDoubleLessThan;
import evaluator.Operators.lessThan.IntegerIntegerLessThan;
import java.util.HashMap;

public class OperatorFactory {
    private HashMap<String, Operator> operatorDictionary;

    public OperatorFactory() {
        operatorDictionary = new HashMap<>();
        initDictionary();
    }
    
    public Operator create(String symbol,Object left, Object right){
        return operatorDictionary.get(getSignature(symbol, left, right));
    }
    
    //No se si es una buena solucion el tema de +IntegerDouble como key
    private String getSignature(String symbol,Object left, Object right){
        return symbol + left.getClass().getSimpleName() + right.getClass().getSimpleName();
    }
    
    private void initDictionary(){
        operatorDictionary.put("+IntegerInteger", new IntegerIntegerSum());
        operatorDictionary.put("+IntegerDouble", new IntegerDoubleSum());
        operatorDictionary.put("+DoubleInteger", new DoubleIntegerSum());
        operatorDictionary.put("+DoubleDouble", new DoubleDoubleSum());
        
        operatorDictionary.put("-IntegerInteger", new IntegerIntegerSubstraction());
        operatorDictionary.put("-IntegerDouble", new IntegerDoubleSubstraction());
        operatorDictionary.put("-DoubleInteger", new DoubleIntegerSubstraction());
        operatorDictionary.put("-DoubleDouble", new DoubleDoubleSubstraction());
        
        operatorDictionary.put("*IntegerInteger", new IntegerIntegerMultiplication());
        operatorDictionary.put("*IntegerDouble", new IntegerDoubleMultiplication());
        operatorDictionary.put("*DoubleInteger", new DoubleIntegerMultiplication());
        operatorDictionary.put("*DoubleDouble", new DoubleDoubleMultiplication());
        
        operatorDictionary.put("/IntegerInteger", new IntegerIntegerDivision());
        operatorDictionary.put("/IntegerDouble", new IntegerDoubleDivision());
        operatorDictionary.put("/DoubleInteger", new DoubleIntegerDivision());
        operatorDictionary.put("/DoubleDouble", new DoubleDoubleDivision());
        
        operatorDictionary.put("<IntegerInteger", new IntegerIntegerLessThan());
        operatorDictionary.put("<IntegerDouble", new IntegerDoubleLessThan());
        operatorDictionary.put("<DoubleInteger", new DoubleIntegerLessThan());
        operatorDictionary.put("<DoubleDouble", new DoubleDoubleLessThan());
        
    }
}
