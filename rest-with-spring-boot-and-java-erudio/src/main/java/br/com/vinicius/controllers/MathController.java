package br.com.vinicius.controllers;

import br.com.vinicius.utils.MathUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    MathUtils mathUtils = new MathUtils();

    @RequestMapping("/sum/{first}/{second}")
    public Double sum(
            @PathVariable("first") String first,
            @PathVariable("second") String second
    ) {
        mathUtils.validationNumber(first, second);
        return mathUtils.convertToDouble(first) + mathUtils.convertToDouble(second);
    }

    @RequestMapping("/subtraction/{first}/{second}")
    public Double subtraction(
            @PathVariable("first") String first,
            @PathVariable("second") String second
    ) {
        mathUtils.validationNumber(first, second);
        return mathUtils.convertToDouble(first) - mathUtils.convertToDouble(second);
    }

    @RequestMapping("/multiplication/{first}/{second}")
    public Double multiplication(
            @PathVariable("first") String first,
            @PathVariable("second") String second
    ) {
        mathUtils.validationNumber(first, second);
        return mathUtils.convertToDouble(first) * mathUtils.convertToDouble(second);
    }

    @RequestMapping("/divide/{first}/{second}")
    public Double divide(
            @PathVariable("first") String first,
            @PathVariable("second") String second
    ) {
        mathUtils.validationNumber(first, second);
        return mathUtils.convertToDouble(first) / mathUtils.convertToDouble(second);
    }

    @RequestMapping("/median/{first}/{second}")
    public Double median (
            @PathVariable("first") String first,
            @PathVariable("second") String second
    ) {
        mathUtils.validationNumber(first, second);
        return (mathUtils.convertToDouble(first) + mathUtils.convertToDouble(second)) / 2;
    }

    @RequestMapping("/square/{first}")
    public Double square(
            @PathVariable("first") String first
    ) {
        mathUtils.validationNumber(first);
        return Math.sqrt(mathUtils.convertToDouble(first));
    }
}
