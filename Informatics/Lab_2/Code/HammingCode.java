package Inf;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HammingCode {
    public static void main(String[] args) {
        int[] bits = new int[7];
        System.out.println("Введите 7-значный набор \"0\" или \"1\"");
        Scanner sin = new Scanner(System.in);
        String inputData = sin.nextLine();
            while (!Pattern.matches("[01]{7}", inputData)) {
                System.out.println("Неверный формат данных. Введите 7-значный набор \"0\" или \"1\"");
                inputData = sin.nextLine();
            }
            for (int i = 0; i < inputData.length(); ++i) {
                bits[i] = inputData.charAt(i) - '0';
            }
            int s1 = xor(bits[0], bits[2], bits[4], bits[6]), s2 = xor(bits[1], bits[2], bits[5], bits[6]), s3 = xor(bits[3], bits[4], bits[5], bits[6]);
            int position = s1 + 2 * s2 + 4 * s3;
            if (position == 0) {
                System.out.println("Исходное сообщение: " + bits[2] + bits[4] + bits[5] + bits[6] + "\nОшибок нет");
            } else {
                StringBuilder errPos = new StringBuilder("0000000");
                errPos.setCharAt(position - 1, '1');
                bits[position - 1] = xor(bits[position - 1], 1);
                System.out.println("Исходное сообщение: " + bits[2] + bits[4] + bits[5] + bits[6] + "\nКонфигурация ошибки: " + errPos.toString());
            }
    }

    public static int xor (int a, int b, int c, int d) {
        return (a + b + c + d) % 2;
    }
    public static int xor (int a, int b) {
        return (a + b) % 2;
    }
}
