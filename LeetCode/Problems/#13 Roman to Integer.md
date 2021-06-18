# 13. [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
### 원문

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.
```text
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
For example, `2` is written as `II` in Roman numeral, just two one's added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9. 
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90. 
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

### 해석
로마 숫자 → 십진법 숫자로 바꾸기

> > 참고: [Roman numerals](https://en.wikipedia.org/wiki/Roman_numerals)

---

### 내가 제출한 코드
```java
class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int len = 0;
        if (s.endsWith("IV")) {      // 4
            num = num + 4;
            s = s.replaceAll("IV", "");
//            System.out.println("s(IV) = " + s);
        }
        if (s.endsWith("IX")) {     // 9
            num = num + 9;
            s = s.replaceAll("IX", "");
//            System.out.println("s(IX) = " + s);
        }
        if (s.endsWith("I")) {       // 1
            len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.endsWith("I")) {
                    num = num + 1;
//                    System.out.println("s(I) = " + s + ", " + i);
                    s = s.replaceFirst("I", "");
                }
            }
            if (s.length() == 1 && s.startsWith("I")) {
                num = num + 1;
            }
        }
        if (s.endsWith("V")) {       // 5
            len = s.length();
            for (int i = 0; i < len; i++) {
                if(s.endsWith("V")) {
                    s = s.replace("V", "");
                    num = num + 5;
//                    System.out.println("s(V) = " + s + ", " + i);
                }
            }
        }
        if (s.endsWith("X")) {       // 10
            len = s.length();
            for (int i = 0; i < len; i++) {
                if(s.endsWith("X")) {
                    num = num + 10;
//                    System.out.println("s(X) = " + s + ", " + i);
                    s = s.replaceFirst("X", "");
                }
            }
            if (s.length() == 1 && s.startsWith("X")) {
                num = num + 10;
            }
        }
        if (s.endsWith("XL")) {     // 40
            num = num + 40;
            s = s.replaceAll("XL", "");
//            System.out.println("s(XL) = " + s);
        }
        if (s.endsWith("XC")) {     // 90
            num = num + 90;
            s = s.replaceAll("XC", "");
//            System.out.println("s(XC) = " + s);
        }
        if (s.endsWith("L")) {       // 50
            s = s.replace("L", "");
            num = num + 50;
//            System.out.println("s(L) = " + s);
        }

        if (s.endsWith("C")) {       // 100
            len = s.length();
            for (int i = 0; i < len; i++) {
                if(s.endsWith("C")) {
                    num = num + 100;
//                    System.out.println("s(C) = " + s + ", " + i);
                    s = s.replaceFirst("C", "");
                }
            }
            if (s.length() == 1 && s.startsWith("C")) {
                num = num + 100;
            }
        }
        if (s.endsWith("CD")) {     // 400
            num = num + 400;
            s = s.replaceAll("CD", "");
//            System.out.println("s(CD) = " + s);
        }
        if (s.endsWith("D")) {     // 500
            num = num + 500;
            s = s.replaceAll("D", "");
//            System.out.println("s(D) = " + s);
        }
        if (s.endsWith("CM")) {     // 900
            num = num + 900;
            s = s.replaceAll("CM", "");
//            System.out.println("s(CM) = " + s);
        }
        if (s.endsWith("M")) {       // 1000
            len = s.length();
            for (int i = 0; i < len; i++) {
                if(s.startsWith("M")) {
                    num = num + 1000;
//                    System.out.println("s(M) = " + s + ", " + i);
                    s = s.replaceFirst("M", "");
                }
            }
            if (s.length() == 1 && s.startsWith("M")) {
                num = num + 1000;
            }
        }
        return num;
    }
}
```