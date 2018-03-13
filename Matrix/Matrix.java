package com.emilg1101;

public class Matrix {

    private int[][] matrix;

    private int rows;
    private int columns;

    public Matrix(int[][] matrix) {
        if (matrix == null) throw new NullPointerException();
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    public Matrix(int rows, int columns) {
        if (rows < 0 || columns < 0) throw new IllegalArgumentException();
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[this.rows][this.columns];
    }

    public static Matrix identity(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        int[][] mtx = new int[n][n];
        for (int i = 0; i < n; i++) {
            mtx[i][i] = 1;
        }
        return new Matrix(mtx);
    }

    public int getValue(int row, int column) {
        return matrix[row][column];
    }

    public int det() {
        if (rows != columns) throw new IllegalArgumentException("Illegal matrix dimensions");
        return det(this.matrix);
    }

    private int det(int[][] matrix) {
        int temp[][];
        int result = 0;

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        if (matrix.length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temp = new int[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow(-1, i) * det(temp);
        }
        return (result);
    }

    public Matrix transpose() {
        int[][] trMtx = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                trMtx[j][i] = matrix[i][j];
            }
        }
        return new Matrix(trMtx);
    }

    public Matrix sum(Matrix matrix) {
        if (matrix == null) throw new NullPointerException();
        if (rows != matrix.rows || columns != matrix.columns) throw new RuntimeException("The matrices have different sizes");
        return new Matrix(sum(this.matrix, matrix.matrix));
    }

    public Matrix sub(Matrix matrix) {
        if (matrix == null) throw new NullPointerException();
        if (rows != matrix.rows || columns != matrix.columns) throw new RuntimeException("The matrices have different sizes");
        return new Matrix(sub(this.matrix, matrix.matrix));
    }

    public Matrix mult(int n) {
        int[][] mtx = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mtx[i][j] = this.matrix[i][j] * n;
            }
        }
        return new Matrix(mtx);
    }

    public Matrix mult(Matrix matrix) {
        if (matrix == null) throw new NullPointerException();
        if (columns != matrix.rows) throw new IllegalArgumentException("Illegal matrix dimensions");

        if (rows == matrix.rows && rows == matrix.columns) {
            return new Matrix(strassen(this.matrix, matrix.matrix));
        }

        int[][] multMtx = new int[columns][matrix.rows];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < matrix.columns; ++j) {
                for (int k = 0; k < columns; ++k) {
                    multMtx[i][j] += this.matrix[i][k] * matrix.matrix[k][j];
                }
            }
        }
        return new Matrix(multMtx);
        //return new Matrix(mult(this.matrix, matrix.matrix));
        //return new Matrix(strassen(this.matrix, matrix.getMatrix()));
    }

    private int[][] sum(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] c = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    private int[][] sub(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] c = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    private int[][] mult(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    private int[][] strassen(int[][] a, int[][] b) {
        int n = a.length;
        if (n <= 1) {
            return mult(a, b);
        } else {
            int newSize = n / 2;
            int[][] a11 = new int[newSize][newSize];
            int[][] a12 = new int[newSize][newSize];
            int[][] a21 = new int[newSize][newSize];
            int[][] a22 = new int[newSize][newSize];

            int[][] b11 = new int[newSize][newSize];
            int[][] b12 = new int[newSize][newSize];
            int[][] b21 = new int[newSize][newSize];
            int[][] b22 = new int[newSize][newSize];

            int[][] aResult;
            int[][] bResult;
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    a11[i][j] = a[i][j];
                    a12[i][j] = a[i][j + newSize];
                    a21[i][j] = a[i + newSize][j];
                    a22[i][j] = a[i + newSize][j + newSize];

                    b11[i][j] = b[i][j];
                    b12[i][j] = b[i][j + newSize];
                    b21[i][j] = b[i + newSize][j];
                    b22[i][j] = b[i + newSize][j + newSize];
                }
            }

            aResult = sum(a11, a22);
            bResult = sum(b11, b22);
            int[][] p1 = strassen(aResult, bResult);

            aResult = sum(a21, a22);
            int[][] p2 = strassen(aResult, b11);

            bResult = sub(b12, b22);
            int[][] p3 = strassen(a11, bResult);

            bResult = sub(b21, b11);
            int[][] p4 = strassen(a22, bResult);

            aResult = sum(a11, a12);
            int[][] p5 = strassen(aResult, b22);

            aResult = sub(a21, a11);
            bResult = sum(b11, b12);
            int[][] p6 = strassen(aResult, bResult);

            aResult = sub(a12, a22);
            bResult = sum(b21, b22);
            int[][] p7 = strassen(aResult, bResult);

            int[][] c12 = sum(p3, p5);
            int[][] c21 = sum(p2, p4);

            aResult = sum(p1, p4);
            bResult = sum(aResult, p7);
            int[][] c11 = strassen(bResult, p5);

            aResult = sum(p1, p3);
            bResult = sum(aResult, p6);
            int[][] c22 = strassen(bResult, p2);

            int[][] c = new int[n][n];
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    c[i][j] = c11[i][j];
                    c[i][j + newSize] = c12[i][j];
                    c[i + newSize][j] = c21[i][j];
                    c[i + newSize][j + newSize] = c22[i][j];
                }
            }
            return c;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Matrix matrix = (Matrix) obj;
        if (rows != matrix.rows) return false;
        if (columns != matrix.columns) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.matrix[i][j] != matrix.getValue(i, j)) return false;
            }
        }
        return true;
    }
}