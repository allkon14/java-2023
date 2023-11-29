package edu.hw5;

public final class Task8 {
    private Task8() {

    }

    /* Напишите регулярные выражения для строк из алфавита {0, 1} */
    /* нечетной длины */
    public static boolean regex1(String str) {
        return str.matches("^[01]([01]{2})*$");
    }

    /* начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину */
    public static boolean regex2(String str) {
        return str.matches("^0([01]{2})*$|^1[01]([01]{2})*$");
    }

    /* количество 0 кратно 3 */
    public static boolean regex3(String str) {
        return str.matches("^(1*01*01*01*)*$");
    }

    /* любая строка, кроме 11 или 111 */
    public static boolean regex4(String str) {
        return str.matches("^(?!1{2,3}$)[01]*$");
    }

    /* каждый нечетный символ равен 1 */
    public static boolean regex5(String str) {
        return str.matches("^1([01]1)*[01]?$");
    }

    /* содержит не менее двух 0 и не более одной 1 */
    public static boolean regex6(String str) {
        return str.matches("^0*(010|100|001|00)0*$");
    }

    /* нет последовательных 1 */
    public static boolean regex7(String str) {
        return str.matches("^(?!.*11)[01]*$");
    }

}
