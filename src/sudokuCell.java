public class sudokuCell {
    private int numberInCell;
    private boolean isPermanentNumber;

    public sudokuCell() {

    }

    public sudokuCell(int x, boolean y) {
        numberInCell = x;
        isPermanentNumber = y;
    }

    public int valueInCell() {
        return this.numberInCell;
    }

    public boolean isNumberPermanent() {
        return this.isPermanentNumber;
    }
}