public class sudokuPuzzle {
    /**
     *               Determines if a sudoku move is legal
     * @param x:     The Sudoku board in use
     * @param col:   The column of the attempted move
     * @param row:   The row of the attempted move
     * @param move:  The number that is attempting to be added
     * @return       The result of whether the move is legal or not 
     */
    private static boolean legalMove(sudokuBoard x, int col, int row, int move) {
        /** Determines if a sudoku move is legal */
        if(x.board[col][row].valueInCell() == 0 || !violateNumberRule(x, col, row, move)){
            return true;
        }
        return false;
    }

    /**
     *              Checks the array x to find if x occurs in array x. 
     * @param x     The array being checked. 
     * @param move  The value being checked for. 
     * @return      Whether the value exists in x.
     */
    private static boolean checkSquare(int[] x, int move) {
        for(int counter = 0; counter < 9; counter++) {
            if(move == x[counter]){
                return false;
            }
        }
        return true; 
    }

    /**
     *              Checks to see if the square corresponding to the position inputted is valid
     * @param x     The Sudoku board in use
     * @param col   The column of the attempted move
     * @param row   The row of the attempted move
     * @param move  The number that is attempting to be added
     * @return      The result of whether the move is legal or not
     */
    private static boolean squareValid(sudokuBoard x, int col, int row, int move) {
        if(col == 0 || col == 1 || col == 2) {
            if(row == 0 || row == 1 || row == 2) {
                return checkSquare(new int[]{x.board[0][0].valueInCell(), x.board[0][1].valueInCell(), x.board[0][2].valueInCell(), x.board[1][0].valueInCell(), x.board[1][1].valueInCell(), x.board[1][2].valueInCell(), x.board[2][0].valueInCell(), x.board[2][1].valueInCell(), x.board[2][2].valueInCell()}, move);
            }
            if (row == 3 || row == 4 || row == 5) {
                return checkSquare(new int[]{x.board[0][3].valueInCell(), x.board[0][4].valueInCell(), x.board[0][5].valueInCell(), x.board[1][3].valueInCell(), x.board[1][4].valueInCell(), x.board[1][5].valueInCell(), x.board[2][3].valueInCell(), x.board[2][4].valueInCell(), x.board[2][5].valueInCell()}, move);
            }
            if (row == 6 || row == 7 || row == 8) {
                return checkSquare(new int[] {x.board[0][6].valueInCell(), x.board[0][7].valueInCell(), x.board[0][8].valueInCell(), x.board[1][6].valueInCell(), x.board[1][7].valueInCell(), x.board[1][8].valueInCell(), x.board[2][6].valueInCell(), x.board[2][7].valueInCell(), x.board[2][8].valueInCell()}, move);
            }
        }
        if (col == 3 || col == 4 || col == 5) {
            if (row == 0 || row == 1 || row == 2) {
                return checkSquare(new int[] { x.board[3][0].valueInCell(), x.board[3][1].valueInCell(), x.board[3][2].valueInCell(), x.board[4][0].valueInCell(),
                        x.board[4][1].valueInCell(), x.board[4][2].valueInCell(), x.board[5][0].valueInCell(), x.board[5][1].valueInCell(), x.board[5][2].valueInCell()}, move);
            }
            if (row == 3 || row == 4 || row == 5) {
                return checkSquare(new int[] { x.board[3][3].valueInCell(), x.board[3][4].valueInCell(), x.board[3][5].valueInCell(), x.board[4][3].valueInCell(),
                        x.board[4][4].valueInCell(), x.board[4][5].valueInCell(), x.board[5][3].valueInCell(), x.board[5][4].valueInCell(), x.board[5][5].valueInCell()}, move);
            }
            if (row == 6 || row == 7 || row == 8) {
                return checkSquare(new int[] { x.board[3][6].valueInCell(), x.board[3][7].valueInCell(), x.board[3][8].valueInCell(), x.board[4][6].valueInCell(),
                        x.board[4][7].valueInCell(), x.board[4][8].valueInCell(), x.board[5][6].valueInCell(), x.board[5][7].valueInCell(), x.board[5][8].valueInCell()}, move);
            }
        }
        if (col == 6 || col == 7 || col == 8) {
            if (row == 0 || row == 1 || row == 2) {
                return checkSquare(new int[] { x.board[6][0].valueInCell(), x.board[6][1].valueInCell(), x.board[6][2].valueInCell(), x.board[7][0].valueInCell(),
                        x.board[7][1].valueInCell(), x.board[7][2].valueInCell(), x.board[8][0].valueInCell(), x.board[8][1].valueInCell(), x.board[8][2].valueInCell()}, move);
            }
            if (row == 3 || row == 4 || row == 5) {
                return checkSquare(new int[] { x.board[6][3].valueInCell(), x.board[6][4].valueInCell(), x.board[6][5].valueInCell(), x.board[7][3].valueInCell(),
                        x.board[7][4].valueInCell(), x.board[7][5].valueInCell(), x.board[8][3].valueInCell(), x.board[8][4].valueInCell(), x.board[8][5].valueInCell()}, move);
            }
            if (row == 6 || row == 7 || row == 8) {
                return checkSquare(new int[] { x.board[6][6].valueInCell(), x.board[6][7].valueInCell(), x.board[6][8].valueInCell(), x.board[7][6].valueInCell(),
                        x.board[7][7].valueInCell(), x.board[7][8].valueInCell(), x.board[8][6].valueInCell(), x.board[8][7].valueInCell(), x.board[8][8].valueInCell()}, move);
            }
        }
        return true; 
    }

    /**
     *                  Checks to see if the row is filled
     * @param x         The sudokuBoard being checked
     * @param column    The row being checked. 
     * @return          True if the row is not full. 
     */
    private static boolean rowIsNotFull(sudokuBoard x, int column) {
        // Checks if move appears in column col.
        for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
            if (x.board[column][rowCounter].valueInCell() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     *              Checks to see if the move given violates the sudoku rules. 
     * @param x     The sudokuBoard being checked
     * @param col   The column that move is being applied to.
     * @param row   The row that move is being applied to. 
     * @param move  The value that has been given. 
     * @return      Whether the rule is valid or not in the form of a boolean. 
     */
    public static boolean violateNumberRule(sudokuBoard x, int col, int row, int move) {
        // Checks if move appears in column col. 
        for(int colCounter = 0; colCounter < 9; colCounter++){
            if (x.board[colCounter][row].valueInCell() == move && colCounter != col) {
                return false; 
            }
        }

        // Checks if move appears in row row.
        for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
            //if (x.board[col][rowCounter].valueInCell() == move && rowCounter != row) {
            if (x.board[col][rowCounter].valueInCell() == move && rowCounter != row) {
                return false;
            }
        }

        // Checks if move appears in the moves corresponding square
        return squareValid(x, col, row, move);
    }

    /**
     *                  The unoccupied cell is checked using all the possible moves to see if one
     *                  of them fits into the puzzle. If there isn't a valid move, it returns 10.
     * @param puzzle    The sudokuBoard being checked.
     * @param column    The column of the cell being checked. 
     * @param row       The row of the cell being checked. 
     * @return          The value that can be put into the cell. If there isn't a possible valid
     *                  move to add, then 10 is returned. 
     */
    private static int nonoccupiedCell(sudokuBoard puzzle, int column, int row) {
        for (int value = 1; value < 10; value++) {
            if (violateNumberRule(puzzle, column, row, value)) {
                return value;
            }
        }
        return 10;
    }

    /**
     *                  The occupied cell is checked using all the possible moves that come 
     *                  after the value already in the cell to see if one fits into the puzzle. 
     *                  If there isn't a valid move, it returns 10.
     * @param puzzle    the sudokuBoard being checked.
     * @param column    The column of the cell being checked.
     * @param row       The row of the cell being checked.
     * @return          The value that can be put into the cell. If there isn't a possible
     *                  valid move to add, then 10 is returned.
     */
    private static int occupiedCell(sudokuBoard puzzle, int column, int row) {
        for(int value = puzzle.board[column][row].valueInCell();value < 10; value++) {
            if (violateNumberRule(puzzle, column, row, value)) {
                return value;
            }
        }
        return 10;
    }

    /**
     *                  Backtracks the puzzle passed on the current row value.
     * @param column    The current column being checked. 
     * @param row       The current row being checked. 
     * @param puzzle    The current puzzle being checked. 
     * @return          The recursive call of the backtracked puzzle. 
     */
    private static sudokuBoard backtrackPuzzle(int column, int row, sudokuBoard puzzle) {
        if (row == 0) {
            return goThroughRows(column - 1, 8, puzzle);
        } else {
            return goThroughRows(column, row - 1, puzzle);
        }
    }

    /**
     *                  goThroughRows is the recursive algorithm to solve the sudokuBoard utilizing 
     *                  a form of backtracking. 
     * @param column    The current column being checked.
     * @param row       The current row being checked.
     * @param puzzle    The current puzzle being checked. 
     * @return          The puzzle with the current column filled with valid moves. 
     */
    private static sudokuBoard goThroughRows(int column, int row, sudokuBoard puzzle) {
        if (row == 9) {
            puzzle.columnWhenReturned = column;
            return puzzle;
        }

        if(puzzle.board[column][row].isNumberPermanent()){
            if(puzzle.currentlyBacktracking == false) {
                System.out.println("Current position: " + column + "," + row);
                return goThroughRows(column, row + 1, puzzle); 
            } else { 
                return backtrackPuzzle(column, row, puzzle);
            }
        }

        // For debugging purposes
        // ---------------------------------------------------------------------------------------
        // puzzle.printBoard();
        // System.out.println("Current position: " + column + "," + row);
        // ---------------------------------------------------------------------------------------

        int value = ((puzzle.board[column][row].valueInCell() == 0) ? nonoccupiedCell(puzzle, column, row) : occupiedCell(puzzle, column, row));

        // For debugging purposes
        // ---------------------------------------------------------------------------------------
        // System.out.println("Current value: " + value);
        // ---------------------------------------------------------------------------------------


        if(value != 10) {
            puzzle.board[column][row] = new sudokuCell(value, false);
        } else {
            puzzle.board[column][row] = new sudokuCell(0, false);
            puzzle.currentlyBacktracking = true;
            return backtrackPuzzle(column, row, puzzle);
        }
        puzzle.currentlyBacktracking = false;

        return goThroughRows(column, row + 1, puzzle);
    }

    /**
     *                  Goes through all of the columns in order to solve the sudoku puzzle. 
     * @param column    The current column being checked. 
     * @param puzzle    The current puzzle being checked. 
     * @return          A solved sudoku puzzle. 
     */
    private static sudokuBoard goThroughColumns(int column, sudokuBoard puzzle) {
        puzzle = goThroughRows(column, 0, puzzle);
        if(puzzle.columnWhenReturned != 8) {
            puzzle = goThroughColumns(++puzzle.columnWhenReturned, puzzle);
        }
        return puzzle;
    }

    /**
     *              Solves the sudoku puzzle.
     * @param x     The sudokuBoard being solved.
     * @return      The solved sudoku puzzle. 
     */
    public static sudokuBoard solvePuzzle(sudokuBoard x) {
        return goThroughColumns(0, x);
    }

    public static void main(String[] args) {
        //sudokuBoard forTrial = solvePuzzle(sudokuBoard.fillEmptyBoard(sudokuBoard.newBoard()));
        //forTrial.printBoard();
        /**
         * int grid[DIM][DIM] = { { 0, 9, 0, 0, 0, 0, 8, 5, 3 }, { 0, 0, 0, 8, 0, 0, 0,
         * 0, 4 }, { 0, 0, 8, 2, 0, 3, 0, 6, 9 }, { 5, 7, 4, 0, 0, 2, 0, 0, 0 }, { 0, 0,
         * 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 9, 0, 0, 6, 3, 7 }, { 9, 4, 0, 1, 0, 8, 5,
         * 0, 0 }, { 7, 0, 0, 0, 0, 6, 0, 0, 0 }, { 6, 8, 2, 0, 0, 0, 0, 9, 0 } };
         */
        sudokuBoard forTrial2 = new sudokuBoard(); 
        sudokuCell[][] boardForTrial = {
            {new sudokuCell(0,false),new sudokuCell(9,true),new sudokuCell(0,false), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(8,true),new sudokuCell(5,true),new sudokuCell(3,true)}, 
            {new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(8,true),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(4,true)}, 
            {new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(8,true), 
                new sudokuCell(2,true),new sudokuCell(0,false),new sudokuCell(3,true), 
                new sudokuCell(0,false),new sudokuCell(6,true),new sudokuCell(9,true)}, 
            {new sudokuCell(5,true),new sudokuCell(7,true),new sudokuCell(4,true), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(2,true), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false)}, 
            {new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0, false), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false)}, 
            {new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(9,true),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(6,true),new sudokuCell(3,true),new sudokuCell(7,true)}, 
            {new sudokuCell(9,true),new sudokuCell(4,true),new sudokuCell(0,false), 
                new sudokuCell(1,true),new sudokuCell(0,false),new sudokuCell(8,true), 
                new sudokuCell(5,true),new sudokuCell(0,false),new sudokuCell(0,false)}, 
            {new sudokuCell(7,true),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(6,true), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false)}, 
            {new sudokuCell(6,true),new sudokuCell(8,true),new sudokuCell(2,true), 
                new sudokuCell(0,false),new sudokuCell(0,false),new sudokuCell(0,false), 
                new sudokuCell(0,false),new sudokuCell(9,true),new sudokuCell(0,false)}, 
            };
         
         

        forTrial2.setBoard(boardForTrial); 
        forTrial2.printBoard();
        sudokuBoard solvedBoard = solvePuzzle(forTrial2); 
        solvedBoard.printBoard();
        
        /**
         * {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         * {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         * {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         * {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         * {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         * {0, 5, 0,0, 9, 0, 6, 0, 0}, 
         * {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         * {0, 0, 0, 0, 0, 0, 0, 7, 4},
         * {0, 0, 5, 2, 0, 6, 3, 0, 0}
         */

        sudokuBoard forTrial3 = new sudokuBoard();
        sudokuCell[][] boardForTrial3 = {
            { new sudokuCell(3, true), new sudokuCell(0, false), new sudokuCell(6, true), new sudokuCell(5, true),
                    new sudokuCell(0, false), new sudokuCell(8, true), new sudokuCell(4, true),
                    new sudokuCell(0, false), new sudokuCell(0, false) },
            { new sudokuCell(5, true), new sudokuCell(2, true), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(0, false), new sudokuCell(0, false) },
            { new sudokuCell(0, false), new sudokuCell(8, true), new sudokuCell(7, true), new sudokuCell(0, false),
                    new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(3, true), new sudokuCell(1, true) },
            { new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(3, true), new sudokuCell(0, false),
                    new sudokuCell(1, true), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(8, true), new sudokuCell(0, false) },
            { new sudokuCell(9, true), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(8, true), new sudokuCell(6, true), new sudokuCell(3, true),
                    new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(5, true) },
            { new sudokuCell(0, false), new sudokuCell(5, true), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(9, true), new sudokuCell(0, false), new sudokuCell(6, true),
                    new sudokuCell(0, false), new sudokuCell(0, false) },
            { new sudokuCell(1, true), new sudokuCell(3, true), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(2, true),
                    new sudokuCell(5, true), new sudokuCell(0, false) },
            { new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(0, false),
                    new sudokuCell(7, true), new sudokuCell(4, true) },
            { new sudokuCell(0, false), new sudokuCell(0, false), new sudokuCell(5, true), new sudokuCell(2, true),
                    new sudokuCell(0, false), new sudokuCell(6, true), new sudokuCell(3, true),
                    new sudokuCell(0, false), new sudokuCell(0, false) }, 
            };

        forTrial3.setBoard(boardForTrial3);
        forTrial3.printBoard();
        sudokuBoard solvedBoard2 = solvePuzzle(forTrial3);
        solvedBoard2.printBoard();
    }
}