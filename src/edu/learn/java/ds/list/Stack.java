package edu.learn.java.ds.list;

import edu.learn.java.ds.common.Node;

/**
 * Created by egnanasigamony on 9/09/2016.
 */
public class Stack {

    Node head;
    Node tail;

    public Stack() {
        head=null;
        tail=null;
    }

    public void printQueue() {
        Node ptr=head.right;
        while(ptr!=null) {
            System.out.println(ptr.value);
            ptr=ptr.right;
        }
        System.out.println();
    }

    public void add(Node node) {
        if(head==null) {
            head=new Node(-1);
            tail = new Node(-1);
            head.right=node;
            tail.left=node;
        }
        else {
            node.right=head.right;
            head.right=node;
        }
    }

    public void remove() {
        if(head.right==null) {
            System.out.println("Queue is empty");
        }
        else {
            Node delNode=head.right;
            head.right=delNode.right;
            if(tail.left==delNode) {
                tail.left=null;
            }
            delNode=null;
        }
    }

    public static void main(String ...args) {
        Stack q=new Stack();

        for(int i=0;i<10;i++) {
            Node n = new Node(i*3);
            q.add(n);
        }

        q.printQueue();
        q.remove();
        q.remove();
        q.printQueue();


    }
}
