package edu.learn.java.ds.list;

/**
 * Created by egnanasigamony on 7/02/2017.
 */


class ListNode {
    int val;
    ListNode next;
}

public class DeleteMidNode  {

    ListNode head;

    public void addNodeToHead(ListNode node) {
        if(head==null) {
            head=new ListNode();
            head.val=-1;
        }
        head.next=node;
        node.next=null;
    }

    public void addNodeToTail(ListNode node) {
        if(head==null) {
            head=new ListNode();
            head.val=-1;
            head.next=node;
            return;
        }
        ListNode ptr=head.next;
        while(ptr.next!=null) {
            ptr = ptr.next;
        }
        ptr.next=node;
        node.next=null;
    }

    public void printList() {
        ListNode ptr=head.next;
        while(ptr!=null) {
            System.out.println(ptr.val+" --> ");
            ptr = ptr.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static void main(String ...args) {
        DeleteMidNode dmd=new DeleteMidNode();
        ListNode deleteNode=null;
        for(int i=0;i<15;i++) {
            ListNode node=new ListNode();
            node.val=i;
            dmd.addNodeToTail(node);
            if(i==9) {
                deleteNode = node;
            }
        }
        dmd.printList();
        dmd.deleteNode(deleteNode);
        dmd.printList();
    }

}
