package tictactoe.bean;

public class Move {
	private int row;
	private int column;
	public Move() {
		this.row=0;
		this.column=0;
	}
	public Move(int row,int column){
		this.row=row;
		this.column=column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

}
