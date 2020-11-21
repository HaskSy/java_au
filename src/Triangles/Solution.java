package Triangles;

import java.util.List;

public class Solution {

    public static double getLineLength(Dot A, Dot B) {
        return Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2));
    }

    public static double getTriangleScale(Triangle triangle) {
        double sideA = Solution.getLineLength(triangle.getA(), triangle.getB());
        double sideB = Solution.getLineLength(triangle.getB(), triangle.getC());
        double sideC = Solution.getLineLength(triangle.getA(), triangle.getC());

        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p*(p - sideA)*(p - sideB)*(p - sideC));
    }


}
