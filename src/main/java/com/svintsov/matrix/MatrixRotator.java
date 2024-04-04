package com.svintsov.matrix;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MatrixRotator {

    public List<Integer> spiralOrder(int[][] matrix) {
        return getSpiral(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private List<Integer> getSpiral(int[][] fullMatrix, int actualFirstRow, int actualLastRow, int actualFirstColumn,
                                    int actualLastColumn) {

        if (actualFirstRow > actualLastRow || actualFirstColumn > actualLastColumn) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int c = actualFirstColumn; c <= actualLastColumn; c++) {
            result.add(fullMatrix[actualFirstRow][c]);
        }
        for (int r = actualFirstRow + 1; r <= actualLastRow; ++r) {
            result.add(fullMatrix[r][actualLastColumn]);
        }
        if (actualFirstRow!=actualLastRow) {
            for (int c = actualLastColumn - 1; c >= actualFirstColumn; c--) {
                result.add(fullMatrix[actualLastRow][c]);
            }
        }
        if (actualFirstColumn!=actualLastColumn) {
            for (int r = actualLastRow - 1; r >= actualFirstRow + 1; --r) {
                result.add(fullMatrix[r][actualFirstColumn]);
            }
        }
        List<Integer> nextSpiral = getSpiral(fullMatrix, actualFirstRow + 1, actualLastRow - 1, actualFirstColumn + 1
                , actualLastColumn - 1);
        result.addAll(nextSpiral);
        return result;
    }

}
