import org.omg.CORBA.INTERNAL;

/**
 * Created by Pierre on 18/01/2017.
 */
public class GeneticAlgorithm {
    public static void main(String[] args) {
        String input = "11110010001010101110101101110010";
        int operande1 = Integer.MIN_VALUE;
        int operande2 = Integer.MIN_VALUE;
        String operation = "null";
        for (int i = 0; i <= input.length() - 4; i++) {
            String binary = input.substring(i, i + 4);
            int decimal = binaryToDecimal(binary);
            int count = 0;
            if (operande1 == Integer.MIN_VALUE) {
                if (decimal < 10) {
                    operande1 = decimal;
                    i += 3;
                    continue;
                }
                i += 3;
                continue;
            }

            if (decimal < 10 && operande2 == Integer.MIN_VALUE && !operation.equals("null")) {
                operande2 = decimal;
            }
            operation = setOperation(operation, binary);

            if (operande2 != Integer.MIN_VALUE && !operation.equals("null")) {
                int[] operandes = {operande1, operande2};
                operation = doTheOperation(operandes, operation);
                operande1 = operandes[0];
                operande2 = operandes[1];
            }
            i += 3;
        }
        System.out.println(operande1);
    }


    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static String doTheOperation(int[] values, String operation) {
        int operande1 = values[0];
        int operande2 = values[1];
        if (operation.equals("1010")) {
            operande1 = operande1 + operande2;
            operande2 = Integer.MIN_VALUE;
            operation = "null";
        }
        if (operation.equals("1100")) {
            operande1 = operande1 * operande2;
            operande2 = Integer.MIN_VALUE;
            operation = "null";
        }
        if (operation.equals("1101")) {
            operande1 = operande1 / operande2;
            operande2 = Integer.MIN_VALUE;
            operation = "null";
        }
        if (operation.equals("1011")) {
            operande1 = operande1 - operande2;
            operande2 = Integer.MIN_VALUE;
            operation = "null";
        }
        values[0] = operande1;
        values[1] = operande2;
        return operation;
    }

    public static String setOperation(String operation, String binary) {
        if (binaryToDecimal(binary) >= 10 && binaryToDecimal(binary) <= 13 && operation.equals("null")) {
            operation = binary;
        }
        return operation;
    }
}
