package by.bsu.likhanova.triangle.validation;

import by.bsu.likhanova.triangle.entity.Triangle;

public class TriangleValidation {
    public static boolean isTriangle(Triangle triangle){
        boolean flag = true;
        if (triangle == null){
            flag = false;
        } else if (triangle.getA() <= 0 || triangle.getB() <= 0 || triangle.getC() <= 0) {
            flag = false;
        }
        if(flag == true){
            flag = ((triangle.getA() + triangle.getB() > triangle.getC())
                    && (triangle.getA() + triangle.getC() > triangle.getB())
                    && (triangle.getC() + triangle.getB() > triangle.getA()));
        }
        return flag;
    }
}
