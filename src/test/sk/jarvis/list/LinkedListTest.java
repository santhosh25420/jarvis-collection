package test.sk.jarvis.list;

import com.sk.jarvis.list.IList;
import com.sk.jarvis.list.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

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
}
