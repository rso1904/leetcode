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
    public ListNode mergeNodes(ListNode head) {
        ListNode res = null;
        int value = 0;
        ListNode cur = null;
        
        while(head != null) {
            if(head.val == 0) {
                if(value != 0) {
                    if(res == null) {
                        res = new ListNode(value);
                        cur = res;
                        value = 0;
                    } else {
                        cur.next = new ListNode(value);
                        cur = cur.next;
                        value = 0;
                    }
                }
            } else {
                value += head.val;
            }
            
            head = head.next;
        }
        
        return res;
    }
}