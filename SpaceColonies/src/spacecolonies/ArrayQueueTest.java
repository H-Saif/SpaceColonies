package spacecolonies;

import java.util.Arrays;
import queue.EmptyQueueException;

/**
 * test class for araryQueue
 * 
 * @author Hamza Saif (hsaif)
 * @version 04.17.2022
 *
 */
public class ArrayQueueTest extends student.TestCase {

    private ArrayQueue<String> queue = new ArrayQueue<String>(20);
    private ArrayQueue<String> queue2 = new ArrayQueue<String>(20);
    private ArrayQueue<String> queue3 = new ArrayQueue<String>(20);
    private ArrayQueue<String> nullqueue = null;

    private ArrayQueue<String> emptyQueue = new ArrayQueue<String>(0);

    /**
     * sets up before every test method
     */
    public void setUp() {
        queue.enqueue("Test1");
        queue.enqueue("Test2");

        queue2.enqueue("Test1");
        queue2.enqueue("Test2");

        queue3.enqueue("Test2");
        queue3.enqueue("Test3");

    }


    /**
     * tests the method for any bugs
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(21, queue.getLengthOfUnderlyingArray());
        for (int i = 0; i < 41; i++) {
            queue.enqueue("Test" + i);
        }

        assertEquals(81, queue.getLengthOfUnderlyingArray());

    }


    /**
     * tests the method for any bugs
     */
    public void testGetSize() {
        assertEquals(queue.getSize(), 2);
        queue.enqueue("Test4");
        queue.enqueue("tt");
        queue.dequeue();
        assertEquals(queue.getSize(), 3);

    }


    /**
     * tests the method for any bugs
     */
    public void testIsEmpty() {
        assertTrue(emptyQueue.isEmpty());
        emptyQueue.enqueue("Test1");
        emptyQueue.enqueue("Test2");
        assertFalse(emptyQueue.isEmpty());
        emptyQueue.dequeue();
        emptyQueue.dequeue();
        assertTrue(emptyQueue.isEmpty());

    }


    /**
     * tests the method for any bugs
     */
    public void testEnqueue() {

        assertEquals(2, queue.getSize());
        for (int i = 0; i < 20; i++) {
            queue.enqueue("Test" + i);
        }
        // queue.enqueue("Test6");
        assertEquals(22, queue.getSize());

    }


    /**
     * tests the method for any bugs
     */
    public void testDequeue() {
        assertEquals(queue.dequeue(), "Test1");
        assertEquals(queue.dequeue(), "Test2");
        assertEquals(0, queue.getSize());
        // assertEquals(queue.dequeue(), "Test3");
        Exception thrown = null;
        try {

            emptyQueue.dequeue();

        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);

        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * tests the method for any bugs
     */
    public void testGetFront() {

        queue.enqueue("Test3");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Test4");
        assertEquals("Test3", queue.getFront());

        Exception thrown = null;
        try {

            emptyQueue.getFront();

        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);

        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * tests the method for any bugs
     */
    public void testClear() {
        queue.clear();
        assertEquals(21, queue.getLengthOfUnderlyingArray());
        assertEquals(0, queue.getSize());
        queue.enqueue("T");
        queue.enqueue("T1");
        assertEquals("T", queue.dequeue());

    }


    /**
     * tests the method for any bugs
     */
    public void testToArray() {

        Exception thrown = null;
        try {

            emptyQueue.toArray();

        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);

        assertTrue(thrown instanceof EmptyQueueException);

        String[] toArr = new String[2];
        queue.enqueue("Test3");
        queue.dequeue();
        toArr[0] = "Test2";
        toArr[1] = "Test3";

        assertTrue(Arrays.equals(toArr, queue.toArray()));

    }


    /**
     * tests the method for any bugs
     */
    public void testToString() {

        assertEquals("[]", emptyQueue.toString());

        assertEquals("[Test1, Test2]", queue.toString());
        queue.enqueue("Test3");
        assertEquals("[Test1, Test2, Test3]", queue.toString());

    }


    /**
     * tests the method for any bugs
     */
    public void testEquals() {
        assertFalse(emptyQueue.equals(queue));
        assertTrue(queue.equals(queue));
        assertTrue(queue.equals(queue2));
        assertFalse(queue.equals(queue3));
        assertFalse(queue.equals(nullqueue));
        assertFalse(queue.equals("dd"));

    }

}
