/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class intersectionOfLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode result;
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
    
    public static int getLen(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        if (fast == null) {
            return count * 2;
        } else {
            return count * 2 + 1;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        //System.out.println(getLen(headA));
        ListNode headB = new ListNode(3);
        headB.next = headA.next;
        System.out.println(getIntersectionNode(headA,headB).val);
    }
}