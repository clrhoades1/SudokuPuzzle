
public class sudokuBoard {
    int[][] board; // First array is columns, second array rows

    private sudokuBoard() {
        board = new int[9][9];
    }

    static sudokuBoard newBoard() {
        return new sudokuBoard();
    }

    static sudokuBoard fillEmptyBoard(sudokuBoard x) {
        for (int count1 = 0; count1 < 9; count1++) {
            for (int count2 = 0; count2 < 9; count2++) {
                x.board[count1][count2] = 0;
            }
        }
        return x;
    }

    public void printBoard() {
        /* Series of print statments that will print the board **/
        System.out.println("\n-------------------------------------");

        for (int count1 = 0; count1 < 9; count1++) {
            System.out.print("|");
            for (int count2 = 0; count2 < 9; count2++) {
                if (this.board[count1][count2] == 0) {
                    System.out.print("   |");
                } else {
                    System.out.print(this.board[count1][count2] + " | ");
                }
            }
            System.out.println("\n-------------------------------------");
        }

    }

    public static int indexOfBoard(sudokuBoard x, int y, int z) {
        return x.board[y][z];
    }

    private static boolean sudokuRules() {
        /** Holds the rules for creating a board */
        return true;
    }

    private static boolean legalPuzzle(sudokuBoard x) {
        /** Determines if the puzzle is legal */
        // 1. It can only have one solution
        // 2. Horizontal, vertical, and square rules
        return false;
    }

    private static sudokuBoard randomFillBoard() {
        sudokuBoard board = newBoard();

        /** Randomly fill the board for users to solve */

        return board;
    }

    public static void main(String[] args) { // For debugging and testing purposes
        sudokuBoard forTrial = fillEmptyBoard(newBoard());
        forTrial.printBoard();
    }
}