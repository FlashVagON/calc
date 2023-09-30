import java.util.Scanner;

public class Main {
    static char zn;
    public static void main(String[] args) {
        String[] rome = new String[] {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII",
                "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        Scanner in = new Scanner(System.in);
        System.out.println("Условие: выражение из 2-х чисел, арабские или римские цифры, положительные");
        System.out.print("Введите Ваш пример: ");
        String prim = in.nextLine();
        char[] all_chars = new char[10];
        for (int i = 0; i < prim.length(); i++) {
            all_chars[i] = prim.charAt(i);
            if (all_chars[i] == '+') {
                zn = '+';
            }
            if (all_chars[i] == '-') {
                zn = '-';
            }
            if (all_chars[i] == '*') {
                zn = '*';
            }
            if (all_chars[i] == '/') {
                zn = '/';
            }
        }
        String under_charString = String.valueOf(all_chars);
        String[] pies = under_charString.split("[+-/*]");
        if(pies.length != 2){
            System.out.println("Не верные вводные данные");
            System.exit(0);
        }
        String a = pies[0].trim();
        String b = pies[1].trim();
        Test prov = new Test();
        if((prov.digitOrNot(a)) & (prov.digitOrNot(b))) {
            int digA = Integer.parseInt(a);
            int digB = Integer.parseInt(b);
            if ((digA <= 10) & (digB <= 10)) {
                if (zn == '+') {
                    System.out.println("Ответ: " + (digA+digB));
                }
                if (zn =='-') {
                    System.out.println("Ответ: " + (digA-digB));
                }
                if (zn =='*') {
                    System.out.println("Ответ: " + (digA*digB));
                }
                if (zn == '/') {
                    System.out.println("Ответ: " + (digA/digB));
                }
            }
            else {
                System.out.println("Не верные вводные данные");
                System.exit(0);
            }
        }
        else if((!prov.digitOrNot(a)) & !(prov.digitOrNot(b))) {
            int rDigA = -1;
            int rDigB = -1;
            for (int i = 0; i < rome.length; i++) {
                if (rome[i].equals(a)){
                   rDigA = i;
                }
                if (rome[i].equals(b)){
                   rDigB = i;
                }
            }
            if((rDigA<=10) & (rDigB<=10)){
                if (zn =='+') {
                    System.out.println("Ответ: " + rome[(rDigA+rDigB)]);
                }
                if (zn =='-') {
                    if(rDigA-rDigB<0){
                        System.out.println("В римской системе нет отрицательных чисел");
                        System.exit(0);
                    }
                    else if(rDigA-rDigB==0){
                        System.out.println("Ответ: 0, но по заданию это ошибка в введенных данных))");
                        System.exit(0);
                    }
                    System.out.println("Ответ: " + rome[(rDigA-rDigB)]);
                }
                if (zn =='*') {
                    System.out.println("Ответ: " + rome[(rDigA*rDigB)]);
                }
                if (zn =='/') {
                    if(rDigA/rDigB==0){
                        System.out.println("В римской системе нет дробных чисел");
                        System.exit(0);
                    }
                    System.out.println("Ответ: " + rome[(rDigA/rDigB)]);
                }
            }
            else {
                System.out.println("Не верные вводные данные");
            }
        } else {
            System.out.println("Не верные вводные данные");
            System.exit(0);
        }
    }
}
class Test{
    Boolean digitOrNot(String digX) {
        try {
            int digA = Integer.parseInt(digX);
            return true;
        }
        catch (NumberFormatException nfe) {
            //System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return false;
    }
}