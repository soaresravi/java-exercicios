import java.util.Random;
import java.util.Scanner;

public class Jokenpo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random botMove = new Random();
        
        int option = 1, bot, countStalemate = 0, countPlayer = 0, countBot = 0;
        boolean validOption;
        String move;
        
        while (true) {
            
            System.out.println("ROCK PAPER SCISSORS");
            System.out.println("-------------------\n");
            System.out.println("1. Play");
            System.out.println("2. Exit");

            validOption = false;

            while (!validOption) {
                System.out.print("\nEnter the option: ");
                
                while (true) {
                    try {
                        option = Integer.parseInt(sc.next());
                        break;
                    } catch (NumberFormatException error) {
                        System.out.println("Please, only numbers. Try again.\n");
                        System.out.print("Enter the option: ");
                    }
                }

                if (option == 1 || option == 2) {
                    validOption = true;
                } else {
                    System.out.println("Please, enter a valid option. Try again.");
                }
            }

            sc.nextLine();
            
            if (option == 1) {
                validOption = false;
                
                while (!validOption) {
                    System.out.print("Enter your move: ");

                    if (sc.hasNext("[a-zA-Z]+")) {
                        move = sc.next("[a-zA-Z]+");

                        if (!"rock".equalsIgnoreCase(move) && !"paper".equalsIgnoreCase(move) && !"scissors".equalsIgnoreCase(move)) {
                            System.out.println("Invalid move, try again.\n");
                        } else {
                            bot = botMove.nextInt(3) + 1;

                            System.out.println("\nYOUR MOVE: " + move.toUpperCase());
                            System.out.println("BOT: " + checkBot(bot));
                          
                            String result = checkWinner(move, bot);
                            
                            System.out.println(result + "\n\n");
                            
                            if (result.equals("Stalemate")) {
                                countStalemate++;
                            } else if (result.equals("You won, congratulations!")) {
                                countPlayer++;
                            } else {
                                countBot++;
                            }
                            
                            validOption = true;
                        }

                    } else {
                        System.out.println("Please, type only letters. Try again.");
                    }
                }
                               
            } else {
                System.out.println("\nSTALEMATES: " + countStalemate);
                System.out.println("VICTORIES: " + countPlayer);
                System.out.println("DEFEATS: " + countBot);
                System.out.print("\nGame over.");
                break;
            }
        }
        
        sc.close();
    }
    
    public static String checkWinner(String move, int bot) {
        move = move.toLowerCase();
        if ((move.equals("rock") && bot == 1) || (move.equals("paper") && bot == 2) || (move.equals("scissors") && bot == 3)) {
            return "Stalemate";
        } else if (move.equals("rock") && bot == 3 || move.equals("paper") && bot == 1 || move.equals("scissors") && bot == 2) {
            return "You won, congratulations!";
        } else {
            return "The bot won, i'm sorry :(";
        }
    }
    
    public static String checkBot(int bot) {
        if (bot == 1) {
            return "ROCK";
        } else if (bot == 2) {
            return "PAPER";
        } else {
            return "SCISSORS";
        }
    }
}
