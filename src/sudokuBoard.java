
public class sudokuBoard {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public sudokuCell[][] board; // First array is columns, second array rows
    public boolean currentlyBacktracking;
    public int columnWhenReturned;

    sudokuBoard() {
        board = new sudokuCell[9][9];
        currentlyBacktracking = false;
        columnWhenReturned = 0;
    }

    static sudokuBoard newBoard() {
        return new sudokuBoard();
    }

    void setBoard(sudokuCell[][] x) {
        this.board = x;
    }

    static sudokuBoard fillEmptyBoard(sudokuBoard x) {
        for (int count1 = 0; count1 < 9; count1++) {
            for (int count2 = 0; count2 < 9; count2++) {
                x.board[count1][count2] = new sudokuCell(0, false);
            }
        }
        return x;
    }

    public boolean isFull() {
        for(int colCounter = 0; colCounter <= 8; colCounter++) {
            for(int rowCounter = 0; rowCounter <= 8; rowCounter++) {
                if(this.board[colCounter][rowCounter].valueInCell() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public void printBoard() {
        /* Series of print statments that will print the board **/
        System.out.println("\n-------------------------------------");

        for (int count1 = 0; count1 < 9; count1++) {
            System.out.print("| ");
            for (int count2 = 0; count2 < 9; count2++) {
                if (this.board[count1][count2].valueInCell() == 0) {
                    System.out.print("  | ");
                } else if(this.board[count1][count2].isNumberPermanent()) {
                    System.out.print(ANSI_RED + this.board[count1][count2].valueInCell() + ANSI_RESET + " | ");
                } else {
                    System.out.print(this.board[count1][count2].valueInCell() + " | ");
                }
            }
            System.out.println("\n-------------------------------------");
        }

    }

    public static int indexOfBoard(sudokuBoard x, int y, int z) {
        return x.board[y][z].valueInCell();
    }

    private static boolean sudokuRules() {
        /** Holds the rules for creating a board */
        return true;
    }

    void setAllValuesToPermanent() {
        for (int count1 = 0; count1 < 9; count1++) {
            for (int count2 = 0; count2 < 9; count2++) {
                this.board[count1][count2] = new sudokuCell(this.board[count1][count2].valueInCell(), true);
            }
        }
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