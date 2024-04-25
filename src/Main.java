import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш пример: ");
        String input = scanner.nextLine();
        int count = countOperators(input);
        if(count>1){
            throw new Exception("Вы ввели не коректное выражение");
        }
        else {
            System.out.println( calc(input));
        }
    }

    static String calc(String input) throws Exception {
        String[] operation = {"+", "-", "/", "*"};
        String[] operationForAction = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        int num1;
        int num2;
        String result;
        boolean isRoman;
        for (int i = 0; i < operation.length; i++) {
            if (input.contains(operation[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new Exception("Вы ввели не коректное выражение");
        }
        String oper = findOperation(input);
        String[] expression = input.split(operationForAction[actionIndex]);

        if (!Roman.isRoman(expression[0]) && !Roman.isRoman(expression[1])) {
            num1 = Integer.parseInt(expression[0]);
            num2 = Integer.parseInt(expression[1]);
            isRoman = false;
        } else if (Roman.isRoman(expression[0]) && Roman.isRoman(expression[1])) {
            num1 = Roman.convertToArabian(expression[0]);
            num2 = Roman.convertToArabian(expression[1]);
            isRoman = true;
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int arabian = consider(num1, num2, oper);
        if (isRoman) {

            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static int consider(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

    static String findOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    public static int countOperators(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                count++;
            }
        }
        return count;
    }
}


class Roman {

    static String[] romanNumber = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoman(String el) {
        for (int i = 0; i < romanNumber.length; i++) {
            if (el.contains(romanNumber[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanNumber.length; i++) {
            if (roman.equals(romanNumber[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanNumber[arabian];
    }
}
