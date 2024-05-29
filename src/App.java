import io.FastReader;
import io.FastWriter;

public class App {
    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader("C:\\Users\\konga\\Core_Java\\Java_CP\\src\\io\\input.txt");
        FastWriter fastWriter = new FastWriter();

        String equation = fastReader.readLine();
        String trimmedEquation = equation.replaceAll(" ", "");

        for (int i = 0; i < 10; i++) {
            String tempString = trimmedEquation.replaceAll("x", Integer.toString(i));
            int rhs = Integer.parseInt(tempString.split("=")[1]);
            String lhs = tempString.split("=")[0];
            // fastWriter.writeLine("lhs: " + lhs);
            // fastWriter.writeLine("rhs: " + rhs);
            int res = 0;
            if (lhs.contains("+")) {
                int op1 = Integer.parseInt(lhs.split("\\+")[0]);
                int op2 = Integer.parseInt(lhs.split("\\+")[1]);
                res = op1 + op2;
            }
            if (lhs.contains("-")) {
                int op1 = Integer.parseInt(lhs.split("\\-")[0]);
                int op2 = Integer.parseInt(lhs.split("\\-")[1]);
                res = op1 - op2;
            }
            if (lhs.contains("*")) {
                int op1 = Integer.parseInt(lhs.split("\\*")[0]);
                int op2 = Integer.parseInt(lhs.split("\\*")[1]);
                res = op1 * op2;
            }
            if (lhs.contains("/")) {
                int op1 = Integer.parseInt(lhs.split("\\/")[0]);
                int op2 = Integer.parseInt(lhs.split("\\/")[1]);
                res = op1 / op2;
            }
            if (res == rhs) {
                fastWriter.writeLine(i);
                break;
            }
        }
        fastWriter.flush();
    }
}