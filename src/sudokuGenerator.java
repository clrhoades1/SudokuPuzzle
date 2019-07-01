/* Java program for Sudoku generator  */
import java.util.Random;

public class sudokuGenerator {
    public static Random moveGenerator;

    public sudokuGenerator() {
        moveGenerator = new Random();
    }

    private static sudokuBoard fillMatrix(int row, int column, sudokuBoard x) {
        int maxRow = row + 2;
        int maxCol = column + 2;
        for(int rowCounter = row; rowCounter <= maxRow; rowCounter++) {
            System.out.println("rowCounter: " + rowCounter);
            for(int colCounter = column; colCounter <= maxCol; colCounter++) {
                System.out.println("colCounter: " + colCounter);
                boolean flag = true;
                for(int move = moveGenerator.nextInt(9) + 1; flag; move = moveGenerator.nextInt(9) + 1) {
                    System.out.println("move: " + move);
                    if(sudokuPuzzle.violateNumberRule(x, column, row, move)) {
                        x.board[colCounter][rowCounter] = new sudokuCell(move, true);
                        flag = false;
                    }
                }
            }
        }
        return x;
    }

    private static sudokuBoard removeNDigits(sudokuBoard x, int n) {
        int count = n; 
        while (count != 0) { 
            int cellId = moveGenerator.nextInt(80) + 1; 

            int i = (cellId/9); 
            int j = cellId%9; 
  
            if (x.board[i][j].valueInCell() != 0) 
            { 
                count--; 
                x.board[i][j] = new sudokuCell(0, false); 
            } 
        }
        return x;
    }

/**
 * TODO:
 *      Make sure the generated puzzles are solvable
 *      Set all of the values to permanent
 * 
 */

    static sudokuBoard generatePuzzle() {
        sudokuBoard forTest = sudokuBoard.fillEmptyBoard(sudokuBoard.newBoard());
        sudokuGenerator x = new sudokuGenerator();
        forTest.printBoard();
        forTest = fillMatrix(0, 0, forTest);
        forTest = fillMatrix(3, 3, forTest);
        forTest = fillMatrix(6, 6, forTest);
        forTest = sudokuPuzzle.solvePuzzle(forTest);
        forTest.setAllValuesToPermanent();
        forTest.printBoard();
        forTest = removeNDigits(forTest, 60);
        forTest.printBoard();
        // remove n number of cells in the board
        // make sure it can still be solved
        // return puzzle
        return forTest;
    }
    public static void main(String[] args) {
        generatePuzzle();
    }
}