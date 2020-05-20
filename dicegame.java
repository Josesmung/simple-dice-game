import java.util.*;
//uses java's math package 
import java.lang.Math;
//uses java's random package for random numbers
import java.util.Random; 
public class dicegame {
   static int nPlayers = 2;
   static int nGames = 1000;
   static int[] wins = new int[nPlayers];
   static int[] pScores = new int[nPlayers];
   public static void main(String args[]) {
         
      for (int i = 0; i < nGames; i++) { //simulation loop
         
         int pIndex = 0; //keeps track of player
         while ((pScores[0] < 20) || (pScores[1] < 20)) { //main game loop
            //System.out.println(Arrays.toString(pScores));
            Random r = new Random();
            int roll = r.nextInt(6) + 1;
            
            //updates player turn
            if (pIndex == 0) { //player 1 turn (if roll is bigger than 3 then add to score, else sub from enemy player)
               pIndex++;
               if (roll > 3) {
                  pScores[0] += roll;
               } else {
                  if (pScores[1] - roll < 0) {
                     pScores[1] = 0;
                  } else {
                     pScores[1] -= roll;
                  }
               } 
            } 
            else { //player 2 turn (if roll is bigger than 5 then add to score, else sub from enemy player)
               pIndex = 0; 
               if (roll > 5) {
                  pScores[1] += roll;
               } else {
                  if (pScores[0] - roll < 0) {
                     pScores[0] = 0;
                  } else {
                     pScores[0] -= roll;
                  }
               } 
            }
         }
         //System.out.println(pIndex);
         //tracks wins
         if (pIndex == 1) {
            wins[1]++;
         } else {
            wins[0]++;
         }
         pScores = new int[2]; //resets scores
      }
      
      System.out.println(Arrays.toString(wins));
      //System.out.println(wins[0]);
      double p1 = new Double(wins[0]) / nGames;
      System.out.println("Player 1 won: " + p1);
      double p2 = new Double(wins[1]) / nGames;
      System.out.println("Player 2 won: " + p2);
   }
}