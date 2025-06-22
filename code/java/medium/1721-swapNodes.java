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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int x = k, y = size - k + 1;
        if (x == y) {
            return head;
        }

        if (x > y) {
            int tempPos = x;
            x = y;
            y = tempPos;
        }

        ListNode prevX = null, currX = head;
        int i = 1;
        while (i < x && currX != null) {
            i++;
            prevX = currX;
            currX = currX.next;
        }

        ListNode prevY = null, currY = head;
        i = 1;
        while (i < y && currY != null) {
            i++;
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            return head;
        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }
}