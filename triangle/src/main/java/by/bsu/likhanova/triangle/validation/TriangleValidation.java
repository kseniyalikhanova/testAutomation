package by.bsu.likhanova.triangle.validation;

import by.bsu.likhanova.triangle.entity.Triangle;

public class TriangleValidation {
    public static boolean isTriangle(Triangle triangle) {
        boolean isTriangle;
        if (triangle == null) {
            isTriangle = false;
        } else if (triangle.getA() <= 0 || triangle.getB() <= 0 || triangle.getC() <= 0) {
            isTriangle = false;
        } else {
            isTriangle = ((triangle.getA() + triangle.getB() > triangle.getC())
                    && (triangle.getA() + triangle.getC() > triangle.getB())
                    && (triangle.getC() + triangle.getB() > triangle.getA()));
        }
        return isTriangle;
    }
}
