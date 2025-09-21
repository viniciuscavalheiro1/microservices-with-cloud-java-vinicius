package br.com.vinicius.utils;

import org.springframework.stereotype.Service;

@Service
public class MathUtils {

    public void validationNumber(String first, String second) {
        if (isNumeric(first) || isNumeric(second)) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }
    }

    public void validationNumber(String first) {
        if (isNumeric(first)) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return true;
        String number = strNumber.replace(",", ".");
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
