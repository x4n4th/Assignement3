package programOne;

import java.util.ArrayList;

public class TestScores {

  private ArrayList<Double> scoreList = new ArrayList<Double>();

  public TestScores() {

  }

  public TestScores(double... args) {
    for (double score : args) {
      scoreList.add(score);
    }
  }

  public void addScore(double score) {
    scoreList.add(score);
  }

  public double getAverage() {
    double average = 0;
    for (double score : scoreList) {
      average += score;
    }
    average = average / scoreList.size();
    return (average);
  }

  public String getAverageGrade() {
    int average = (int) (getAverage() / 10);

    switch (average) {
    case 10:
      return "A";
    case 9:
      return "A";
    case 8:
      return "B";
    case 7:
      return "C";
    case 6:
      return "D";
    default:
      return "F";
    }
  }

}
