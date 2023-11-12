package edu.hw5;



public class Task7 {
    /* Напишите регулярные выражения для строк из алфавита {0, 1} */

    /* содержит не менее 3 символов, причем третий символ равен 0 */
    public static boolean firstRegex(String input) {
        return input.matches("^.{2}0.*$");
    }

    /* начинается и заканчивается одним и тем же символом */
    public static boolean secondRegex(String input) {
        return input.matches("^(0|1).*\\1$");
    }

    /* длина не менее 1 и не более 3 */
    public static boolean thirdRegex(String input) {
        return input.matches("^[01]{1,3}$");
    }
}
