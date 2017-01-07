package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Virag
 *
 */
public class JumpingJack {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int maxStep(int n, int k) {
		if(n == 0) {
			return 0;
		}

		return maxStepHelp(n, k, 1, 0);
	}

	/**
	 * 
	 * @param n
	 * @param k
	 * @param i
	 * @param sum
	 * @return
	 */
	public int maxStepHelp(int n, int k, int i, int sum) {

		if(i > n) {
			return sum;
		}

		if(sum == k) {
			sum -= i - 1;
		}

		String key = "key-" + n + k + i + sum;

		if(map.containsKey(key)) {
			return map.get(key);
		}
		else {
			int temp = Math.max(maxStepHelp(n, k, i + 1, sum), maxStepHelp(n, k, i + 1, (sum + i)));
			map.put(key, temp);
			return temp;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JumpingJack jj = new JumpingJack();

		System.out.println(jj.maxStep(2, 2));
		System.out.println(jj.maxStep(2, 1));
		System.out.println(jj.maxStep(3, 3));
		System.out.println(jj.maxStep(200, 50));
	}
}
