package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {
	public static double getNextDouble(Scanner inputScanner)
			throws DoubleMismatchException {
		double input = 0;
		boolean correctInput = true;
		do {
			correctInput = true;
			try {
				input = inputScanner.nextDouble();
			} catch (InputMismatchException e) {
				throw new DoubleMismatchException();
			}
		} while (!correctInput);
		return input;
	}
}
