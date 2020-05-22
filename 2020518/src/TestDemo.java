/*
 * @program: 2020518
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -18 17 :10
 */

/*class MyLinkedList {
    public Node head;
    class Node{
        int val;
        Node next;
        public Node(int val){
            next = null;
            this.val = val;
        }
        @Override
        public String toString() {
            return super.toString();
        }
    }
    *//** Get the value of the index-th node in the linked list. If the index is invalid, return -1. *//*
    public MyLinkedList(){
        this.head=null;
    }
    public int get(int index) {
        if(index<0||index>=this.size()){
            return -1;
        }
        Node cur=this.head;

        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur.val;
    }

    *//** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. *//*
    public void addAtHead(int val) {
        Node node=new Node(val);
        if(this.head==null){
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
    }


    *//** Append a node of value val to the last element of the linked list. *//*
    public void addAtTail(int val) {
        Node node=new Node(val);
        Node cur=this.head;
        if(this.head==null){
            this.head=node;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }

    *//** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. *//*
    private int size(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void addAtIndex(int index, int val) {
        Node node=new Node(val);
        Node cur=this.head;
        if(index<=0){
            addAtHead(val);
        }
        if(index==this.size()){
            addAtTail(val);
            return;
        }
        if(index>this.size()){
            return;
        }
        while(index-1>0){
            cur=cur.next;
            index--;
        }
        node.next=cur.next;
        cur.next=node;
    }

    *//** Delete the index-th node in the linked list, if the index is valid. *//*
    public void deleteAtIndex(int index) {
        Node cur=this.head;
        if(index<0||index>=this.size()){
            return;
        }
        if(index==0){
            this.head=this.head.next;
        }
        while(index-1>0){
            cur=cur.next;
            index--;
        }
        Node del=cur.next;
        cur.next=del.next;
    }
}
public class TestDemo {
    public static void main(String[] args) {

    }
}*/
