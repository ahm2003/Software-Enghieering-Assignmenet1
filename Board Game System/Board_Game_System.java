import java.util.Scanner;

// main class
public class Board_Game_System {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board bord = new Board(3);
        player[] players = new player[2];
        Game game = new Game();
        game.play_game();
    }
}




class Player
{
    // attributes
    protected String name ;
    protected char symbol ;
    // default constructor

    Scanner input = new Sacnner(System.in) ;

    // given a symbol to computer player
    public player(char symbol)
    {
        this.symbol =symbol ;
    }


    // a constructor to gave a player an intial ID and symbol

    public player(int ID , char symbol)
    {
        System.out.println("Welcome Player " + ID + "\nPlease Enter Your name: "  ) ;
        name = input.next() ;
        this.symbol = symbol ;
    }

    public void get_move(int x ,int y)
    {
        x = input.nextInt() ;
        y = input.nextInt() ;
    }

    // get player info
    public String get_info()
    {
        return "Player: " + name ;
    }

    // get symbol
    public char get_symbol()
    {
        return symbol; 
    }
}


import java.util.Scanner;

public class Game {
    Board board = new Board(3);
    player players[] = new player[2];
    int turn = 0, x ,y;
    public void play_game()
    {
        players[0] = new player(1 , 'x');
        players[1] = new player(2 , 'o');
        board.display_board();
        Scanner in = new Scanner(System.in);
        int x,y;

        while(true)
        {

            for (int i = 0 ; i <= 1; i++) {
                System.out.println("Enter Valid Index "+players[i].get_info());
                x=in.nextInt();
                y=in.nextInt();
                players[i].get_move(x, y);
                while (!board.updateBoard(x,y,players[i].get_symbol())){
                    players[i].get_move(x, y);
                }
                board.display_board();
                if (board.is_winner()){
                    System.out.println(players[i].get_info() + " won\n");
                    return;
                }
                if (board.is_draw()){
                    System.out.println("Draw!\n");
                    return;
                }
            }
        }
    }
}


public class Board{
    protected int BordSz ;
    protected char board [][];
    protected int n_moves = 0;
    public Board(){}
    public Board(int sz){
        BordSz = sz;
         board  = new char [BordSz][ BordSz];
    }
    public boolean updateBoard(int raw,int col,char symbol){
    if((raw >=0 && raw<=2 && col>=0||col<=2)&&(board[raw][col] == 0)){
        board[raw][col] = toUpperCase(symbol);
        n_moves++ ;
        return true;
    }
    else
        return false;
  
    } 
    public  void display_board(){
      for (int i=0;i<BordSz;++i) {
        System.out.print("\n| "); 
      for (int j=0;j<BordSz;++j) {
         System.out.print("(" +i + "," +j+ ")"); 
          System.out.print( " " + board [i][j] + " |");
    }
        System.out.print ("\n-----------------------------");
    }
        System.out.println("");
    }
    public boolean col_win(){
        for(int i= 0;i<BordSz;++i){ 
        if((board[0][i]==board[1][i] && board[1][i]==board[2][i])&&board[0][i]!= '\u0000'&&board[1][i]!= '\u0000'&&board[2][i]!= '\u0000')
        { 
            return true;   
        }
      }
      return false;
    }
    public boolean raw_win(){
             for(int i= 0;i<BordSz;++i){
           if(board[i][0]==board[i][1] && board[i][1]==board[i][2]&&board[i][0]!= '\u0000'&&board[i][1]!= '\u0000'&&board[i][2]!= '\u0000')
            return true;
               
             }
        
                return false;
    }
    public boolean dyg_win(){
        return ((board[0][0] == board[1][1])&&(board[1][1] == board[2][2])&&
               (board[0][0]!= '\u0000'&&board[1][1]!= '\u0000'&&board[2][2]!= '\u0000'))
                ||((board[0][2] == board[1][1])&&(board[1][1] == board[2][0])
                &&(board[0][2]!= '\u0000'&&board[1][1]!= '\u0000'&&board[2][0]!= '\u0000'));
    }
    public  boolean is_winner(){
        
         if(col_win()||raw_win()||dyg_win() )
             return true;
        
   return false;

   }
    public boolean is_draw(){
        return n_moves == 9 & !is_winner();
     }
    public void setBoardsize(int sz){
        BordSz = sz;
        board  = new char [BordSz][ BordSz];
    }
    public int getBoardSize(){
        return BordSz;
    }
}
