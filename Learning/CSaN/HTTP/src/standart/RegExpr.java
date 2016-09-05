package standart;

import java.util.regex.*;

public class RegExpr {

    private Pattern pattern;

    public void setPattern(String regExpr) {
        pattern = Pattern.compile(regExpr);
    }

    public String getMatch (String input) {
        StringBuilder temp = new StringBuilder();
        Matcher matches = pattern.matcher(input);
        if (matches.find())
            temp.append(matches.group(1));
        return temp.toString();
    }

    public String getMatches (String input) {
        StringBuilder temp = new StringBuilder();
        Matcher matches = pattern.matcher(input);
        while (matches.find()) {
            temp.append(matches.group(1));
            temp.append("\n");
        }
        return temp.toString();
    }
}
