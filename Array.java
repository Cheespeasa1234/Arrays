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
 * @version 1.1 - Sep 24 2022
 *
 * @param <T> Type of objects that are held
 * 
 * Changes
 * 1.1
 * - Added subArray(int startIndex);
 * - Added subArray(int startIndex, int endIndex);
 * - Added selectionSort()
 * - Added bubbleSort()
 * - Added reverse()
 * - Increased usage of non-static methods on this object (consistency)
 */
@SuppressWarnings("unchecked")
public class Array<T> implements Comparable<T> {
	
	/**
	 * The array holding current inventory of items
	 * @since 1.0
	 */
	private T[] array;
	
	/**
	 * Make a new {@code Array} object, that is fully blank.
	 * @since 1.0
	 */
	public Array() {
		this.array = (T[]) new Object[0];
	}
	
	/**
	 * Make a new {@code Array} object, containing {@code arr} as elements.
	 * @param arr The array to start with. Must be an array of classes that extend Object.
	 * @since 1.0
	 */
	public Array(T[] arr) {
		this.array = arr;
	}
	
	/**
	 * Returns number representing the comparison of object lengths.
	 * If the size of a is more than this size, returns 1
	 * If the size of a is less than this size, returns -1
	 * If they are equal, returns 0
	 * Requires class equals method to be overridden.
	 * 
	 * @param a {@code Array} object to compare
	 * @return number representing the comparison of object lengths
	 * @since 1.0
	 */
	@Override public int compareTo(Object o) {
		
		if(!(o instanceof Array)) {
			return -1;
		}
			
		Array<T> a = (Array<T>) o;
		
		if(this.equals(o))
			return 0;
		else if(a.size() < size())
			return 1;
		return -1;
	}
	
	/**
	 * Requires class equals method to be overridden.
	 * 
	 * @param obj Object to compare
	 * @returns boolean of equality
	 * @since 1.0
	 */
	@Override public boolean equals(Object o) {
		if(!o.getClass().equals(this.getClass())) 
			return false;
		T[] a = ((Array<T>) o).toArray();
		return a.equals(this.array);
	}
	
	/**
	 * Returns the length of elements in the array.
	 * 
	 * @return Length of this {@code Array}
	 * @since 1.0
	 */
	public int size() {
		return this.array.length;
	}
	
	/**
	 * Returns the array this object stores.
	 * 
	 * @return The {@code T[]} this {@code Array} stores
	 * @since 1.0
	 */
	public T[] toArray() {
		return this.array;
	}
	
	/**
	 * Returns the index of the element in this {@code Array}, if equal.
	 * If nothing is found, returns -1
	 * Requires class equals method to be overridden.
	 * 
	 * @param obj Object to find
	 * @return Index of first object to be equal to {@code obj}
	 * @since 1.0
	 */
	public int indexOf(T obj) {
		for(int i = 0; i < this.array.length; i++) 
			if(this.array[i].equals(obj))
				return i;
		return -1;
	}
	
	/**
	 * Returns the amount of times that obj is found in this {@code Array}.
	 * Requires class equals method to be overridden.
	 * 
	 * @param obj Object to count
	 * @return Count of obj's occurences
	 * @since 1.0
	 */
	public int countOf(T obj) {
		int count = 0;
		for(int i = 0; i < this.size(); i++) {
			System.out.println(this.array[i]);
			if(this.array[i].equals(obj))
				count++;
		}
	
		return count;
	}
	
	/**
	 * Removes the first object in this {@code Array} to equal obj.
	 * Requires class equals method to be overridden.
	 * 
	 * @param obj Object to find and remove.
	 * @since 1.0
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
	 * Requires class equals method to be overridden.
	 * 
	 * @param obj Object to find and remove.
	 * @param count Maximum count of objects to remove.
	 * @since 1.0
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
	 * Removes all of an object in this {@code Array}.
	 * Requires class equals method to be overridden.
	 * 
	 * @param obj Object to find and remove.
	 * @since 1.0
	 */
	public void removeAll(T obj) {
		T[] aux = (T[]) new Object[this.array.length - 1];
		for (int i = 0; i < aux.length; i++) 
			if(!this.array[i].equals(obj))
				aux[i] = obj;
		
		this.array = aux;
	}
	
	/**
	 * Removes any elements of this {@code Array} that are there twice.
	 * Requires class equals method to be overridden.
	 * @since 1.0
	 */
	public void removeDuplicates() {
		
		Array<T> a = new Array<T>();
		for(int i = 0; i < this.size(); i++) {
			if(a.indexOf(array[i]) < 0) {
				a.add(array[i]);
			}
		}
		this.array = a.array;
	}
	
	/**
	 * Returns a new {@code Array} object with all elements from startIndex and beyond.
	 * Does not modify this object.
	 * 
	 * @param startIndex Index to start from
	 * @return Array
	 * @since 1.1
	 */
	public Array<T> subArray(int startIndex) {
		
		Array<T> array = new Array<T>();
		for(int i = startIndex; i < this.size(); i++)
			array.add(this.get(i));
		
		return array;
		
	}
	
	/**
	 * Returns a new {@code Array} object with all elements starting at startIndex,
	 * and not including endIndex and beyond.
	 * Does not modify this object.
	 * 
	 * @param startIndex Index to start from
	 * @param endIndex Index to stop on
	 * @return Array
	 * @since 1.1
	 */
	public Array<T> subArray(int startIndex, int endIndex) {
	
		Array<T> array = new Array<T>();
		for(int i = startIndex; i < endIndex; i++)
			array.add(this.get(i));
		
		return array;
	}
	
	/**
	 * Requires class equals method to be overridden.
	 * Requires class compareTo method.
	 * 
	 * Sorts this Array with a bubble sort algorithm.
	 * 
	 * This algorithm works by going through the array
	 * multiple times, seeing if two objects in the array,
	 * next to each other, and not in the right order.
	 * If they are not, they get swapped. The pointer then
	 * moves on and does another swap, repeating this forever
	 * until the array is sorted.
	 * 
	 * This is much faster than selectionSort, but the
	 * downside is that it has O(n^2) time complexity in the 
	 * worst case, (most unsorted) but can have O(n) time
	 * complexity in best case. (This means the time it takes
	 * to sort exponentially increases, as the length of the 
	 * array increases.)
	 * 
	 * @see {@link #selectionSort() Selection Sort} for more info on time complexity.
	 * 
	 * @since 1.1
	 */
	public void bubbleSort() {
		if(this.size() < 1 || !(array[0] instanceof Comparable))
			return;
		int n = this.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
            	Comparable<T> obj = ((Comparable<T>)array[j]);
                if (obj.compareTo(array[j + 1])==1) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
	}
	
	/**
	 * Requires class equals method to be overridden.
	 * Requires class compareTo method.
	 * 
	 * Sorts this Array with a selection sort algorithm.
	 * 
	 * This algorithm works by going through the array, and
	 * finding the current smallest item. It adds the smallest
	 * to the final array, and adds the smallest to objects to
	 * ignore in the future.
	 * 
	 * This is technically slower than selectionSort, but always
	 * has O(n) time. Meaning, the length of the array times the
	 * time to compare and add an element is the final time.
	 * 
	 * The symbol O means the amount of time per element. This
	 * includes comparing, adding, subtracting, casting, and
	 * anything else that takes time. Multiply O by n, the
	 * amount of elements you need to do this for. This means
	 * the time complexity is O(n).
	 * 
	 * @see {@link #bubbleSort() Bubble Sort}
	 * 
	 * @since 1.1
	 */
	public void selectionSort() {
		if(this.size() < 1 || !(this.array[0] instanceof Comparable))
			return;
        
		int n = this.size();
		 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (((Comparable<T>) this.array[j]) .compareTo( this.array[min_idx] ) == -1)
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            T temp = this.array[min_idx];
            this.array[min_idx] = this.array[i];
            this.array[i] = temp;
        }
	}
	
	/**
	 * Reverses the order of elements in this array.
	 * @since 1.1
	 */
	public void reverse() {
		T[] aux = (T[]) new Object[this.size()];
	
		for(int i = 0; i < this.size(); i++) {
			aux[i] = this.array[this.size()-1 - i];
		}
		
		this.array = aux;
		
	}
	
	/**
	 * Adds obj to the end of this {@code Array}. Increases the size of this {@code Array} by 1
	 * 
	 * @param obj Object to add to end of array.
	 * @since 1.0
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
	 * @since 1.0
	 */
	public T get(int i) {
		return this.array[i];	
	}
	
	/**
	 * Sets the value at i to obj. Overwrites existing object.
	 * 
	 * @param i index in this array to overwrite
	 * @param obj object to set
	 * @since 1.0
	 */
	public void set(int i, T obj) {
		this.array[i] = obj;
	}
	
	/**
	 * Returns a string representation of this {@code Array}'s contents.
	 * 
	 * @return String representation
	 * @since 1.0
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
	 * @since 1.0
	 */
	@Override public Array<T> clone() {
		this.getClass();
		return new Array<T>(this.array);
	}
	
	public static void main(String[]a) {
		
		Integer[] n = {
			1,
			3,
			7,
			1,
			0,
			234,
			12,
			86,
			111,
			999,
			53,
			3
		};
		
		Array<Integer> arr = new Array<Integer>(n);
		arr.selectionSort();
		arr.reverse();
		arr.remove(999);
		System.out.println();
		System.out.println(arr.toString());
		
	}
}
