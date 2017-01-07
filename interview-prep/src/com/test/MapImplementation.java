package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports following operations in Θ(1) time.
 * 
 * insert(x): Inserts an item x to the data structure if not already present.
 * remove(x): Removes an item x from the data structure if present. 
 * search(x): Searches an item x in the data structure.
 * getRandom(): Returns a random element from current set of elements
 * 
 * @author Virag Shah
 *
 */
public class MapImplementation {

	// list of values
	List<Integer> array = new ArrayList<Integer>();

	// key of map is value and value of map is position index in array
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean insert(int num) {
		if(!map.containsKey(num)) {
			array.add(num);
			map.put(num, array.size() - 1);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean remove(int num) {
		if(map.containsKey(num)) {
			int last = array.get(array.size() - 1);
			int removePos = map.get(num);
			array.set(removePos, last);
			array.remove(array.size() - 1);
			map.put(last, removePos);
			map.remove(num);
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public int search(int num) {
		return map.get(num);
	}

	/**
	 * 
	 * @return
	 */
	public int getRandom() {
		Random random = new Random();
		int index = random.nextInt(array.size());

		return array.get(index);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main (String[] args) {
		MapImplementation mapImpl = new MapImplementation();
		mapImpl.insert(10);
		mapImpl.insert(20);
		mapImpl.insert(30);
		mapImpl.insert(40);
		System.out.println(mapImpl.search(30));
		mapImpl.remove(20);
		mapImpl.insert(50);
		System.out.println(mapImpl.search(50));
		System.out.println(mapImpl.getRandom());
	}
}
