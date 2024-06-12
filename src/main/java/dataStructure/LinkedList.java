package dataStructure;

import org.w3c.dom.Node;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


    class Node {
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }

    }

    public LinkedList(String data){
          length = 1;
          Node newNode = new Node(data);
          head = newNode;
          tail = newNode;
    }

    public void getHead(){
        if(this.head == null) {
              System.out.println("List is empty");
        }else {
              System.out.println("Head: " + head.data);
        }

    }

    public void getail(){
          if(this.tail == null) {
              System.out.println("List is empty");
          } else {
              System.out.println("Tail: " + tail.data);
          }

    }

    public void getLength(){
          System.out.println("Length: " + this.length);
    }

    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }

    public void print(){
        System.out.println("#########################");
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("#########################");
    }

    public void append(String data){
        Node newNode = new Node(data);
        if(length == 0) {
           head = newNode;
           tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0) return null;
        Node pre = this.head;

        Node temp = null;

        while (pre.next != tail) {
            pre = pre.next;
        }

        temp = pre.next;
        tail = pre;
        tail.next = null;

        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
         if(length == 0) return null;
         Node temp = this.head;
         head = head.next;
         temp.next = null;
         length--;
         if(length == 0) {
             head = null;
             tail = null;
         }
         return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, String data){
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    public boolean insert(int index, String data){
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(data);
            return true;
        }
        if(index == length) {
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }




    public static void main(String[] args) {
        LinkedList list = new LinkedList("element 1");
        list.append("element 2");
        list.append("element 3");
        list.prepend("element 0");

        //list.insert(3, "element 2.5");

        list.remove(2);
        list.print();

        //System.out.println(list.get(2).data);

        //System.out.println(list.removeFirst().data);
        //System.out.println(list.removeLast().data);
        //list.print();

        //list.set(1, "element 0.5");
        //list.print();

        //list.getHead();
        //list.getail();
        //list.getLength();
        //list.makeEmpty
        //list.print();
    }
}
