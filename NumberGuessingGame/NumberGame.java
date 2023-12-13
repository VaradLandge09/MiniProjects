package Stack;

import java.util.*;

public class NumberGame
{
    
    int userGuess;
    String ch; 
    
    private int getRandom()
    {
        Random ran = new Random();
        return ran.nextInt(1, 100);
    }
    
    public void gameBegins()
    {
        Scanner sc = new Scanner(System.in);

        do
        {      
            int chances = 7;    
            float score = 0;  
            int num = getRandom();
            System.out.println("I have selected a Random number between 1 and 100. You have 7 chances. Try to guess it ;) \n");
            int flag = 0;

             while(chances > 0)
            {

                System.out.print("Entre your guess : ");
                userGuess = sc.nextInt();


                if(userGuess == num)
                {
                    chances--;
                    score = (float)chances * 10/6;
                    System.out.println("\n---------------- Conguratulations !  ---------------\n\nYou guessed it right :) ");
                    System.out.print("You took " + (7-chances) + " chances !!! \n");
                    System.out.println("Your Score is : " + score);
                    flag = 1;
                    break;
                }
                else
                {
                    if((userGuess < num) && (userGuess+10 >= num))
                    {
                        System.out.println("Your guess is LESS than answer and close :') ");
                    }
                    else if((userGuess > num) && (userGuess-10 <= num))
                    {
                        System.out.println("Your guess is HIGHER than answer and close :')");
                    }
                    else if((userGuess < num) && (userGuess+30 >= num))
                    {
                        System.out.println("Your guess is LESS than answer and away 8)");
                    }
                    else if((userGuess > num) && (userGuess-30 <= num))
                    {
                        System.out.println("Your guess is HIGHER than answer and away 8)");
                    }
                    else if(userGuess < num)
                    {
                        System.out.println("Your guess is LESS than answer and far away :( ");
                    }
                    else if(userGuess > num)
                    {
                        System.out.println("Your guess is HIGHER than answer and far away :( ");
                    }

                }

                chances--;
                System.out.println("Remainning chances are : " + chances);
                System.out.println("\n");
            }

            if(flag == 0)
            {
                System.out.println("You are out of chances :( \nBetter luck next time !");
                System.out.println("The answer was " + num);
            }

            System.out.println("\n-----------------------------------------------------");
        
            System.out.print("\nDo you want to play again ! ( yes / no ) : ");
            ch = sc.next();
            System.out.println("\n-----------------------------------------------------\n");

        }while(ch.equals("yes"));        

        sc.close();
    }

    public static void main(String[] args)    
    {
        
        NumberGame ng = new NumberGame();

        System.out.println("\n ******************* Number Game ******************* \n");

        ng.gameBegins();

        System.out.println("\n *************** Thanks For Playing *************** \n");
    }
}