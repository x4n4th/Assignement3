package main;

import java.text.DecimalFormat;
import java.util.Scanner;

import programTwo.SoundMedium;
import programTwo.SoundMediumNotFoundException;
import Util.DoubleMismatchException;
import Util.Utilities;

public class AssignmentThreeMain {

  /**
   * @param Program
   *          Main for Assignment 3.
   */

  public static void main(String[] args) {
    while (true) {
      try {
        programTwo();
        break;
      } catch (SoundMediumNotFoundException | DoubleMismatchException e) {
        System.out.println("Please Try Again");
      }
    }
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
