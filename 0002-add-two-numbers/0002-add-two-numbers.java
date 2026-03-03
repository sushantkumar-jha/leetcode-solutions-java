class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start with a dummy node (just a placeholder)
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;  // pointer to build the result
        int carry = 0;             // carry for sums greater than 9

        // Loop until both lists are finished
        while (l1 != null || l2 != null) {
            // Get values from each list (or 0 if the list is finished)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Add them together with carry
            int sum = val1 + val2 + carry;

            // Update carry for next step
            carry = sum / 10;

            // Create a new node with the digit (sum % 10)
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to next nodes if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry is left at the end, add it
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the real result (skip dummy node)
        return dummy.next;
    }
}