package com.mounacheikhna.testexplore;

public class Validator {

    public boolean validate(Extra extra) {
        if("integer".equals(extra.type)) {
            try {
                Integer.valueOf(extra.value);
            }
            catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        else if("boolean".equals(extra.type)) {
            return "true".equals(extra.value)
                    || "false".equals(extra.value);
        }
        else if("string".equals(extra.type)) {
            return true;
        }
        return true;
    }
}
