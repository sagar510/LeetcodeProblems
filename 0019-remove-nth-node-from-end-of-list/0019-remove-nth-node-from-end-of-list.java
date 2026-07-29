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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        int cnt = 0;
        while(p2 != null){
            if(cnt > n){
                p1 = p1.next;
            }
            p2 = p2.next;
            cnt++;
        }

        p1.next = p1.next.next;
        return dummy.next;
    }
}

/*
Input: head = [1,2,3,4,5], n = 2
                     p1p2

Input: head = [1], n = 1
               p1  p2

Input: head = [1,2], n = 1
              p1
                   p2

*/