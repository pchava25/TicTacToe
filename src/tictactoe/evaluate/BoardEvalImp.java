package tictactoe.evaluate;

import tictactoe.bean.Board;
import tictactoe.bean.CellContent;
import tictactoe.bean.Player;

public class BoardEvalImp implements BoardEval {
	private Board board;
	public BoardEvalImp() {
		this(3);
	}
	public BoardEvalImp(int size) {
		this(new Board(size));
	}
	public BoardEvalImp(Board board) {
		this.board=board;
	}

	@Override
	public boolean gameTie() {
		for(int row=0;row<this.board.getSize();row++) {
			for(int column=0;column<this.board.getSize();column++) {
				if(this.board.getCells()[row][column].getContent()==CellContent.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean gameWon(Player player) {
		boolean checkRow=false,checkColumn=false,checkDiagonal=false,checkOppositeDiagonal=false;
		if(this.checkRow(this.board.getCurrentMove().getRow()))
		{
			checkRow=this.board.getCells()[this.board.getCurrentMove().getRow()][0].getContent()==player.getPlayerSign();
		}
		if(this.checkColumn(this.board.getCurrentMove().getColumn())) {
			checkColumn=this.board.getCells()[0][this.board.getCurrentMove().getColumn()].getContent()==player.getPlayerSign();
		}
		if(this.checkDiagonal(this.board.getCurrentMove().getRow(),this.board.getCurrentMove().getColumn())) {
			checkDiagonal=this.board.getCells()[this.board.getCurrentMove().getRow()][this.board.getCurrentMove().getColumn()].getContent()==player.getPlayerSign();
		}
		if(this.checkOppositeDiagonal(this.board.getCurrentMove().getRow(),this.board.getCurrentMove().getColumn())) {
			checkOppositeDiagonal=this.board.getCells()[this.board.getCurrentMove().getRow()][this.board.getCurrentMove().getColumn()].getContent()==player.getPlayerSign();
		}
		return checkRow || checkColumn || checkDiagonal || checkOppositeDiagonal;
	}

	public boolean checkRow(int currentRow) {
		boolean check = false;
		for(int column=0;column<this.board.getSize()-1;column++) {
			if(column==0) {
				check=(this.board.getCells()[currentRow][column].getContent() == this.board.getCells()[currentRow][column+1].getContent());
			}
			else {
				check=check && (this.board.getCells()[currentRow][column].getContent() == this.board.getCells()[currentRow][column+1].getContent());
			}
		}
		return check;
	}
	public boolean checkColumn(int currentColumn) {
		boolean check = false;
		for(int row=0;row<this.board.getSize()-1;row++) {
			if(row==0) {
				check=(this.board.getCells()[row][currentColumn].getContent() == this.board.getCells()[row+1][currentColumn].getContent());
			}
			else {
				check=check && (this.board.getCells()[row][currentColumn].getContent() == this.board.getCells()[row+1][currentColumn].getContent());
			}
		}
		return check;
	}
	public boolean checkDiagonal(int currentRow,int currentColumn) {
		
		boolean check = currentRow==currentColumn;
		for(int size=0;size<this.board.getSize()-1;size++) {
					check=check && (this.board.getCells()[size][size].getContent()== this.board.getCells()[size+1][size+1].getContent());
				}
		return check;
	}
	public boolean checkOppositeDiagonal(int currentRow,int currentColumn) {
		boolean check = currentRow+currentColumn==(this.board.getSize()-1);
		for(int row=0;row<this.board.getSize();row++) {
			for(int column=0;column<this.board.getSize();column++) {
				if(row+column==(this.board.getSize()-1)) {
					check=check && (this.board.getCells()[row][column].getContent() == board.getCells()[currentRow][currentColumn].getContent());
				}
			}
		}
		return check;
	}
	
	public int minMaxeval(Player player) {
		boolean check=false;
		/*
		 * evaluating rows
		 */
		for(int row=0;row<this.board.getSize();row++) {
			check=this.checkRow(row);
			if(check && player.isComputer()) {
				if (this.board.getCells()[row][0].getContent() == player.getPlayerSign()){
					return +10;
				}
				else if (this.board.getCells()[row][0].getContent() == player.getOpponentPlayer().getPlayerSign()) {
					return -10;
				}
			}
		}
		/*
		 * evaluating columns
		 */
		for(int column=0;column<this.board.getSize();column++) {
			check=this.checkColumn(column);
			if(check && player.isComputer()) {
				if (this.board.getCells()[0][column].getContent() == player.getPlayerSign()){
					return +10;
				}
				else if (this.board.getCells()[0][column].getContent() == player.getOpponentPlayer().getPlayerSign()) {
					return -10;	
				}
			}
		}
		/*
		 * evaluating diagonal
		 */
		check=this.checkDiagonal(0, 0);
		if(check && player.isComputer()) {
			if (this.board.getCells()[0][0].getContent() == player.getPlayerSign()){
				return +10;
			}
			else if (this.board.getCells()[0][0].getContent() == player.getOpponentPlayer().getPlayerSign()) {
				return -10;
			}
		}
		/*
		 * evaluating opposite diagonal
		 */
		check=this.checkOppositeDiagonal(0, this.board.getSize()-1);
		if(check && player.isComputer()) {
			if (this.board.getCells()[0][this.board.getSize()-1].getContent() == player.getPlayerSign()){
				return +10;
			}
			else if (this.board.getCells()[0][this.board.getSize()-1].getContent() == player.getOpponentPlayer().getPlayerSign()) {
				return -10;							
			}
		}
		return 0;
	}
}
