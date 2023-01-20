package ru.itmo.prog.samples;

import static java.lang.Math.*;

public class WildMathing {
    public static void main(String[] args) {
        int[] d = new int[15];
        for (int i = 20; i >= 6; --i) {
            d[20 - i] = i;
        }
        float[] x = new float[20];
        for (int i = 0; i < 20; ++i) {
            x[i] = (float)random() * 29 - 15;
        }
        double[][] c = new double[15][20];
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 20; ++j) {
                if ((d[i] >= 9 && d[i] <= 11) || d[i] == 14 || (d[i] >= 16 && d[i] <= 18)) {
                    c[i][j] = func9_18(x[j]);
                }
                else if (d[i] == 7) {
                    c[i][j] = func7(x[j]);
                } else {
                    c[i][j] = funcOthers(x[j]);
                }
            }
        }
        printArray(c);
    }
    static void printRow (double[] row) {
        for (double el: row) {
                System.out.printf("%-15.2f", el);
        }
        System.out.println();
    }
    static void printArray (double[][] arr) {
        for (double[] row : arr) {
            printRow(row);
        }
    }
    static double func7 (float x) {
        return pow(E, 3 * x);
    }
    static double func9_18 (float x) {
        return (pow(E, pow(x + 1 / 3.0, x))) / 2;
    }
    static double funcOthers (float x) {
        return tan(cbrt(pow(x / (x + 4), x) / 6));
    }
}