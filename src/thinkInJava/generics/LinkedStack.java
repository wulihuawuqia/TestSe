/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月22日 下午6:40:10
* 创建作者：伍恰
* 文件名称：LinkedStack.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class LinkedStack <T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {
            this.item = null;
            this.next = null;
        }
        Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){
            return item == null && next ==null;
        }
    }
    private Node<T> top = new Node<T>();
    public void push(T item){
        top = new Node<T>(item, top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for(String s : "Phasers on stun!".split(" ")){
            lss.push(s);
        }
        String s;
        while ((s=lss.pop()) != null){
            System.out.println(s);
        }
    }
}
