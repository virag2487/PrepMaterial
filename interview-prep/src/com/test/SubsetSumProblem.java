package com.test;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * 
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 * 
 * @author Virag Shah
 *
 */
public class SubsetSumProblem {

	/**
	 * 
	 * @param set
	 * @param n
	 * @param sum
	 * @return
	 */
	public boolean isSubsetSum(int[] set, int n, int sum) {

		// base case, if sum reaches 0, meaning subset exists
		if(sum == 0) {
			return true;
		}

		// if numbers are 0 but sum is not 0, meaning not possible
		if(n == 0 && sum != 0) {
			return false;
		}

		// if last element is greater than sum, simply exclude last element
		// this condition avoids unnecessary cases
		// code would work even without this condition
		if(set[n - 1] > sum) {
			return isSubsetSum(set, n - 1, sum);
		}

		// else, 2 cases exist as below:
		// exclude last element
		return isSubsetSum(set, n - 1, sum) || 
				// include last element
				isSubsetSum(set, n - 1, sum - set[n - 1]);
	}

	/**
	 * 
	 * @param isSubsetSum
	 */
	public void print(boolean isSubsetSum) {
		if (isSubsetSum) {
			System.out.println("Found a subset with given sum");
		}
		else {
			System.out.println("No subset with given sum");
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SubsetSumProblem subsetSum = new SubsetSumProblem();

		int set[] = {3, 34, 4, 12, 5, 2};

		// Sum is 9 = 5 + 4
		boolean isSubsetSum = subsetSum.isSubsetSum(set, 6, 9);
		subsetSum.print(isSubsetSum);

		// Sum is 6 = 4 + 2
		isSubsetSum = subsetSum.isSubsetSum(set, 6, 6);
		subsetSum.print(isSubsetSum);

		// Sum is 40 = 34 + 4 + 2
		isSubsetSum = subsetSum.isSubsetSum(set, 6, 40);
		subsetSum.print(isSubsetSum);

		// Sum is 47 = not possible
		isSubsetSum = subsetSum.isSubsetSum(set, 6, 47);
		subsetSum.print(isSubsetSum);
	}
}