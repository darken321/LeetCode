package org.example.palindrome;

import java.util.ArrayList;
import java.util.List;

/** <a href="https://leetcode.com/problems/palindrome-number/">...</a>
 * Given an integer x, return true if x is a palindrome and false otherwise.
 */
public class Palindrome {
    public static void main(String[] args) {
        int test;

        Solution solution = new Solution();
        test = 10;
        System.out.println(test + " " + solution.isPalindrome(test));
        test = -121;
        System.out.println(test + " " + solution.isPalindrome(test));
        test = 121;
        System.out.println(test + " " + solution.isPalindrome(test));
        test = 1234;
        System.out.println(test + " " + solution.isPalindrome(test));
        test = 12321;
        System.out.println(test + " " + solution.isPalindrome(test));

        Solution1 solution1 = new Solution1();
        test = 10;
        System.out.println(test + " " + solution1.isPalindrome(test));
        test = -121;
        System.out.println(test + " " + solution1.isPalindrome(test));
        test = 121;
        System.out.println(test + " " + solution1.isPalindrome(test));
        test = 1234;
        System.out.println(test + " " + solution1.isPalindrome(test));
        test = 12321;
        System.out.println(test + " " + solution1.isPalindrome(test));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int temp = x;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == temp;
    }
}

class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 9) {
            list.add(x % 10);
            x = x / 10;
        }
        list.add(x);
        System.out.println(list);
        boolean result = true;
        for (int i = 0; i < list.size() / 2; i++) {
            result = result &
                    (list.get(i) == (list.get(list.size() - 1 - i)));
        }
        return result;
    }
}