package tictactoe.bean;

public class Cell {

	private CellContent content;
	private int row,column;
	public Cell(int row,int column) {
		this.row=row;
		this.column=column;
		clear();
	}

	public CellContent getContent() {
		return content;
	}
	public void setContent(CellContent content) {
		this.content = content;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(Board board,int column) {
		if(column<board.getSize()) {
			this.column = column;
		}
	}
	public int getRow() {
		return row;
	}
	public void setRow(Board board,int row) {
		if(row<board.getSize()) {
			this.row = row;
		}
	}
	public void clear() {
		this.content=CellContent.EMPTY;
	}
	public void print() {
	      switch (this.getContent()) {
	         case CROSS:  System.out.print(" X "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case EMPTY:  System.out.print("   "); break;
	      }
	   }
	
}
