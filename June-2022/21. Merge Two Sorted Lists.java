//1st solution(bruteforce)

  class Solution {    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode (0);
    ListNode head = dummy;
    while (true){
        if (list1==null){
            dummy.next=list2;
            break;
        }
        if (list2==null){
            dummy.next=list1;
            break;
        }
        if (list1.val<=list2.val){
            dummy.next=list1;
            list1=list1.next;
        }
        else {
            dummy.next=list2;
            list2=list2.next;
        }
        dummy=dummy.next;
    }
    return head.next;
    }
}

//___________________________________________________________________________________


//2nd solution (optimal) 

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      
      if (list1 == null) return list2;
      if (list2 == null) return list1;

      if(list1.val > list2.val){
        
        ListNode temp = list1;
        list1 = list2;
        list2 = temp;
      }
      
      ListNode res = list1;
      while (list1 != null && list2 != null){
        ListNode tmp = null;
        while (list1 != null && list1.val <= list2.val){
       tmp = list1; //small 
        
        list1 = list1.next;
        
      }
      
      tmp.next = list2;
      
      ListNode temp = list1;
      list1 = list2;
      list2=temp;
      
    }
  
  return res;
      
     }
}




