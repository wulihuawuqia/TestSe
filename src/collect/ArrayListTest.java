package collect;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {
    @Test
    public void testRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String a : list) {
            if ("1".equals(a)) {
                list.remove(a);
            }
            System.out.println(list.size());
        }
    }

    @Test
    public void testRemove1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String a = it.next();
            if ("1".equals(a)) {
                it.remove();
            }
            System.out.println(list.size());
        }
        System.out.println(list.size());
    }


    @Test
    public void test(){
        Hashtable hashtable = new Hashtable();
        HashMap hashMap = new HashMap();
        System.out.println(1<<4);
        System.out.println(1>>4);
    }

}
