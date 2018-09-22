package by.bsu.likhanova.lab1.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkValidator {
    private static final String PARAMETER_PATTERN = "^([1][0]|[1-9])";

    public static boolean validateLine(String parameter) {
        Pattern pattern = Pattern.compile(PARAMETER_PATTERN);
        Matcher matcher = pattern.matcher(parameter);
        return matcher.matches();
    }
}
