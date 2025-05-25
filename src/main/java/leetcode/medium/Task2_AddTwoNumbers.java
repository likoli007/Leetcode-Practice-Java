package leetcode.medium;

// https://leetcode.com/problems/add-two-numbers/description/

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val+ l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        ListNode current = head;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null){
            int value = l1.val + l2.val + carry;
            carry = value / 10;
            ListNode node = new ListNode(value % 10);
            current.next = node;
            current = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int value = l1.val + carry;
            carry = value / 10;
            ListNode node = new ListNode(value % 10);
            current.next = node;
            current = node;

            l1 = l1.next;
        }

        while (l2 != null){
            int value = l2.val + carry;
            carry = value / 10;
            ListNode node = new ListNode(value % 10);
            current.next = node;
            current = node;

            l2 = l2.next;
        }

        if (carry != 0){
            ListNode node = new ListNode(carry);
            current.next = node;

        }


        return head;
    }
}

public class Task2_AddTwoNumbers {
    // helper function for printing
    static int getNumber(int pow, ListNode node){
        if (node.next != null)
            return pow * node.val + getNumber(pow * 10, node.next);
        return pow * node.val;
    }

    // helper for building the list
    static ListNode create(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = node;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode num1 = create(new int[] {2,4,3});
        ListNode num2 = create(new int[] {5,6,4});

        ListNode test = create(new int[] {7,0,7});

        Solution solution = new Solution();

        System.out.println(getNumber(1, test));

        System.out.println(getNumber(1, solution.addTwoNumbers(num1, num2)));


    }

}
