package com.mounacheikhna.testexplore;

public class Extra {
    String type;
    String value;

    public Extra(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
