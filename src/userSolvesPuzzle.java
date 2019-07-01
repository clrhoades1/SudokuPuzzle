import java.util.Scanner;

public class userSolvesPuzzle {
    private sudokuGenerator generator;
    private sudokuBoard board;
    
    private userSolvesPuzzle() {
        generator = new sudokuGenerator();
        board = sudokuBoard.newBoard();
        board.fillEmptyBoard(board);
    }

/**
 * TODO:
 *      Make the user interface, well, better. 
 *      Compartmentalize my while loop into different functions
 *      Differentiate the numbers the user input and the numbers already there
 *      Check that the user enters a number between 1-9
 */
    public static void main(String [] args) {
        userSolvesPuzzle userInput = new userSolvesPuzzle();
        Scanner kbd = new Scanner(System.in);
        userInput.board = userInput.generator.generatePuzzle();

        while(!userInput.board.isFull()) {
            userInput.board.printBoard();
            System.out.println("Enter The Coordinates of the move you want to make");
            System.out.println("Row: ");
            int row = kbd.nextInt();
            row -= 1;
            System.out.println("Row: " + row);
            System.out.println("Column: ");
            int column = kbd.nextInt();
            column -= 1;
            System.out.println("Column: " + column);
            if(userInput.board.board[row][column].isNumberPermanent()) {
                System.out.println("That location is invalid");
            } else {
                System.out.println("Move: ");
                int move = kbd.nextInt();
                if(sudokuPuzzle.violateNumberRule(userInput.board, row, column, move)) {
                    userInput.board.board[row][column] = new sudokuCell(move, false);
                } else {
                    System.out.println("Invalid move");
                }
            }
        }
        userInput.board.printBoard();
        System.out.println("Congratulations! You solved the sudoku puzzle!");
    }
}