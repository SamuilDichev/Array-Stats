// Name: Samuil Dichev
package statss;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class arrayStats {
	public int[] generateSomeHugeArray() {

		Random generator = new Random();
		// Randomize the rangе. 0 could create some problems, so we add 1
		int range = generator.nextInt(10000) + 1;

		// Give it random size between 1 and 10000 (Inclusive). The +1 is there so we won't get a size = 0
		int[] mybigarray = new int[generator.nextInt(10000) + 1];

		for (int i = 0; i < mybigarray.length; i++) {
			mybigarray[i] = generator.nextInt(range);
		}

		return mybigarray;
	}

	public void getStats(int[] array) {
		double median = median(array);
		double mean = mean(array);
		ArrayList<Integer> mode = mode(array);
		int[] range = range(array);

		println("\nMedian: " + median);
		println("Mean: " + mean);
		println("Mode(s): " + mode);

		if (range.length == 1 || range[0] == range[1]) {
			println("Range: " + range[0]);
		} else {
			println("Range: " + range[0] + " to " + range[1]);
		}
	}

	private double median(int[] array) {
		Arrays.sort(array);
		int middle = array.length/2;

		if (array.length%2 == 0) {
			double median = (array[middle-1] + array[middle])/2;
			return median;
		}

		else {
			double median = array[middle];
			return median;
		}
	}

	private double mean(int[] array) {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}

		double average = total/array.length;
		return average;
	}

	private ArrayList<Integer> mode(int[] array) {
		int highestCount = 0;
		ArrayList<Integer> mode = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}

			if (count > highestCount) {
				mode.clear();
				highestCount = count;
				mode.add(array[i]);
			}

			else if (count == highestCount && !mode.contains(array[i])) {
				mode.add(array[i]);
			}
		}

		return mode;
	}

	private int[] range(int[] array) {
		int biggestNum = array[0];
		int smallestNum = array[0];
		int[] range = new int[2];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > biggestNum) {
				biggestNum = array[i];
			}

			else if (array[i] < smallestNum) {
				smallestNum = array[i];
			}
		}

		range[0] = smallestNum;
		range[1] = biggestNum;
		return range;
	}

	private void println(String input) {
		System.out.println(input);
	}
}