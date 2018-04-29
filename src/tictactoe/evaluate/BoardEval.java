package tictactoe.evaluate;

import tictactoe.bean.Player;

public interface BoardEval {

	boolean gameTie();

	boolean gameWon(Player player);
	//boolean checkRows(Player player,int row) ;
	//boolean checkColumns(Player player,int column) ;
	//boolean checkDiagnol(Player player);
	//boolean checkOppositeDiagnol(Player player);
	int minMaxeval(Player player);
}