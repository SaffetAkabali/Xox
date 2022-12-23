import java.util.Scanner;
public class xox {

	public static void main(String[] args) {
        char[][] GameBoard = new char[3][3];
		
		GameBoard[0][0] = ' ';
		GameBoard[0][1] = ' ';
		GameBoard[0][2] = ' ';
		GameBoard[1][0] = ' ';
		GameBoard[1][1] = ' ';
		GameBoard[1][2] = ' ';
		GameBoard[2][0] = ' ';
		GameBoard[2][1] = ' ';
		GameBoard[2][2] = ' ';
		
		
		
		while (true) {
			O1Turn(GameBoard);
			if (OyunBittimi(GameBoard)) {
				break;
			}
			Ekran(GameBoard);
			
			O2Turn(GameBoard);
			if (OyunBittimi(GameBoard)) {
				break;
			}
			Ekran(GameBoard);
		}
		
	}
	
	public static void Ekran(char[][] GameBoard)
	{
		System.out.println(" ");
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 2; j++)
			{		
				System.out.print(GameBoard[i][j] + "|");
			}
			System.out.print(GameBoard[i][2]);
			System.out.println();
			System.out.println("-----");
		}
		for (int j = 0; j < 2; j++)
		{		
			System.out.print(GameBoard[2][j] + "|");
		}
		System.out.print(GameBoard[2][2]);
		System.out.println();
	}
	
    private static boolean OyunBittimi(char[][] GameBoard) {
		
		if (Saglama(GameBoard, 'X')) {	
			Ekran(GameBoard);
			System.out.println("1.Oyuncu Kazandı !");
			return true;
		}
		
		if (Saglama(GameBoard, 'O')) {	
			Ekran(GameBoard);
			System.out.println("2.Oyuncu Kazandı !");
			return true;
		}
		
		for (int i = 0; i < GameBoard.length; i++) {
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == ' ') {
					return false;
				}
			}
		}
		Ekran(GameBoard);
		System.out.println("Oyun bitti berabere !!! ");
		return true;
	}

    private static boolean Saglama(char[][] board, char symbol) {
	    if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
		    (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
		    (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
		
		    (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
		    (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
		    (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
		
		    (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
		    (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
		    return true;
	    }
	    return false;
    }

    public static void O1Turn(char[][] GameBoard) {
    	boolean karar1 = true;
    	Scanner scan = new Scanner(System.in);
    	Ekran(GameBoard);
		System.out.println("1.Oyuncu hangi sıra ve sütunu seçiyorsunuz ? Sırasıyla belirtiniz.(0-2)");
		while (karar1 = true) {
			int O1sira = scan.nextInt();
			int O1sutun = scan.nextInt();
			if (-1 < O1sira && O1sira < 3 && -1 < O1sutun && O1sutun < 3 ) 
			{
				GameBoard[O1sira][O1sutun] = 'X';
				
				if (OyunBittimi(GameBoard)) {
					break;
				}
				break;
			}
			else 
			{
				System.out.println("Lütfen dahil olmak üzere 0 ile 2 arasında sayı giriniz.");
				karar1 = false;
		    }
		}

	}
    
    public static void O2Turn(char[][] GameBoard) {
    	boolean karar2 = true;
    	Scanner scan = new Scanner(System.in);
    	System.out.println("2.Oyuncu hangi sira ve sütunu seçiyorsunuz ? Sirasiyla belirtiniz.(0-2)");
		while (karar2 = true) {
			int O2sira = scan.nextInt();
			int O2sutun = scan.nextInt();
			if (-1 < O2sira && O2sira < 3 && -1 < O2sutun && O2sutun < 3 ) 
			{
				GameBoard[O2sira][O2sutun] = 'O';
				
				if (OyunBittimi(GameBoard)) {
					break;
				}
				break;
			}
			else 
			{
				System.out.println("Lütfen dahil olmak üzere 0 ile 2 arasında sayı giriniz.");
				karar2 = false;
			}
						
		}
    }	

}
