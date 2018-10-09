package by.bsu.likhanova.triangle.validation;

import by.bsu.likhanova.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTriangleValidation {
    @Test
    public void isTrueExist(){
        Triangle triangle = new Triangle(3,4,5);
        Assert.assertTrue(TriangleValidation(triangle));
    }

    @Test
    public void isFalseExist(){
        Triangle triangle = new Triangle(3,1,5);
        Assert.assertTrue(TriangleValidation(triangle));
    }

    @Test
    public void notEqualsZero(){
        Triangle triangle = new Triangle(0, 2, 5);
        Assert.assertFalse(TriangleValidation(triangle));
    }

    @Test
    public void notEqualsNegative(){
        Triangle triangle = new Triangle(-1, 3, 1);
        Assert.assertFalse(TriangleValidation(triangle));
    }
}
