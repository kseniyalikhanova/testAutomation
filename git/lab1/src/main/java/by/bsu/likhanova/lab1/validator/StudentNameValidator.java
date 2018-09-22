package by.bsu.likhanova.lab1.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentNameValidator {
    private static final String PARAMETER_PATTERN = "([A-Z][a-z]{1,10}((\\s)?)){2}";

    public static boolean validateLine(String parameter) {
        Pattern pattern = Pattern.compile(PARAMETER_PATTERN);
        Matcher matcher = pattern.matcher(parameter);
        return matcher.matches();
    }
}
