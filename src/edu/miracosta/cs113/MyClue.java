package edu.miracosta.cs113;

/**
 * MyClue.java : This program asks AssistantJack and get the correct
 * answer in <= 20 tries. MyClue finds solution by incrementing the
 * wrong solution(weapon, location or murder) by 1. If the solution reaches max, it gets back to 1 and
 * repeats until the solution is correct. When all three solutions are correct,
 * the program displays the result and terminates.
 *
 *
 * @author Danny Lee
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;


public class MyClue {
    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     *
     *      weapon = random int between 1 and 6
     *      location = random int between 1 and 10
     *      murder = random int between 1 and 6
     *      solution = jack.checkAnswer(weapon, location, murder)
     *
     * WHILE solution != 0
     * 		if solution is 1, increment weapon by 1. If it is max value(6), set it back to 1.
     * 		if solution is 2, increment location by 1. If it is max value(10), set it back to 1.
     * 		if solution is 3, increment murderer by 1. If it is max value(6), set it back to 1.
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked() + ", Solution " + answer
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED!! You're a horrible Detective..."
     * ELSE
     *      OUTPUT "WOW! You might as well be called Batman!"
     * END
     */

    //Test
    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, murderer, weapon, location;
        int solution  = 100;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        weapon = random.nextInt(6) + 1;
        location = random.nextInt(10) + 1;
        murderer = random.nextInt(6) + 1;

        //System.out.println("Initial Guess");
        //System.out.println("Weapon : " + weapon + " Location : " + location + " Murderer : " + murderer);

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
        solution = jack.checkAnswer(weapon, location, murderer);

        while(solution != 0){

            System.out.println("Weapon : " + weapon + " Location : " + location + " Murderer: " + murderer);
            System.out.println("solution : " + solution);

            //When weapon is wrong
            if(solution == 1){
                if(weapon == 6){
                    weapon = 1;
                }else{
                    weapon++;
                }
                System.out.println("weapon : " + weapon);
            }

            //When location is wrong
            if(solution == 2){
                if(location == 10){
                    location = 1;
                }else{
                    location++;
                }
                System.out.println("location : " + location);
            }

            //When murderer is wrong
            if(solution ==3){
                if(murderer == 6){
                    murderer = 1;
                }else{
                    murderer++;
                }
                System.out.println("Murderer : " + murderer);
            }

            solution = jack.checkAnswer(weapon, location, murderer);
        };

        answer = new Theory(weapon, location, murderer);


        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}