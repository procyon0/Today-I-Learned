# 9. [Palindrome Number](https://leetcode.com/problems/palindrome-number/)
### 원문
Given an integer `x`, return `true` if `x` is palindrome integer.

An integer is a **palindrome** when it reads the same backward as forward. For example, `121` is palindrome while `123` is not.

### 해석
> 참고: [회문 구조](https://en.dict.naver.com/#/entry/enko/ac7e8c25c6a549ac9162a1672342bdbe): 앞에서부터 읽으나 뒤에서부터 읽으나 동일한 단어나 구

---

```java
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reverse = "";
        int i = s.length() - 1;
        while (i > -1) {
            reverse = reverse.concat(String.valueOf(s.charAt(i)));
            i--;
        }
        return s.equals(reverse);
    }
}
```

