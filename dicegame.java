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
            if (pIndex == 0) { //player 1 turn
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
            else { //player 2 turn
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
         System.out.print(pIndex);
         pScores = new int[2]; //resets scores
      }
      
   }
}