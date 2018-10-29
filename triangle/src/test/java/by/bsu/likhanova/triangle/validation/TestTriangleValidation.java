package by.bsu.likhanova.triangle.validation;

import by.bsu.likhanova.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTriangleValidation {

    @DataProvider(name = "zeroSides")
    public static Object[][] zeroSides() {
        return new Object[][]{
                {0, 4, 5},
                {2, 0, 5},
                {2, 4, 0},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "negativeSides")
    public static Object[][] negativeSides() {
        return new Object[][]{
                {-1, 3, 1},
                {1, -3, 1},
                {1, 3, -1},
                {-1, -3, -1}
        };
    }

    @DataProvider(name = "incorrectSides")
    public static Object[][] incorrectSides() {
        return new Object[][]{
                {3, 1, 5},
                {5, 3, 1},
                {3, 5, 1},
        };
    }

    @Test
    public void isTriangle() {
        Assert.assertTrue(TriangleValidation.isTriangle(new Triangle(3, 4, 5)));
    }

    @Test(dataProvider = "incorrectSides")
    public void isNotTriangle(double a, double b, double c) {
        Assert.assertFalse(TriangleValidation.isTriangle(new Triangle(a, b, c)));
    }

    @Test(dataProvider = "zeroSides")
    public void isNotZeroSides(double a, double b, double c) {
        Assert.assertFalse(TriangleValidation.isTriangle(new Triangle(a, b, c)));
    }

    @Test(dataProvider = "negativeSides")
    public void isNotNegativeSides(double a, double b, double c) {
        Assert.assertFalse(TriangleValidation.isTriangle(new Triangle(a, b, c)));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(TriangleValidation.isTriangle(null));
    }
}
