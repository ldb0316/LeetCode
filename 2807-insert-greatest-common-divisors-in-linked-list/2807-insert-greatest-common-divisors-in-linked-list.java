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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        boolean nextExist = true;
        
        ListNode resultNode = new ListNode();
        ListNode curNode = head;
        ListNode nextNode = head;
        
        List<Integer> resultList = new ArrayList<>();
        
        while(nextExist) {
            nextExist = curNode.next != null;
            
            if(nextExist) {
                nextNode = curNode.next;
                int maxDv = getMaxDv(curNode.val, nextNode.val);
                resultList.add(curNode.val);
                resultList.add(maxDv);
                curNode = nextNode;
            } else {
                resultList.add(curNode.val);
            }
        }
        
        for(int i = resultList.size()-1 ; i >=0 ; i--) {
            if(i == resultList.size()-1) {
                resultNode = new ListNode(resultList.get(i));    
            } else {
                resultNode = new ListNode(resultList.get(i), resultNode);
            }
            
        }
        
        return resultNode;
        
    }
    
    
    
    public int getMaxDv(int val1, int val2) {
        int min = val1;
        if(val1 > val2) {
            min = val2;
        }
        
        int maxDv = 1;
        for(int i=1; i<=min; i++) {
            if(val1%i==0 && val2%i==0) {
                maxDv = i;
            }
        }
        
        return maxDv;
    }
}