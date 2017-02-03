package edu.learn.java.ds.list;

import edu.learn.java.ds.common.Node;

/**
 * Created by egnanasigamony on 9/09/2016.
 */
public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        head=null;
        tail=null;
    }

    public void add(Node node) {
        if(head==null) {
            head=new Node(-1);
            tail = new Node(-1);
            head.right=node;
            tail.left=node;
        }
        else {
            Node lastNode=tail.left;
            node.left=lastNode;
            lastNode.right=node;
            node.right=null;
            tail.left=node;
        }
    }

    public void printList() {
        Node node=head.right;
        while(node!=null) {
            System.out.println(node.value);
            node=node.right;
        }
    }

    public static void main(String ...args) {
        LinkedList ll=new LinkedList();
        for(int i=0;i<10;i++) {
            Node node=new Node(i);
            ll.add(node);
        }
        ll.printList();
    }

}
