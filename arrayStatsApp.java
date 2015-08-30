// Name: Samuil Dichev
package statss;

import java.util.ArrayList;

public class arrayStatsApp {
	public static void main(String[] args) {
		arrayStats arrayManipulator = new arrayStats();

		int[] mybigarray = arrayManipulator.generateSomeHugeArray();
		int[] input = new int[] {10, 11, 9, 7, 9, 5, 12};

		arrayManipulator.getStats(mybigarray);
	}
}