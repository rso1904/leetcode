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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int start = -1;
        int end = -1;
        int prevIndex = -1;
        int min = Integer.MAX_VALUE;
        int index = 1;
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null) {
            if(prev == null) {
                prev = cur;
            } else {
                if(cur.next == null) {
                    break;
                }
                
                if((prev.val > cur.val && cur.next.val > cur.val) || (prev.val < cur.val && cur.next.val < cur.val)) {
                    end = index;
                    if(start == -1) {
                        start = index;
                    }
                    
                    if(prevIndex == -1) {
                        prevIndex = index;
                    } else {
                        min = Math.min(min, index - prevIndex);
                        prevIndex = index;
                    }
                }
            }
            
            prev = cur;
            cur = cur.next;
            index++;
        }
                
        return start != -1 && end != -1 && start != end ? new int[]{min, end - start} : new int[]{-1, -1};
    }
}