package task3;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TriangleSorting {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in).useLocale(Locale.US);
        String checkContinuation;
        String[] triangleName = new String[100];
        double[] triangleArea = new double[100];
        int countItem = 0;
        double firstTriangleSide;
        double secondTriangleSide;
        double thirdTriangleSide;
        do {
            System.out.println("Please enter the name of the triangle and its three sides" +
                    "(Triangle name, side A, side B, side C:");
            triangleName[countItem] = keyboard.next().replace(",", "");
            firstTriangleSide = Double.parseDouble(keyboard.next().replace(",", ""));
            secondTriangleSide = Double.parseDouble(keyboard.next().replace(",", ""));
            thirdTriangleSide = Double.parseDouble(keyboard.next().replace(",", ""));
            triangleArea[countItem] = triangleAreaGerone(firstTriangleSide, secondTriangleSide, thirdTriangleSide);
            countItem++;
            System.out.print("Do you want to enter data for another triangle? YES(y) / NO(n) : ");
            checkContinuation = keyboard.next().toLowerCase();
        } while (checkContinuation.contentEquals("y") || checkContinuation.contentEquals("yes"));
        triangleSort(triangleName, triangleArea, countItem);
    }

    public static double triangleAreaGerone(double a, double b, double c) {
        double result;
        double scale = Math.pow(10, 3);
        double halfPerimeter = (a + b + c) / 2;
        result = sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * halfPerimeter - c);
        return Math.ceil(result * scale) / scale;
    }

    public static void triangleSort(String[] triangleName, double[] triangleArea, int countItem) {
        // bubble sorting method of the array
        double temp;
        String tempName = "";
        for (int i = 0; i < countItem - 1; i++) {
            for (int j = 1; j < (countItem - 1 - i); j++) {
                if (triangleArea[j - 1] > triangleArea[j]) {
                    //swap elements
                    temp = triangleArea[j - 1];
                    tempName = triangleName[j - 1];
                    triangleArea[j - 1] = triangleArea[j];
                    triangleName[j - 1] = triangleName[j];
                    triangleArea[j] = temp;
                    triangleName[j] = tempName;
                }
            }
        }
        System.out.println("=============Triangles list=============");
        for (int index = 0; index <= countItem - 1; index++) {
            System.out.println(index + 1 + "." + "[Triangle " + triangleName[index] + "]:" + triangleArea[index] + " cm");
        }
    }
}
