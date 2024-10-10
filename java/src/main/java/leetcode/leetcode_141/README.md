# Leetcode 141. Listed Cycle Node

[See problem](https://leetcode.com/problems/linked-list-cycle/)

## Constraints

- Input:
    - `ListNode` head`
    - The number of the nodes in the list is in the range `[0, 104]`.
    - 105 <= `Node.val` <= 105
    - pos is -1 or a valid index in the linked-list.
- Time limit: X

## Approach
<!-- Describe your approach to solving the problem. -->

First, we can simply solve this problem by iterating given linked list.
I utilized Set in order to store the visited nodes.

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode>  visited = new HashSet<>();
	
        ListNode currentNode = head;
        while (currentNode != null) {
			if (visited.contains(currentNode)) { // there is a cycle in the linked list
                return true;
			}
			visited.add(currentNode);
			currentNode = currentNode.next;
        }

        return false;
    }
}
```

> The runtime of the solution above was 4ms. We can optimize the solution by using "Two Pointers".

If we utilize two pointers to solve this problem, we can reduce runtime but also memory usage.

If you are more curious about this algorithm, you can visit this [article](https://medium.com/swlh/floyds-cycle-detection-algorithm-32881d8eaee1).

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head; // iterate the linked list by 2 at once
    ListNode fast = head; // iterate the linked list by 1 at once

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next;
        if (fast != null) {
            fast = fast.next;
        }
        if (slow.equals(fast)) {
            return true;
        }
    }

    return false;
}
}
```
there is also another strategy for using two pointer: with Head Start.

With head start, we initialize the `fast` pointer to `head.next`.

```java
public boolean hasCycle(ListNode head) {
    if (head == null) {
        return false;
    }

    ListNode slow = head; // iterate the linked list by 2 at once
    ListNode fast = head.next; // iterate the linked list by 1 at once
    
    while(fast != null) {
        if (slow.equals(fast)) {
            return true;
        }
        slow = slow.next;
        fast = fast.next;
        if (fast != null) {
            fast = fast.next;
        }
    }

    return false;
}
```

In this case, we have to check if the head pointer is not null because int the line 7 we have to refer a property of head (`head.next`).
Otherwise, we must meet a `NullPointerException`.

## Complexity
- Time complexity: $O(n)$
<!-- Add your time complexity here, e.g. $O(n)$ -->

- Space complexity: with set -> $O(n)$, with two pointers -> $O(1)$
<!-- Add your space complexity here, e.g. $O(n)$ -->

## Trial and Error

With head start, I missed checking whether the head is null or not at the first trial.

