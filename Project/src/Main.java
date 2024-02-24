import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
        System.out.println("Game Started!");
        System.out.println("TIC TAC TOE");
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        printBoard(board);
        while (true) {
            playerTurn(board, s);
            if (isGameOver(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameOver(board)){
                break;
            }
            printBoard(board);
        }
    }

    public static void printBoard(char[][] board) {
        System.out.print(board[0][0]);
        System.out.print(" | ");
        System.out.print(board[0][1]);
        System.out.print(" | ");
        System.out.println(board[0][2]);
        System.out.println("----------");
        System.out.print(board[1][0]);
        System.out.print(" | ");
        System.out.print(board[1][1]);
        System.out.print(" | ");
        System.out.println(board[1][2]);
        System.out.println("----------");
        System.out.print(board[2][0]);
        System.out.print(" | ");
        System.out.print(board[2][1]);
        System.out.print(" | ");
        System.out.println(board[2][2]);
    }
    public static void makeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
        }}
        public static boolean isValidMove (char[][] board, String position) {
            switch(position) {
                case "1":
                    return (board[0][0] == ' ');
                case "2":
                    return (board[0][1] == ' ');
                case "3":
                    return (board[0][2] == ' ');
                case "4":
                    return (board[1][0] == ' ');
                case "5":
                    return (board[1][1] == ' ');
                case "6":
                    return (board[1][2] == ' ');
                case "7":
                    return (board[2][0] == ' ');
                case "8":
                    return (board[2][1] == ' ');
                case "9":
                    return (board[2][2] == ' ');
                default:
                    return false;
            }
    }
        public static void playerTurn(char[][] board, Scanner s) {
            String move;
            while (true) {
                System.out.println("Enter Your Move:");
                move = s.nextLine();
                if (isValidMove(board, move)){
                    break;
                } else {
                    System.out.println(move + " is not a valid move.");
                }
            }
            makeMove(board, move, 'X');
        }

    public static void computerTurn(char[][] board) {
    Random r = new Random();
    int computermove;
    while (true) {
        computermove = r.nextInt(9) + 1;
        if (isValidMove(board, Integer.toString(computermove))) {
            break;
        }
    }
    System.out.println("Computer Picked: " + computermove);
        makeMove(board, Integer.toString(computermove), 'O');
}



    public static boolean isGameOver(char[][] board) {

        if (Winner(board, 'X')) {
            printBoard(board);
            System.out.println("Congrats! You Win");
            return true;
        }
        if (Winner(board, 'O')) {
            printBoard(board);
            System.out.println("Sorry! Computer Wins");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        printBoard(board);
        System.out.println("Tie! Nobody Wins");
        return true;
    }


    public static boolean Winner(char[][] board, char symbol) {
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










}
