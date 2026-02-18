package test.sk.jarvis.stack;

import com.sk.jarvis.stack.IStack;
import com.sk.jarvis.stack.LinkedListStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    private Logger logger = Logger.getLogger("LinkedListStackTest");
    private IStack<Integer> stack = new LinkedListStack<>();
    @BeforeEach
    public void getStack(){
        pushData(stack);
    }

    @AfterEach
    public void cleanUp(){
        stack = new LinkedListStack<>();
    }

    @Test
    void pushTest() {
        assertEquals(99,stack.peek());
        logger.log(Level.FINE,"Size:"+stack.size());
        assertEquals(100,stack.size());
    }

    @Test
    void pop() {
       assertNotNull(stack.pop());
       assertEquals(98,stack.peek());
    }

    @Test
    void peek() {
        assertEquals(99,stack.peek());
    }

    @Test
    void size() {
        assertEquals(100,stack.size());
        stack.pop();
        stack.push(101);
        stack.push(102);
        assertEquals(101,stack.size());
    }

    @Test
    void contains() {
        assertTrue(stack.contains(99));
        assertFalse(stack.contains(101));
    }

    @Test
    void addAll() {
        IStack<Integer> integerIStack = new LinkedListStack<>();
        integerIStack.push(100);
        integerIStack.push(101);
        stack.addAll(integerIStack);
        //logger.log(Level.INFO,"Top:{}"+stack.peek());
        assertEquals(100, stack.peek());
    }

    @Test
    void isEmpty() {
        IStack<Integer> integerIStack = new LinkedListStack<>();
        assertTrue(integerIStack.isEmpty());
        integerIStack.push(1);
        assertFalse(integerIStack.isEmpty());
    }

    @Test
    public void testForEach(){
        stack.forEach(System.out::println);
    }

    private  void pushData(IStack<Integer> stack){
        for(int i=0;i<100;i++){
            stack.push(i);
        }
    }
}