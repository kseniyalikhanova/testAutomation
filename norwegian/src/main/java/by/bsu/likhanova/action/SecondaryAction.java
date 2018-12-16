package by.bsu.likhanova.action;

import org.openqa.selenium.WebElement;

public class SecondaryAction {

    public static String changedPositionValueOfSlider(final WebElement fiftyEuro,
                                                      final WebElement budgetSlider) {
        String positionOfFiftyEuro = fiftyEuro.getAttribute("style").split(" ")[1].split("[;]")[0];

        StringBuilder positionOfBudgetSlider = new StringBuilder(budgetSlider.getAttribute("style"));
        positionOfBudgetSlider.replace(positionOfBudgetSlider.indexOf("(") + 1,
                positionOfBudgetSlider.lastIndexOf(")"),
                positionOfFiftyEuro);
        return positionOfBudgetSlider.toString();
    }
}
