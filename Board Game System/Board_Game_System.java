import java.util.Scanner;

// main class
public class Board_Game_System {
    public static void main(String[] args)
    {
        Player p1 = new Player(1, 'X') ;
        int x , y ; 
        p1.get_move(x, y);
        System.out.println( x + " " +  y) ; 
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
