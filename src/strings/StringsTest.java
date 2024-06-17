package strings;

public class StringsTest {

    public static String convertString(String str) {
        if (str.length() == 0)
            return str;
        String result = "";
        for (String part : str.split(" ")) {
            result += String.valueOf(Character.toUpperCase(part.charAt(0))) + part.substring(1);
            result += " ";
        }
        return result.substring(0, result.length() - 1);
    }

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder result = new StringBuilder();

        while (i != -1 || j != -1 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

}
