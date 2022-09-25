/**
 * This class is meant to make using arrays easier and more readable.
 * It contains methods to keep track of items that you have in this object,
 * and methods to manage the items already in the object.
 * 
 * If you are interested in me adding a method you like, just let me know at 
 * nlevison25@pascack.org
 * Or, of course, you can add it yourself!
 * Make sure to check back for new versions and features.
 * 
 * @author nlevison25
 * @version 1.0 - Sep 23 2022
 * @deprecated Sep 24, for version 1.1
 *
 * @param <T> Type of objects to hold
 */
@SuppressWarnings("unchecked") public class Array_1_0<T> {
	
	/**
	 * The array holding current inventory of items
	 */
	private T[] array;
	
	/**
	 * Make a new {@code Array} object, that is fully blank.
	 */
	public Array_1_0() {
		this.array = (T[]) new Object[0];
	}
	
	/**
	 * Make a new {@code Array} object, containing {@code arr} as elements.
	 * @param arr The array to start with. Must be an array of classes that extend Object.
	 */
	public Array_1_0(T[] arr) {
		this.array = arr;
	}
	
	/**
	 * Returns number representing the comparison of object lengths.
	 * If the size of a is more than this size, returns 1
	 * If the size of a is less than this size, returns -1
	 * If they are equal, returns 0
	 * 
	 * @param a {@code Array} object to compare
	 * @return number representing the comparison of object lengths
	 */
	public int compareTo(Array_1_0<T> a) {
		if(a.size() < size())
			return 1;
		else if(this.equals(a))
			return 0;
		return -1;
	}
	
	public boolean equals(Object o) {
		if(!o.getClass().equals(this.getClass())) 
			return false;
		T[] a = ((Array_1_0<T>) o).toArray();
		return a.equals(this.array);
	}
	
	/**
	 * Returns the length of elements in the array.
	 * 
	 * @return Length of this {@code Array}
	 */
	public int size() {
		return this.array.length;
	}
	
	/**
	 * Returns the array this object stores.
	 * 
	 * @return The {@code T[]} this {@code Array} stores
	 */
	public T[] toArray() {
		return this.array;
	}
	
	/**
	 * Returns the index of the element in this {@code Array}, if equal.
	 * If nothing is found, returns -1
	 * 
	 * @param obj Object to find
	 * @return Index of first object to be equal to {@code obj}
	 */
	public int indexOf(T obj) {
		for(int i = 0; i < this.array.length; i++) 
			if(this.array[i].equals(obj))
				return i;
		return -1;
	}
	
	/**
	 * Returns the amount of times that obj is found in this {@code Array}.
	 * 
	 * @param obj Object to count
	 * @return Count of obj's occurences
	 */
	public int countOf(T obj) {
		int count = 0;
		for(int i = 0; i < this.array.length; i++)
			if(this.array[i].equals(obj))
				count++;
		return count;
	}
	
	/**
	 * Removes the first object in this {@code Array} to equal obj.
	 * 
	 * @param obj Object to find and remove.
	 */
	public void remove(T obj) {
		T[] aux = (T[]) new Object[this.array.length - 1];
		int r = 0;
		for (int i = 0; i < aux.length; i++) {
			if(obj.equals(this.array[i]) && r < 1) {
				r++;
			} else {
				aux[i] = obj;
			}
		}
		this.array = aux;
	}
	
	/**
	 * Removes the a maximum of count objects in this {@code Array} to equal obj.
	 * 
	 * @param obj Object to find and remove.
	 * @param count Maximum count of objects to remove.
	 */
	public void remove(T obj, int count) {
		T[] aux = (T[]) new Object[this.array.length - 1];
		int r = 0;
		for (int i = 0; i < aux.length; i++) {
			if(obj.equals(this.array[i]) && r < count) {
				r++;
			} else {
				aux[i] = obj;
			}
		}
		this.array = aux;
	}
	
	/**
	 * Removes all of object in this {@code Array}.
	 * 
	 * @param obj Object to find and remove.
	 */
	public void removeAll(T obj) {
		T[] aux = (T[]) new Object[this.array.length - 1];
		for (int i = 0; i < aux.length; i++) {
			if(!obj.equals(this.array[i]))
				aux[i] = obj;
		}
		this.array = aux;
	}
	
	/**
	 * Removes any elements of this {@code Array} that are there twice.
	 */
	public void removeDuplicates() {
		
		Array_1_0<T> a = new Array_1_0<T>();
		for(int i = 0; i < array.length; i++) {
			if(a.indexOf(array[i]) < 0) {
				a.add(array[i]);
			}
		}
		this.array = a.array;
	}
	
	/**
	 * Adds obj to the end of this {@code Array}. Increases the size of this {@code Array} by 1
	 * 
	 * @param obj Object to add to end of array.
	 */
	public void add(T obj) {
		T[] aux = (T[]) new Object[this.array.length + 1];
		for(int i = 0; i < this.array.length; i++)
			aux[i] = get(i);
		aux[aux.length-1] = obj;
		array = aux;
	}
	
	/**
	 * Returns the object at index i.
	 * 
	 * @param i index in this {@code Array} to get object from
	 * @return object found
	 */
	public T get(int i) {
		return this.array[i];	
	}
	
	/**
	 * Sets the value at i to obj. Overwrites existing object.
	 * 
	 * @param i index in this array to overwrite
	 * @param obj object to set
	 */
	public void set(int i, T obj) {
		this.array[i] = obj;
	}
	
	/**
	 * Returns a string representation of this {@code Array}'s contents.
	 * 
	 * @return String representation
	 */
	public String toString() {
		if(size() < 1)
			return "[]";
		String s = "[";
		for(int i = 0; i < this.array.length-1; i++) 
			s += this.array[i] + ", ";
		s += this.array[this.array.length-1] + "]";
		return s;
	}
	
	/**
	 * Returns a new Array object with the same elements as this.
	 * 
	 * @return new {@code Array} object
	 */
	public Array_1_0<T> clone() {
		return new Array_1_0<T>(this.array);
	}
}
