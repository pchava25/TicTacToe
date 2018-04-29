package tictactoe.client;

import java.util.Scanner;

import tictactoe.bean.CellContent;
import tictactoe.bean.Player;

public class Assign {

	public static boolean assignNumberofPlayers(Scanner input) {
		boolean isSinglePlayer=false;
		boolean isValid=true;
		do {
			int temp;
			System.out.println("Select number of players 1 or 2");
			temp=input.nextInt();

			if(temp==1) {
				isSinglePlayer=true;
			}
			else if(temp==2) {
				isSinglePlayer=false;
			}
			else {
				isValid=false;
				System.out.println("Number of players Not Valid. try again....");
			}

		}while(!isValid);
		return isSinglePlayer;
	}
	
	public static Player assignPlayer(Scanner input) {
		Player player=new Player();
		boolean isValid=true;
		do {
		System.out.println("Select Player 'X' or 'O'");
		char p=input.next().charAt(0);
		//System.out.println("p"+p);

		player=Assign.validatePlayer(p);
		//System.out.println("player "+player.getPlayerSign());
		if(player.getPlayerSign()==CellContent.EMPTY) {
			isValid=false;
			System.out.println("Player Not Valid. try again....");
		}
		else {
			isValid=true;
		}
		}while(!isValid);
		return player;
		
	}
	public static Player validatePlayer(char p) {
		Player player=new Player();
		if(p=='x'||p=='X') {
			player.setPlayerSign(CellContent.CROSS);
		}
		else if(p=='o'||p=='O') { 
			player.setPlayerSign(CellContent.NOUGHT);
		}
		else {
			player.setPlayerSign(CellContent.EMPTY);
		}
		return player;
	}
}
