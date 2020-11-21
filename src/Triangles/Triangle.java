package Triangles;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private final Dot A;
    private final Dot B;
    private final Dot C;

    public Triangle(Dot a, Dot b, Dot c) {
        A = a;
        B = b;
        C = c;
    }

    public Dot getA() {
        return A;
    }

    public Dot getB() {
        return B;
    }

    public Dot getC() {
        return C;
    }

    public boolean isTriangle() {
        return (C.getX() - A.getX()) / (B.getX() - A.getX()) != (C.getY() - A.getY()) / (B.getY() - A.getY());
    }


    public boolean isIsosceles() {
        if (isTriangle()) {
            double sideA = Solution.getLineLength(A, B);
            double sideB = Solution.getLineLength(B, C);
            double sideC = Solution.getLineLength(A, C);
            return (sideA == sideB) || (sideA == sideC) || (sideB == sideC);
        }
        return false;
    }

    public static Triangle value(String s) {
        String[] coords = s.split(" ");
        if (coords.length < 6) {
            return null; // Not enough data
        }
        List<Dot> dots = new ArrayList<>();
        for (int i = 0; i < 6; i += 2) {
            dots.add(new Dot(Double.parseDouble(coords[i]), Double.parseDouble(coords[i + 1])));
        }
        Triangle triangle = new Triangle(dots.get(0), dots.get(1), dots.get(2));
        return triangle.isTriangle() ? triangle : null;
    }

    @Override
    public String toString() {
        return "Triangle:" +
                "Ax=" + A.getX() + "Ay=" + A.getY() +
                ", Bx=" + B.getX() + "By=" + B.getY() +
                ", Cx=" + C.getX() + "Cy=" + C.getY();
    }
}
