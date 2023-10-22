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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        String numberStrL1Rev = getRevStr(l1);
        String numberStrL2Rev = getRevStr(l2);
         
        String resultStr = (new BigInteger(numberStrL1Rev)).add(new BigInteger(numberStrL2Rev)).toString();

        String[] arr = resultStr.split("");
        ListNode resultNode = new ListNode();
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
            resultNode = new ListNode(Integer.parseInt(arr[i]));
            } else {
                resultNode = new ListNode(Integer.parseInt(arr[i]), resultNode);
            }
        }

        return resultNode;

    }

    public String getRevStr(ListNode ln) {
        boolean isNext = true;

        String numberStrL = "";
        String numberStrLRev = "";

        while(isNext) {
            numberStrL += Integer.toString(ln.val);
            if(ln.next != null) {
                ln = ln.next;
            } else {
                isNext = false;
            }
        }

        String[] arr = numberStrL.split("");
        
        for(int i = arr.length-1; i >= 0 ; i--) {
            numberStrLRev += arr[i];
        }

        return numberStrLRev;
    }
}