# Leetcode 1071. Greatest Common Divisor of Strings

[See problem](https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75)

## Constraints

- Input:
  - Given two strings `str1` and `str2`
  - `1 <= str1.length`, `str2.length <= 1000`
  - `str1` and `str2` consist of English uppercase letters.

## Approach
<!-- Describe your approach to solving the problem. -->

We can simply concatenate these two strings and compare two strings.
If str1 +str2 is equal to str2+str1, it means a gcd exists.

Here is an fine explanation:
> It might help to visualize strings as big blocks consisting of smaller blocks of same size and color.
>
> So, if `str1` is made of 5 green blocks and `str2` is made of 3 green blocks, the total would be 8 green blocks, regardless of the order in which you combine them. The common divisor is "the size of one green block".

So, we can handle the case which has not gcd like below:

```java
if (!(str1 + str2).equals(str2 + str1)) {
    return ""; // no gcd, return empty string.
}
```

## Complexity
- Time complexity: constant time
<!-- Add your time complexity here, e.g. $O(n)$ -->

    $$
    O(n)
    $$

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $O(n)$ -->
    $$
    O(n)
    $$

## Trial and Error

