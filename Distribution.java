package assignment2;

import algs4.StdIn;
import algs4.StdOut;
import java.lang.*;
//Anh Nguyen
public class Distribution {
	public static double computeMean(double[] num) {
		double total = 0;
		for (double value: num) {
			total += value;
		}
		double mean = total/num.length;
		
		return mean;
	}
	public static double computeSD(double[]num) {
		/*OK. Let us explain it step by step.

		Say we have a bunch of numbers like 9, 2, 5, 4, 12, 7, 8, 11.
		To calculate the standard deviation of those numbers:

		1. Work out the Mean (the simple average of the numbers)
		2. Then for each number: subtract the Mean and square the result
		3. Then work out the mean of those squared differences.
		4. Take the square root of that and we are done!*/
		double mean = computeMean(num);
		double[] step2_1 = new double[num.length];
		for (int i = 0;i<num.length; i++) {
			step2_1[i]=num[i]-mean;
		}
		double[] step2_2 = new double[num.length];
		for (int i = 0;i<num.length; i++) {
			step2_2[i]=(step2_1[i])*(step2_1[i]);
		}
		double step3 = computeMean(step2_2);
		double step4 = Math.sqrt(step3);
		double sD = step4;
		return sD;
	}
	public static double Percent1SD(double[] num) {
		double sD = computeSD(num);
		double mean = computeMean(num);
		double r1 = mean - sD;
		double r2 = mean + sD;
		double percentCounter = 0;
		for (double ans: num) {
			if(ans>=r1 && ans<=r2) {
				percentCounter++;
			}
		}
		percentCounter = (percentCounter/num.length)*100;
		return percentCounter;
	}
	public static double Percent2SD(double[] num) {
		double sD = computeSD(num);
		double mean = computeMean(num);
		double r1 = mean - (2*sD);
		double r2 = mean + (2*sD);
		double percentCounter = 0;
		for (double ans: num) {
			if(ans>=r1 && ans<=r2) {
				percentCounter++;
			}
		}
		percentCounter = (percentCounter/num.length)*100;
		return percentCounter;
	}
	public static double Percent3SD(double[] num) {
		double sD = computeSD(num);
		double mean = computeMean(num);
		double r1 = mean - (3*sD);
		double r2 = mean + (3*sD);
		double percentCounter = 0;
		for (double ans: num) {
			if(ans>=r1 && ans<=r2) {
				percentCounter++;
			}
		}
		percentCounter = (percentCounter/num.length)*100;
		return percentCounter;
	}
	public static void main(String[] args) {
		// Read all of the data into an array
				StdIn.fromFile("data/normaldistribution.txt");
				double[] numbers = StdIn.readAllDoubles(); 
				double sD = computeSD(numbers);
				double mean = computeMean(numbers);
				double a1 = Percent1SD(numbers);
				double a2 = Percent2SD(numbers);
				double a3 = Percent3SD(numbers);
				// Print the SD
				StdOut.println("The Mean is " + mean);
				StdOut.println("The Standard Deviation is " + sD);
				StdOut.println("Percentage of values 1 SD away from mean: "+a1+" %.");
				StdOut.println("Percentage of values 2 SD away from mean: "+a2+" %.");
				StdOut.println("Percentage of values 3 SD away from mean: "+a3+" %.");
	}
}
