
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Circular queue class to store person objects. operates using first in first
 * out method.
 * 
 * @author Hamza Saif
 * @version 04/17/2022
 *
 * @param <T>
 * 
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    /**
     * the default capacity
     */
    public final static int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    /**
     * Constructor
     * 
     * @param initialCapacity
     *            the capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        queue = (T[])new Object[initialCapacity + 1];
        dequeueIndex = 0;
        enqueueIndex = initialCapacity;
        size = 0;

    }


    /**
     * return the length of the array, always greater than capacity by 1.
     * 
     * @return the length of the underlying array
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length; // length of array bigger than capacity by 1?
    }


    /**
     * getter method for size
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }


    /**
     * isEmpty method
     * 
     * @return true if the array is empty.
     */
    public boolean isEmpty() {
        // return (size == 0);
        return (dequeueIndex == ((enqueueIndex + 1) % queue.length));
    }


    /**
     * isFull method, if dequeueIndex + 2 % length of array is equal to
     * enequeueIndex
     * 
     * @return true if above is true
     */
    private boolean isFull() {
        return ((enqueueIndex + 2) % queue.length == dequeueIndex);
    }


    /**
     * Adds an item to the back of the queue.
     * 
     * @param newEntry
     *            element to be added
     */
    public void enqueue(T newEntry) { //

        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = newEntry;
        size++;

    }


    /**
     * ensures the array is not full, if it is, makes a new array with 2 *
     * capacity.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] temp = (T[])new Object[(size * 2) + 1];
            for (int i = 0; i < size; i++) {
                temp[i] = queue[dequeueIndex];
                dequeueIndex = (dequeueIndex + 1) % (size + 1);
            }
            queue = temp;
            enqueueIndex = size - 1;
            dequeueIndex = 0;
        }
    }


//
// getLengthOfUnderlyingArray() does not return the expected value after
// enqueueing many elements.
//
// An exception was thrown while dequeueing all elements from an expanded array.
    /**
     * removes an item from the front of the queue
     * 
     * @throws EmptyQueueException
     *             if the queue is empty
     * @return the item that was removed
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T front = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
    }


    /**
     * returns the the first element in the queue
     * 
     * @throws EmptyQueueException
     *             if the queue is empty
     * @return the element in the front of the queue
     */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * resets the array to default values.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1]; // produces compilation
        // // error
        enqueueIndex = DEFAULT_CAPACITY;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * method to incremement the indexes of the queue
     * 
     * @param index
     *            the index to be incrememeted
     * @return the incrememnted index
     */
    private int incrementIndex(int index) {
        return (index + 1) % queue.length;
    }


    /**
     * toArray method for the queue
     * 
     * @return the array
     */
    public Object[] toArray() { // store in array ?
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[this.size];
        int temp = dequeueIndex;
        for (int i = 0; i < getSize(); i++) {
            array[i] = queue[temp];
            temp = incrementIndex(temp);
        }
        return array;

    }


    /**
     * to string method for the for the queue each element is seperated by ">"
     * to indicate the next person
     * 
     * @return the string
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int temp = dequeueIndex;
        sb.append(queue[temp]);
        for (int i = 1; i < size; i++) {
            sb.append(", ");
            temp = incrementIndex(temp);
            sb.append(queue[temp]);

        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * equals method for the queue. 2 queue are equal if they have contain the
     * same elements in the same order
     * 
     * @param obj
     *            obj
     *            whats being compared to
     * 
     * @return true if equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        ArrayQueue<T> tempQueue = (ArrayQueue<T>)obj;
        if (this.size == tempQueue.size) {
            for (int i = 0; i < this.size; i++) {
                T myElement = this.queue[(this.dequeueIndex + i)
                    % this.queue.length];
                T otherElement = tempQueue.queue[(tempQueue.dequeueIndex + i)
                    % tempQueue.queue.length];
                if (!myElement.equals(otherElement)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
