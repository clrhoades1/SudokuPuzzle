
public class sudokuPuzzle {
    /**
     * Determines if a sudoku move is legal
     * @param x:     The Sudoku board in use
     * @param col:   The column of the attempted move
     * @param row:   The row of the attempted move
     * @param move:  The number that is attempting to be added
     * @return       The result of whether the move is legal or not 
     */
    private static boolean legalMove(sudokuBoard x, int col, int row, int move) {
        /** Determines if a sudoku move is legal */
        if(x.board[col][row] == 0 || !violateNumberRule(x, col, row, move)){
            return true;
        }
        return false;
    }

    private static boolean checkSquare(int[] x, int move) {
        for(int counter = 0; counter < 9; counter++) {
            if(move == x[counter]){
                return false;
            }
        }
        return true; 
    }

    /**
     * Checks to see if the square corresponding to the position inputted is valid
     * @param x: The Sudoku board in use
     * @param col: The column of the attempted move
     * @param row: The row of the attempted move
     * @param move: The number that is attempting to be added
     * @return The result of whether the move is legal or not
     */
    private static boolean squareValid(sudokuBoard x, int col, int row, int move) {
        if(col == 0 || col == 1 || col == 2) {
            if(row == 0 || row == 1 || row == 2) {
                return checkSquare(new int[]{x.board[0][0], x.board[0][1], x.board[0][2], x.board[1][0], x.board[1][1], x.board[1][2], x.board[2][0], x.board[2][1], x.board[2][2]}, move);
            }
            if (row == 3 || row == 4 || row == 5) {
                return checkSquare(new int[]{x.board[0][3], x.board[0][4], x.board[0][5], x.board[1][3], x.board[1][4], x.board[1][5], x.board[2][3], x.board[2][4], x.board[2][5]}, move);
            }
            if (row == 6 || row == 7 || row == 8) {
                return checkSquare(new int[] {x.board[0][6], x.board[0][7], x.board[0][8], x.board[1][6], x.board[1][7], x.board[1][8], x.board[2][6], x.board[2][7], x.board[2][8]}, move);
            }
        }
        if (col == 3 || col == 4 || col == 5) {
            if (row == 0 || row == 1 || row == 2) {
                return checkSquare(new int[] { x.board[3][0], x.board[3][1], x.board[3][2], x.board[4][0],
                        x.board[4][1], x.board[4][2], x.board[5][0], x.board[5][1], x.board[5][2] }, move);
            }
            if (row == 3 || row == 4 || row == 5) {
                return checkSquare(new int[] { x.board[3][3], x.board[3][4], x.board[3][5], x.board[4][3],
                        x.board[4][4], x.board[4][5], x.board[5][3], x.board[5][4], x.board[5][5] }, move);
            }
            if (row == 6 || row == 7 || row == 8) {
                return checkSquare(new int[] { x.board[3][6], x.board[3][7], x.board[3][8], x.board[4][6],
                        x.board[4][7], x.board[4][8], x.board[5][6], x.board[5][7], x.board[5][8] }, move);
            }
        }
        if (col == 6 || col == 7 || col == 8) {
            if (row == 0 || row == 1 || row == 2) {
                return checkSquare(new int[] { x.board[6][0], x.board[6][1], x.board[6][2], x.board[7][0],
                        x.board[7][1], x.board[7][2], x.board[8][0], x.board[8][1], x.board[8][2] }, move);
            }
            if (row == 3 || row == 4 || row == 5) {
                return checkSquare(new int[] { x.board[6][3], x.board[6][4], x.board[6][5], x.board[7][3],
                        x.board[7][4], x.board[7][5], x.board[8][3], x.board[8][4], x.board[8][5] }, move);
            }
            if (row == 6 || row == 7 || row == 8) {
                return checkSquare(new int[] { x.board[6][6], x.board[6][7], x.board[6][8], x.board[7][6],
                        x.board[7][7], x.board[7][8], x.board[8][6], x.board[8][7], x.board[8][8] }, move);
            }
        }
        return true; 
    }

    private static boolean violateNumberRule(sudokuBoard x, int col, int row, int move) {
        // Checks if move appears in column col. 
        for(int colCounter = 0; colCounter < 9; colCounter++){
            if(x.board[colCounter][row] == move && colCounter != col){
                return false; 
            }
        }
        // Checks if move appears in row row.
        for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
            if (x.board[col][rowCounter] == move && rowCounter != row) {
                return false;
            }
        }
        // Checks if move appears in the moves corresponding square
        return squareValid(x, col, row, move);
    }

    private static sudokuBoard goThroughRows(int column, int row, sudokuBoard puzzle) {
        int value = 0;
        if(row == 9) {
            return puzzle;
        }
        puzzle.printBoard();
        System.out.println("Current position: " + column + "," + row);
        if(puzzle.board[column][row] == 0) {
            for(value = 1; value < 10; value++) {
                if(violateNumberRule(puzzle, column, row, value)) {
                    puzzle.board[column][row] = value;
                    value = 11;
                }
            }
        } else {
            System.out.println("Idiot");
            for (value = puzzle.board[column][row]; value < 10 ; value++) {
                if(violateNumberRule(puzzle, column, row, value)) {
                    puzzle.board[column][row] = value;
                    value = 11;
                }
            }
        }
        if(value == 10) {
            if(row == 0) {
                puzzle = goThroughRows(column - 1, 8, puzzle);
            } else {
                puzzle = goThroughRows(column, row - 1, puzzle);
            }
        }
        puzzle = goThroughRows(column, ++row, puzzle);
        return puzzle;
    }

    private static sudokuBoard goThroughColumns(int column, sudokuBoard puzzle) {
        puzzle = goThroughRows(column, 0, puzzle);
        if(column != 8) {
            puzzle = goThroughColumns(++column, puzzle);
        }
        return puzzle;
    }

    private static sudokuBoard solvePuzzle(sudokuBoard x) {
        return goThroughColumns(0, x);
    }

    private void userSolvePuzzle() {

    }
    public static void main(String[] args) {
        sudokuBoard forTrial = solvePuzzle(sudokuBoard.fillEmptyBoard(sudokuBoard.newBoard()));
        //forTrial = solvePuzzle(forTrial);
        forTrial.printBoard();
    }
}