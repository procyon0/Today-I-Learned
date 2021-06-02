# 3장 ArrayList 클래스

## 3.1 MyArrayList 메서드 분류하기

```java
public E get(int index) {
    if(index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
    }
    return array[index];
}
```

