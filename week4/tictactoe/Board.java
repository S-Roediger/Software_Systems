package ss.week4.tictactoe;

//hasWinner + isFull werken niet correct


/**
 * Board for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * The DIM by DIM fields of the Tic Tac Toe board. See NUMBERING for the
     * coding of the fields.
     */
    //@ private invariant fields.length == DIM*DIM;
    /*@ invariant (\forall int i; 0 <= i & i < DIM*DIM;
        getField(i) == Mark.EMPTY || getField(i) == Mark.XX || getField(i) == Mark.OO); */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     */
    //@ ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
    public Board() {
    	fields = new Mark[DIM * DIM];
    	for (int i = 0; i < DIM * DIM; i++) {
    		fields[i] = Mark.EMPTY;
    	}
    }

    /**
     * Creates a deep copy of this field.
     */
    /*@ ensures \result != this;
        ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                \result.getField(i) == this.getField(i));
      @*/
    public Board deepCopy() {
    	Board b = new Board();
    	for (int i = 0; i < DIM * DIM; i++) {
    		b.setField(i, fields[i]);
    	}
        return b;
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @return the index belonging to the (row,col)-field
     */
    //@ requires 0 <= row & row < DIM;
    //@ requires 0 <= col & col < DIM;
    /*@pure*/
    public int index(int row, int col) {
    	switch (row) {
	    	case 0:
	    		switch (col) {
		    		case 0:
		    			return 0;
		    		case 1:
		    			return 1;
		    		case 2:
		    			return 2;
		    	}
		    case 1:
		    	switch (col) {
		    		case 0: 
		    			return 3;
		    		case 1:
		    			return 4;
		    		case 2:
		    			return 5;
		    	}
		    case 2:
		    	switch (col) {
		    		case 0:
		    			return 6;
		    		case 1:
		    			return 7;
		    		case 2:
		    			return 8;
		    	}
    	}
    	return -1;
    }

    /**
     * Returns true if ix is a valid index of a field on the board.
     * @return true if 0 <= index < DIM*DIM
     */
    //@ ensures \result == (0 <= index && index < DIM * DIM);
    /*@pure*/
    public boolean isField(int index) {
    	return index >= 0 && index < DIM * DIM;
    }

    /**
     * Returns true of the (row,col) pair refers to a valid field on the board.
     *
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    //@ ensures \result == (0 <= row && row < DIM && 0 <= col && col < DIM);
    /*@pure*/
    public boolean isField(int row, int col) {
        return row >= 0 && row < DIM && col >= 0 && col < DIM;
    }
    
    /**
     * Returns the content of the field i.
     *
     * @param i
     *            the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    //@ requires this.isField(i);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int i) {
    	if (isField(i)) {
    		return fields[i];
    	}
        return null;
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return the mark on the field
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int row, int col) {
    	if (isField(row, col)) {
    		return getField(index(row, col));
    	}
        return null;
    }

    /**
     * Returns true if the field i is empty.
     *
     * @param i
     *            the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    //@ requires this.isField(i);
    //@ ensures \result == (this.getField(i) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int i) {
    	if (isField(i)) {
    		return fields[i] == Mark.EMPTY;
    	}
        return false;
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return true if the field is empty
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == (this.getField(row,col) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int row, int col) {
    	if (isField(row, col)) {
    		return fields[index(row, col)] == Mark.EMPTY;
    	}
        return false;
    }

    /**
     * Tests if the whole board is full.
     *
     * @return true if all fields are occupied
     */
    //@ ensures \result == (\forall int i; i <= 0 & i < DIM * DIM; this.getField(i) != Mark.EMPTY);
    /*@pure*/
    public boolean isFull() {
    	for (int i = 0; i < DIM * DIM; i++) {
    		if (this.getField(i) == Mark.EMPTY) {
    			return false;
    		}
    	}
        return true;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     *
     * @return true if the game is over
     */
    //@ ensures \result == this.isFull() || this.hasWinner();
    /*@pure*/
    public boolean gameOver() {
        return this.isFull() || this.hasWinner();
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a row controlled by m
     */
    /*@ pure */
    public boolean hasRow(Mark m) {
    	if (fields[0] == m && fields[1] == m && fields[2] == m) {
    		return true;
    	} else if (fields[3] == m && fields[4] == m && fields[5] == m) {
    		return true;
    	} else if (fields[6] == m && fields[7] == m && fields[8] == m) {
    		return true;
    	}
        return false;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a column controlled by m
     */
    /*@ pure */
    public boolean hasColumn(Mark m) {
    	if (fields[0] == m && fields[3] == m && fields[6] == m) {
    		return true;
    	} else if (fields[1] == m && fields[4] == m && fields[7] == m) {
    		return true;
    	} else if (fields[2] == m && fields[5] == m && fields[8] == m) {
    		return true;
    	}
        return false;
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a diagonal controlled by m
     */
    /*@ pure */
    public boolean hasDiagonal(Mark m) {
    	if (fields[0] == m && fields[4] == m && fields[8] == m) {
    		return true;
    	} else if (fields[2] == m && fields[4] == m && fields[6] == m) {
    		return true;
    	}
        return false;
    }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     *
     * @param m
     *            the mark of interest
     * @return true if the mark has won
     */
    //@requires m == Mark.XX | m == Mark.OO;
    //@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
    /*@ pure */
    public boolean isWinner(Mark m) {
        return this.hasRow(m) || this.hasColumn(m) || this.hasDiagonal(m);
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     *
     * @return true if the student has a winner.
     */
    //@ ensures \result == isWinner(Mark.XX) | \result == isWinner(Mark.OO);
    /*@pure*/
    public boolean hasWinner() {
        return this.isWinner(Mark.OO) || this.isWinner(Mark.XX);
    }

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    /**
     * Empties all fields of this board (i.e., let them refer to the value
     * Mark.EMPTY).
     */
    /*@ ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                this.getField(i) == Mark.EMPTY); @*/
    public void reset() {
    	for (int i = 0; i < DIM * DIM; i++) {
    		fields[i] = Mark.EMPTY;
    	}
    }

    /**
     * Sets the content of field i to the mark m.
     *
     * @param i
     *            the field number (see NUMBERING)
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(i);
    //@ ensures this.getField(i) == m;
    public void setField(int i, Mark m) {
    	if (this.isField(i) && this.isEmptyField(i)) {
    		fields[i] = m;
    	}
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     *
     * @param row
     *            the field's row
     * @param col
     *            the field's column
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(row,col);
    //@ ensures this.getField(row,col) == m;
    public void setField(int row, int col, Mark m) {
    	this.setField(index(row, col), m);
    }
}
