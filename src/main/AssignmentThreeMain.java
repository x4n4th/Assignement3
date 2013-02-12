package main;

import java.text.DecimalFormat;
import java.util.Scanner;

import programOne.TestScores;
import programTwo.SoundMedium;
import programTwo.SoundMediumNotFoundException;
import util.DoubleMismatchException;
import util.Utilities;

public class AssignmentThreeMain {

  /**
   * @param Program
   *          Main for Assignment 3.
   */

  public static void main(String[] args) {
    while (true) {
      try {
        programOne();
        programTwo();
        break;
      } catch (SoundMediumNotFoundException | DoubleMismatchException e) {
        System.out.println("Please Try Again");
      }
    }
  }
  
  public static void programOne() throws DoubleMismatchException{
    Scanner ks = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#0.00");
    
    System.out.println("Enter Three Test Scores");
    double testScore1 = Utilities.getNextDouble(ks);
    double testScore2 = Utilities.getNextDouble(ks);
    double testScore3 = Utilities.getNextDouble(ks);
    
    TestScores scores = new TestScores(testScore1, testScore2, testScore3);
    
    System.out.println("Average Test Score is: " +  df.format(scores.getAverage()));
    System.out.println("Letter Grade is: " + scores.getAverageGrade());
    
        
    /*for(int i = 0; i < 3; ++i){
      System.out.println("Enter score");
      scores.addScore(GetNextDouble(inputScanner));
    }*/
  }

  public static void programTwo() throws SoundMediumNotFoundException,
      DoubleMismatchException {
    DecimalFormat df = new DecimalFormat("#0.000");

    Scanner ks = new Scanner(System.in);

    System.out.println("Please enter Medium. Air, Water, Steel");
    String input = ks.nextLine();

    SoundMedium selection = SoundMedium.parseSelection(input);

    System.out.println("Enter Distance");
    final double distance = Utilities.getNextDouble(ks);

    System.out.println(selection.getName() + ": "
        + df.format(selection.getTime(distance)) + " seconds");
  }
}
