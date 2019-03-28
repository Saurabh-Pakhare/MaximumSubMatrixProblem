package com.amura.controllers;

import com.amura.models.InputMatrix;
import com.amura.service.CalculateService;
import com.amura.models.CalculationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatrixController {

    @Autowired
    CalculateService calculateService;

    @RequestMapping(value = "api/v1/maximumsubmatrix", method = RequestMethod.POST)
    public CalculationResponse index(@RequestBody InputMatrix inputMatrix) {
        return calculateService.getMaxSubMatrix(inputMatrix.getRows(), inputMatrix.getColumns(), inputMatrix.getMatrix());
    }
}
