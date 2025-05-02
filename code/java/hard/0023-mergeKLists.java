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
        if(lists==null||lists.length==0){
            return null;
        }
        return mergeLists(lists,0,lists.length-1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }
        int mid=start+(end-start)/2;
        ListNode left=mergeLists(lists, start, mid);
        ListNode right=mergeLists(lists, mid+1, end);

        return merge2Lists(left,right);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode temp=new ListNode(0);
        ListNode tail=temp;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1!=null){
            tail.next=l1;
        }else{
            tail.next=l2;
        }

        return temp.next;
    }
}