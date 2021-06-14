# 1. [Two sum](https://leetcode.com/problems/two-sum/)
### 원문
Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.
You may assume that each input would have **\*exactly\* one solution**, and you may not use the *same* element twice.
You can return the answer in any order.

### 번역
정수 배열 `nums`와 `target`이 주어지면,  `nums`의 두 수를 더해서 결과가 `target`이 되는 두 수의 인덱스를 반환하세요. 한 개의 입력 당 정답은 **반드시 단 하나**여야 하며, 같은 자리의 숫자를 두 번 사용할 수 없습니다. 반환되는 인덱스의 순서는 상관 없습니다.

### 힌트 1
실제로 억지 기법은 가능한 모든 숫자의 쌍을 검색하는 것이지만, 너무 느릴 겁니다. 다시 말하지만, 완전성을 위해 억지 기법을 시도해 보는 것이 가장 좋습니다. 이러한 억지 기법 방에서 최적화를 구현할 수 있습니다.

---
### 내 코드
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(num);
        }

        for(int i = 0; i < arrayList.size(); i++) {
            int diff = target - arrayList.get(i);
            if((arrayList.contains(diff)) && (i != arrayList.lastIndexOf(diff))) {
                result[0] = i;
                result[1] = arrayList.lastIndexOf(diff);
                return result;
            }
        }
        return result;
    }
}
```

