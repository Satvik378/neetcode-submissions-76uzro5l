/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0, head);
        ListNode prevLeft = dummy;

        while(true){

            //finding kth node.
            ListNode kth = kthNode(prevLeft, k);
            
            //no further groups.
            if(kth == null) break;

            ListNode nextNode = kth.next;

            //reversing the nodes
            ListNode prev = kth.next;
            ListNode current = prevLeft.next;

            while(current!=nextNode){
                ListNode temp = current.next;
                current.next = prev;
                
                prev = current;
                current = temp;
            }

            //updating the pointers.
            ListNode temp = prevLeft.next;
            prevLeft.next = prev;
            prevLeft = temp;
        }
        
        return dummy.next;
    }

    private ListNode kthNode(ListNode node, int k){
        while(node !=null && k>0){
            node = node.next;
            k--;
        }
        return node;
    }
}
