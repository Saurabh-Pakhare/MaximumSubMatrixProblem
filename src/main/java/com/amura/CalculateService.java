package com.amura;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class CalculateService {

    private int getMaxArea(int row, int column, int[] hist)
    {
        Stack<Integer> stackForIndices = new Stack<>();

        int max_area = 0;
        int stack_top;
        int area_with_top;

        int i = 0;
        while (i < hist.length)
        {
            if (stackForIndices.empty() || hist[stackForIndices.peek()] <= hist[i])
                stackForIndices.push(i++);

            else
            {
                stack_top = stackForIndices.peek();
                stackForIndices.pop();
                area_with_top = hist[stack_top] * (stackForIndices.empty() ? i : i - stackForIndices.peek() - 1);

                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while (!stackForIndices.empty())
        {
            stack_top = stackForIndices.peek();
            stackForIndices.pop();
            area_with_top = hist[stack_top] * (stackForIndices.empty() ? i : i - stackForIndices.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

    public CalculationResponse getMaxSubMatrix(int rows, int columns, int[][] inputMatrix) {
        CalculationResponse response = new CalculationResponse();
        int result = getMaxArea(rows, columns, inputMatrix[0]);

        for (int i = 1; i < rows; i++)
        {

            for (int j = 0; j < columns; j++)

                if (inputMatrix[i][j] == 1) inputMatrix[i][j] += inputMatrix[i - 1][j];


            result = Math.max(result, getMaxArea(rows,columns,inputMatrix[i]));
        }

        response.setLongestSubMatrixArea(result);
        return response;
    }
}

