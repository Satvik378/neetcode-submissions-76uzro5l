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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length== 0) return null;

        while(lists.length >1){
            List<ListNode> mergedList = new ArrayList<>();
            
            for(int i = 0; i<lists.length; i = i+2){
                ListNode l1 = lists[i];
                ListNode l2 = (i+1) < lists.length ? lists[i+1] : null;
                mergedList.add(mergeTwoSortedLists(l1, l2));
            }

            lists = mergedList.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if(l1!=null){
            current.next = l1;
        }

        if(l2!=null){
            current.next = l2;
        }

        return dummy.next;
    }
}
