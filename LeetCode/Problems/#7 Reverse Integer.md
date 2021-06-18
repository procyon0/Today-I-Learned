# 7. [Reverse Integer](https://leetcode.com/problems/reverse-integer/)

### 원문
Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.
**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

### 해석
32비트 정수`x`를 자리를 뒤집어 반환하라. 만약 뒤집어진 `x`가 32비트 정수의 범위인`[-2^31, 2^31 - 1]`를 벗어난다면 0을 반환하라.
**작업 환경이 (부호 유무 상관 없이) 64비트 정수를 저장하도록 하지 말아야 한다. **

----

### 내 코드
```java
class Solution {
    public int reverse(int x) {
        boolean isMinus = x < 0;
        long lx = Math.abs((long)x);
        Stack <Long> stack = new Stack<>();

        int oct = 1;
        while(lx != 0) {
            stack.push(lx % 10L);
            lx = lx / 10;
        }

        long reverse = 0;
        while (!stack.empty()) {
            reverse = reverse + (stack.pop() * oct);
            if(reverse > (long)Integer.MAX_VALUE) {
                return 0;
            }
            oct *= 10;
        }


        if(isMinus) {
            return -(int)reverse;
        }
        return (int)reverse;
    }
}
```
> 참고: [1534236469 > 2**31-1???](https://leetcode.com/problems/reverse-integer/discuss/154140/1534236469-231-1)

### 자료형에 주의해야한다.
