/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月9日 下午5:07:45
* 创建作者：伍恰
* 文件名称：Ex8.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.containers;

/*
 * 节点
 */
class Link<E> {
    E e;
    Link<E> next;
    public Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }
    
    public Link(E e) {
        this(e, null);
    }
    
    public String toString() {
        if(e == null) return "null";
        return e.toString();
    }
}

class SListIterator<E> {
    Link<E> current;
    public SListIterator(Link<E> link) {
        this.current = link;
    }
    
    public Link<E> next(){
        this.current = current.next;
        return current;
    }
    
    public void insert(E e) {
        current.next = new Link<E>(e, current.next);
        current = current.next;
    }   
    
    public void remove() {
        if(current.next != null) {
            current.next = current.next.next;
        }
    }
    
    public boolean hasNext() {
        return current.next != null;
    }
}

class SList<E> {
    private Link<E> headLink = new Link<E>(null);
    SListIterator<E> iterator() { return new SListIterator<E>(headLink); }
    public String toString() { 
        if(headLink.next == null) return "SList: []";
        System.out.print("SList: [");
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder(); 
        while(it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }       
}

public class Ex8 {
    public static void main(String[] args) {
        SList<Object> sl = new SList<Object>();
        System.out.println(sl);
        SListIterator<Object> slIter = sl.iterator();
        slIter.insert(null);
        slIter.insert(new Object());
        System.out.println("inserting \"hi\"");
        slIter.insert("hi");
        System.out.println(sl);
        System.out.println("inserting \"there\"");
        slIter.insert("there");
        System.out.println(sl);
        System.out.println("inserting \"sweetie\"");
        slIter.insert("sweetie");
        System.out.println(sl);
        System.out.println("inserting \"pie\"");
        slIter.insert("pie");
        System.out.println(sl);
        SListIterator<Object> slIter2 = sl.iterator();
        System.out.println("removing \"hi\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("inserting \"hello\"");
        slIter2.insert("hello");
        System.out.println(sl);
        System.out.println("removing \"there\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"sweetie\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"pie\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"hello\"");
        SListIterator slIter3 = sl.iterator();
        slIter3.remove();
        System.out.println(sl);        
    }
}
