> 이 문서는 [자바로 배우는 핵심 자료구조와 알고리즘](http://www.yes24.com/Product/Goods/61198657)을 읽고 정리한 내용입니다.
<img src="../../img/javaDataStructure.jpg" alt="표지" style="zoom:25%;" />

# 3장 ArrayList 클래스
## 3.1 MyArrayList 메서드 분류하기
```java
// MyArrayList.java 파일
// 2장 실습 정답
public E get(int index) {
    if(index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
    }
    return array[index];
}

public E set() {
    E old = get(index);
    array[index] = element;
    return old;
}

public int indexOf(Obejct obejct) {
    for(int i = 0; i < size; i++) {
        if(equals(target, array[i])) {
            return i;
        }
    }
    return -1;
}

public E remove(int index) {
    E element = get(index);
    for(int i = index; i < (size - 1); i++) {
        array[i] = array[i + 1];
    }
    size--;
    return element;
}
```
## 3.2 add 메서드 분류하기

```java
/*
*  인덱스와 요소를 파라미터로 받는 add 메서드
*/
public void add(int index, E element) {
    if(index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
    }
    // 크기 조정을 통해 요소를 추가한다.
    add(element);
    // 다른 요소를 오른쪽으로 옮긴다.
    for(int i = (size - 1); i > index; i--) {
        array[i] = array[i - 1];
    }
    // 올바른 자리에 새로운 값을 넣는다.
    array[index] = element;
}

/*
* 파라미터를 하나만 받는 add 메서드
*/
public boolean add(E element) {
    if(size >= array.length) {
        // 큰 배열을 만들어 요소들을 복사한다.
        E[] bigger = (E[]) new Obejct[array.length * 2];
        System.arraycopy(array, 0, bigger, 0, array.length);
        array = bigger;
    }
    array[size] = element;
    size++;
    return true;
}
```
## 3.3 문제 크기

```java
/*
* 파라미터와 같은 요소를 모두 삭제하는 removeAll 메서드
*/
public boolean removeAll(Collections<?> collection) {
    boolean flag = false;
    // 반복문이 실행될 때 마다 collection 파라미터의 각 요소를 한 번씩 순회하며
    // remove 메서드를 호출한다.
    for(Object obj : collection) {
        flag |= remove(obj);
    }
    return flag;
}
```

## 3.4 연결 자료구조
- **연결 리스트**로 요소를 구성하는 List 인터페이스를 일부 구현해보기
	- [연결 리스트 참고](https://en.wikipedia.org/wiki/Linked_list)
```java
public class ListNode {
    public Object data;		// 어떤 Object에 대한 참조
    public ListNode next;	// 리스트에서 다음 노드에 대한 참조, 마지막 노드의 next는 null이여야함
    
    public ListNode() {
        this.data = null;
        this.next = null;
    }
    
    public ListNode(Object data) {
        this.data = data;
        this.next = null;
    }
    
    public ListNode(Object data, ListNode next) {
        this.data = data;
        this.next = next;
    }
    
    public String toString() {
        return "ListNode("+ data.toString() +")";
    }
}
```

## 3.5 실습 3
```java
public class MyLinkedList<E> implements List<E> {
    private int size;	// 요소의 개수를 저장한다.
    private Node head;	// 첫 번째 노드에 대한 참조이다.
    
    public MyLinkedList() {
        // 생성자는 head 변수를 null로 만들어 빈 리스트임을 알려준다.
        // size 변수는 0으로 설정한다.
        head = null;
        size = 0;
    }
    
    /*
    * Node 클래스 정의하기
    */
    public class Node {
        public E data;
        public Node next;
        
        public Node(E data, Node node) {
            this.data = data;
            this.next = next;
        }
    }
    
    /*
    * 리스트에 요소를 추가하는 add 메서드
    * 1. 리스트에 첫 번째 요소를 추가하면 head 변수를 변경한다.
    * 2. while문으로 노드를 순회한다. node를 선언해야 반복이 끝난 후에 접근할 수 있다.
    */
    public boolean add(E element) {
        if(head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            // 마지막 노드까지 반복한다.
            while (node.next != null) {
                node = node.next;
            }
            size++;
            return true;
        }
    }
}
```

## 3.6 가비지 컬렉션
- 연결 리스트를 사용하면 요소를 제거하면 리스트의 크기가 줄어들고 사용하지 않는 노드는 즉시 가비지 컬렉션이 될 수 있다.
	- 배열은 리스트 자체가 파괴될 때까지 대상이 되지 않는다.
```java
/*
* 연결 리스트를 비우는 clear 메서드
* head를 null로 만들면 참조가 되지 않는 다른 노드들은 가비지 컬렉션의 대상이 된다.
*/
public void clear() {
	head = null;
    size = 0;
}
```