package tictactoe.bean;

public class Board {
	private final int size;
	private Cell[][] cells;
	private Move currentMove;

	public Board(int size) {
		this.size=size;
		this.cells=new Cell[this.getSize()][this.getSize()];
		for(int row=0;row<this.getSize();row++) {
			for(int column=0;column<this.getSize();column++) {
				this.cells[row][column]=new Cell(row, column);
			}
		}
		this.currentMove=new Move();
	}
	
	public int getSize() {
		return size;
	}
	public Cell[][] getCells() {
		Cell[][] cells=new Cell[this.getSize()][this.getSize()];
		
		for(int row=0;row<this.getSize();row++) {
			for(int column=0;column<this.getSize();column++) {
				cells[row][column]=this.cells[row][column];
			}
		}
		return cells;
	}
	public void setCells(Cell[][] cells) {
		for(int row=0;row<getSize();row++) {
			for(int column=0;column<getSize();column++) {
				this.cells[row][column]=cells[row][column];
			}
		}
	}
	public Cell setCell(CellContent content,Move move) {
		this.cells[move.getRow()][move.getColumn()].setContent(content);
		this.currentMove=move;
		return cells[move.getRow()][move.getColumn()];		
	}
	public void clearBoard() {
		for(int row=0;row<getSize();row++) {
			for(int column=0;column<getSize();column++) {
				this.cells[row][column].clear();;
			}
		}
	}

	public Move getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(Move currentMove) {
		this.currentMove = currentMove;
	}
	public void print() {
	      for (int row = 0; row < this.getSize(); ++row) {
	         for (int col = 0; col < this.getSize(); ++col) {
	           this.getCells()[row][col].print();   
	            if (col < this.getSize() - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (row < this.getSize() - 1) {
	            System.out.println("-----------");
	         }
	      }
	}
}
