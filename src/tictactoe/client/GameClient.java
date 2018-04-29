package tictactoe.client;

import java.util.Scanner;

import tictactoe.bean.Board;
import tictactoe.bean.Cell;
import tictactoe.bean.CellContent;
import tictactoe.bean.Move;
import tictactoe.bean.Player;
import tictactoe.game.Game;
import tictactoe.game.GameImp;
import tictactoe.game.GameStatus;

public class GameClient  {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int size=3;
		Player player=new Player();
		System.out.println("Select board size 3 or 4");
		int temp=input.nextInt();
		if(temp==3 ||temp==4) {
			size=temp;
		}
		//Game game=new GameImp(size,player);
		boolean isSinglePlayer=false;
		isSinglePlayer=Assign.assignNumberofPlayers(input);
		
		player=Assign.assignPlayer(input);
		
		
		Game game=new GameImp(size,player,isSinglePlayer);
		//game.setNumberOfPlayers(numofplayers);
		
		//Game game=new GameImp(size,player);
		printBoard(game.getBoard());
		  do {
			  boolean validInput = false;
		      do {
		    	  if(!game.isSinglePlayer()|| !game.getCurrentPlayer().isComputer()) {
			    	  if (game.getCurrentPlayer().getPlayerSign() == CellContent.CROSS) {
			    		 // System.out.println("enter your move from board key");
				         // printBoardKey(game.getBoard());
				          System.out.print("Player 'X', enter your move (row[0-"+(game.getBoard().getSize()-1)+"] column[0-"+(game.getBoard().getSize()-1)+"]): ");
			            
			         }
			         else {
			        	 //System.out.print("enter your move from board key");
				         //printBoardKey(game.getBoard());
				         System.out.print("Player 'O', enter your move (row[0-"+(game.getBoard().getSize()-1)+"] column[0-"+(game.getBoard().getSize()-1)+"]): ");
			            
			         }
			         String str=input.next();
			    	  int row = Character.getNumericValue(str.charAt(0));
			         int col = Character.getNumericValue(str.charAt(1));
			         validInput=game.gameMove(game.getCurrentPlayer(),new Move(row,col)); 
			         if(!validInput) {
			        	 System.out.println("This move at (" + (row + 1) + "," + (col + 1)
			                     + ") is not valid. Try again...");
			         }
		    	  }
		    	  else {
		    		  
		    		  System.out.println("Computers move");
		    		  validInput=game.gameMove(game.getCurrentPlayer(),new Move()); 
				         if(!validInput) {
				        	 System.out.println("This move is not valid. Try again...");
				         }
		    	  }
		       
		      } while (!validInput);
		        printBoard(game.getBoard());
		         game.gameUpdate(game.getCurrentPlayer());
		         if (game.getCurrentStatus() == GameStatus.CROSS_WON) {
		            System.out.println("'X' won! Bye!");
		         } else if (game.getCurrentStatus() == GameStatus.NOUGHT_WON) {
		            System.out.println("'O' won! Bye!");
		         } else if (game.getCurrentStatus() == GameStatus.TIE) {
		            System.out.println("It's a Tie! Bye!");
		         }
		         game.switchPlayer();
		      } while (game.getCurrentStatus() == GameStatus.PLAYING);
		   
		input.close();
	}
	
	public static void printBoardKey(Board board) {
	      for (int row = 0; row < board.getSize(); ++row) {
	         for (int col = 0; col < board.getSize(); ++col) {
		         System.out.print(row+""+col);   
	            if (col < board.getSize() - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (row < board.getSize() - 1) {
	            System.out.println("-----------");
	         }
	      }
	}
	public static void printBoard(Board board) {
	      for (int row = 0; row < board.getSize(); ++row) {
	         for (int col = 0; col < board.getSize(); ++col) {
	            printCellContent(board.getCells()[row][col]);   
	            if (col < board.getSize() - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (row < board.getSize() - 1) {
	            System.out.println("-----------");
	         }
	      }
	}
	
	
	public static void printCellContent(Cell cell) {
	      switch (cell.getContent()) {
	         case CROSS:  System.out.print(" X "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case EMPTY:  System.out.print("   "); break;
	      }
	   }

}
