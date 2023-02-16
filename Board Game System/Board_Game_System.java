import java.util.Scanner;

// main class
public class Board_Game_System {
    public static void main(String[] args)
    {
        Player p1 = new Player("Ahmed Ashraf", 'O') ;
        System.out.println(p1.get_name()) ;
        System.out.println(p1.get_symbol()) ;

    }
}




class Player
{
    // attributes
    private String name ;
    private char symbol ;
    protected int row ;
    protected int col ;

    // default constructor
    public Player(String nm ,char smbl)
    {
        name = nm ; 
        symbol = smbl ; 
    }

    // get a move on the board form player
    public void get_move(int x , int y)
    {
        row = x ;
        col = y ;
    }

    // getting player name
    public String get_name(){
        return name ;
    }

    // getting player symbol
    public char get_symbol()
    {
        return symbol ;
    }
}
