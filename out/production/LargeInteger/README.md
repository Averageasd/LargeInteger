# About
Implementation of BigInteger add, multiply and subtract operations using Doubly Linked Lists. This application was built
to handle the arithmetic overflow that occur when we perform calculation on big numbers. 

# Motivation
The creator of this tool wanted to know how linked lists can be used to build a useful application. Furthermore, this tool ability
to handle calculations of big numbers has been proven to be useful for the developer of the app. 

# How it works?
We create linked lists of bytes. Each node in a linked list s a digit in range[0,9]. We start from the end of 2 linked lists and
traverse the nodes. For every 2 nodes, we perform calculations on them and store the result in a new node of the result linked list.
We keep traversing until we have visited all nodes of 2 linked lists. if a linked list has run out of digits, we only need to perform
calculations on the nodes of the other linked list.
### add and subtract algorithms:
the add and subtract are very similar to each other. When doing these operations, we have to take into account the signs of the 
numbers. For example, (-1) - (-2) is -1 + 2. This is actually very simple. <b>We only add 2 numbers together or subtract
1 number from another !. </b>. Let's take (-1) - (-2) as an example. In our application, we first determine the sign of second number. it is a negative number
and there is a - sign before it, so we turn it into a positive number. Now we find the max of these numbers using their abs values.
abs(-2) is greater than abs(-1) so -2 is our "larger number" in this case. Then we only need to subtract 1 from 2. Our bigger number, as mentioned,
is -2 and its sign is - so our result ends up as a negative number. Let's do another example. Let's say we have (-1) + (-2). Similar to how we
calculate the sign of the second number. it is a negative number and the plus sign is positioned before it, so it is still ... a negative number.
The maximum of these 2 numbers is (-2). Since (-1) and (-2) have the same sign, we add them together then set the sign of the result to the sign of any of these two
numbers. We get (-3) as a result

### multiply algorithm:
It is a bit different from add and subtract algorithms. Let's say we have 12 * 12.
<br>
we start from the last digit of 2nd number, 12. We then multiply this digit with every single digit of the first number.
we store the new digits in a new linked list called cur. This linked list is : 2->4. after we are done, we update pointer to point to the first digit in second
number. Similarly, we also multiply this digit with every single digit from the first number. we end up with 1->2. Now we update prev
to point to cur and cur to point to this new linked list 1->2. The new linked list is the 2nd result linked list we create, so it has 1 
additional digit with value 0 at the end. If it is the 3rd result linked list, it will have 2 additional digits of value 0 at the end,...
adding cur (1->2->0) and prev (2->4) together using the add algorithm, we have 1->4->4.

# Screenshot:
![]()
