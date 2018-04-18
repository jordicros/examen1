package examen;

import java.util.Stack;

/**
 * Created by jordi on 18/04/2018.
 */
public class ReversePolishNotationImpl implements ReversePolishNotation{
    public Operacio processarOperacio(Operacio op){
            Stack<Double> pila = new Stack<Double>();

            for (int i = 0; i < op.expressio.length; i++) {
                if (op.expressio[i].matches("-?[\\d]+")) {
                    pila.push(Double.parseDouble(op.expressio[i]));
                } else {
                    double op2 = pila.pop();
                    double op1 = pila.pop();
                    double result = 0;
                    String operator = op.expressio[i];
                    if (operator.equals("+")) result = op1 + op2;
                    else if (operator.equals("-")) result = op1 - op2;
                    else if (operator.equals("*")) result = op1 * op2;
                    else if (operator.equals("/")) result = op1 / op2;
                    pila.push(result);
                }
            }
            op.resultat = pila.pop();
            return op;
        }

}
