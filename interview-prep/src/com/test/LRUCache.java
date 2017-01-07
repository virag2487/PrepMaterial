package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * least_recently_used  -> A <-> B <-> C <-> D <-> E <- most_recently_used
 * 
 * @author Virag Shah
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {

	class Node<T, U> {
		Node<T, U> prev;
		Node<T, U> next;

		T key;
		U value;

		public Node(Node<T, U> prev, Node<T, U> next, T key, U value) {
			this.prev = prev;
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}

	private Map<K, Node<K, V>> cache;
	private Node<K, V> leastRecentlyUsed;
	private Node<K, V> mostRecentlyUsed;
	private int maxSize;
	private int currentSize;

	public LRUCache(int maxSize){
		this.maxSize = maxSize;
		this.currentSize = 0;
		leastRecentlyUsed = new Node<K, V>(null, null, null, null);
		mostRecentlyUsed = leastRecentlyUsed;
		cache = new HashMap<K, Node<K, V>>();
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		Node<K, V> tempNode = cache.get(key);

		// if no entry in cache, return null
		if(tempNode == null) {
			return null;
		}

		// if requested node is MRU, then return as it is
		if(tempNode.key == mostRecentlyUsed.key) {
			return tempNode.value;
		}

		// get next and previous node

		Node<K, V> previousNode = tempNode.prev;
		Node<K, V> nextNode = tempNode.next;

		// if leftmost, update LRU
		if(tempNode.key == leastRecentlyUsed.key) {
			nextNode.prev = null;
			leastRecentlyUsed = nextNode;
		}

		// if somewhere in the middle, update nodes before and after tempNode
		else if(tempNode.key != mostRecentlyUsed.key) {
			nextNode.prev = previousNode;
			previousNode.next = nextNode;
		}

		// move tempNode as MRU
		tempNode.prev = mostRecentlyUsed;
		mostRecentlyUsed.next = tempNode;
		mostRecentlyUsed = tempNode;
		mostRecentlyUsed.next = null;

		return tempNode.value;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {

		// If already exists, return
		if(cache.containsKey(key)) {
			return;
		}

		Node<K, V> newNode = new Node<K, V>(mostRecentlyUsed, null, key, value);
		mostRecentlyUsed.next = newNode;
		cache.put(key, newNode);
		mostRecentlyUsed = newNode;

		if(currentSize == maxSize) {
			cache.remove(leastRecentlyUsed.key);
			leastRecentlyUsed = leastRecentlyUsed.next;
			leastRecentlyUsed.prev = null;
		}

		else if(currentSize < maxSize) {
			if(currentSize == 0) {
				leastRecentlyUsed = newNode;
			}
			currentSize++;
		}
	}
}
