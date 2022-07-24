Reverse Linked List - recursion 

class Solution {
    public ListNode reverseList(ListNode head) {
          if (head == null || head.next == null){
                  return head;
          }   
            ListNode newHead = reverseList(head.next);
            ListNode headNext = head.next;
            headNext.next = head;
            head.next = null;
            return newHead;
 
  }
}

Reverse Linked List - Iterative 

class Solution {
    public ListNode reverseList(ListNode head) {
            
            ListNode curr = head;
            ListNode prev = null;
          while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
    }
        return prev;
  }
}