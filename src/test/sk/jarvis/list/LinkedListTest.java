package test.sk.jarvis.list;

import com.sk.jarvis.Node;
import com.sk.jarvis.list.IList;
import com.sk.jarvis.list.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private Logger logger = Logger.getLogger("LinkedListTest");

    @Test
    public void constructorTest(){
        IList<Integer> list = new LinkedList<>();
        assertNull(list.get());
        IList<Integer> list1 = new LinkedList<>(1);
        assertEquals(1, list1.get().getData());
    }

    @Test
    public void addTest(){
        IList<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        assertFalse(integerList.isEmpty());
        assertEquals(1, integerList.get().getData());
        assertNull(integerList.get().getNext());
    }

    @Test
    public void addManyTest(){
        IList<Integer> integerList = new LinkedList<>();
        for(int i=0;i<1000; i++){
            integerList.add(i);
        }
        assertFalse(integerList.isEmpty());
        assertEquals(1000, integerList.getSize());
    }

    @Test
    public void addAtBeginningTest(){
        IList<Integer> integerIList = new LinkedList<>();
        integerIList.add(1);
        integerIList.add(2);
        integerIList.addAtBeginning(0);
        assertEquals(3,integerIList.getSize());
        assertNotNull(integerIList.get());
        assertEquals(0, integerIList.get().getData());
        integerIList.addAtBeginning(-1);
        assertEquals(-1, integerIList.get().getData());
    }

    @Test
    public void removeTest(){
        IList<Integer> integerIList = new LinkedList<>();
        addToList(integerIList);
        for(int i=0;i<3;i++){
            integerIList.remove();
        }
        Node<Integer> current = getLast(integerIList);
        assertEquals(96,current.getData());
        integerIList.add(800);
        assertEquals(800,getLast(integerIList).getData());
        assertEquals(98,integerIList.getSize());
    }

    @Test
    public void removeAtBeginningTest(){
        IList<Integer> integerIList = new LinkedList<>();
        addToList(integerIList);
        integerIList.removeAtBeginning();
        assertNotNull(integerIList.get());
        assertEquals(1, integerIList.get().getData());
        integerIList.addAtBeginning(0);
        assertEquals(0,integerIList.get().getData());
    }

    @Test
    public void getTest(){
        IList<Integer> integerIList = new LinkedList<>();
        addToList(integerIList);
        logger.info(()-> String.format("Size of List: %d",integerIList.getSize()));
        assertEquals(99,integerIList.get(99));
        assertEquals(1,integerIList.get(1));
        assertEquals(50,integerIList.get(50));
        assertNull(integerIList.get(100));
        integerIList.remove();
        assertEquals(98,integerIList.get(98));
    }

    @Test
    public void addAllTest(){
        IList<Integer> list = new LinkedList<>();
        addToList(list);
        IList<Integer> list2 = new LinkedList<>();
        addToList(list2);
        list.addAll(list2);
        logger.log(Level.INFO,String.format("Size of List: %d",list.getSize()));
        assertNotNull(list.get());
        assertEquals(199,list.getSize());
        assertNotNull(list2.get());
        assertEquals(100,list2.getSize());
    }

    @Test
    public void containsTest(){
        IList<Integer> integerIList = new LinkedList<>();
        addToList(integerIList);
        assertTrue(integerIList.contains(1));
        assertTrue(integerIList.contains(99));
        assertFalse(integerIList.contains(100));
    }

    private Node<Integer> getLast(IList<Integer> integerIList){
        Node<Integer> current = integerIList.get();
        while(current.getNext()!=null){
            current = current.getNext();
        }
        return current;
    }

    private void addToList(IList<Integer> integerIList){
        for(int i =0 ;i<100;i++){
            integerIList.add(i);
        }
    }
}
