package examen;

import java.util.Stack;

/**
 * Created by jordi on 18/04/2018.
 */
public class ReversePolishNotationImpl implements ReversePolishNotation{
    public Operacio processarOperacio(Operacio op){
            Stack<Double> pila = new Stack<Double>();
            int counter=0;
            double resposta = 0;
            for (int i = 0; i < op.expressio.length; i++) {
                if (op.expressio[i].matches("-?[\\d]+")) {
                    pila.push(Double.parseDouble(op.expressio[i]));
                    counter++;
                } else {
                    String operator = op.expressio[i];
                    double result = pila.pop();
                    for (int j = 0; j < counter - 1; j++) {
                        double op2 = pila.pop();
                        if (operator.equals("+")) result = result + op2;
                        else if (operator.equals("-")) result = result - op2;
                        else if (operator.equals("*")) result = result * op2;
                        else if (operator.equals("/")) result = result / op2;

                    }
                    resposta = resposta + result;
                    counter=0;
                    pila.push(resposta);
                }
            }
            op.resultat = pila.pop();
            return op;
        }

}
