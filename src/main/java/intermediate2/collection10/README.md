10. Collection

10-1. Iterable, Iterator
```html
각 자료 구조마다 순회 방법이 다르다. 따라서 각 자료 구조의 순회 방법을 배워야 하는데 이건 너무 많아서 어렵다.
따라서 개발자 입장에서는 순서대로 접근해서 출력하거나 계산하고 싶기 때문에, 일관성있는 방법이 필요하다
자바에서 Iterable과 Iterator 인터페이스를 제공한다.
자바는 Iterable 인터페이스를 구현한 객체에 대해서 향상된 for문을 사용할 수 있게 해준다.
따라서 특정 자료구조가 Iterable과 Iterator를 구현한다면 개발자는 단순히 hasNext(), next() 또는 향상된 for문을 통해 순회 가능하다.
Map의 경우 바로 순회를 할 수는 없고 Key나 Value를 정해서 순회하면 Set, Collection을 반환하기 때문에 정해서 순회 가능하다. 물론 entrySet()도 순회 가능하다.
```
![Monosnap 10. 컬렉션 프레임워크 - 순회, 정렬, 전체 정리.pdf 2024-06-04 16-26-57.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FMonosnap%2010.%20%EC%BB%AC%EB%A0%89%EC%85%98%20%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC%20-%20%EC%88%9C%ED%9A%8C%2C%20%EC%A0%95%EB%A0%AC%2C%20%EC%A0%84%EC%B2%B4%20%EC%A0%95%EB%A6%AC.pdf%202024-06-04%2016-26-57.png)

10-2. Comparable, Comparator
```html
Arrays.sort()를 사용하면 배열에 들어있는 데이터를 순서대로 정렬할 수 있다.
다양한 정렬 알고리즘을 사용하는데, O(n log n)의 성능을 제공한다.
작을때 -1이면 오름차순 정렬
직접 구현한 Comparator를
Arrays.sort(array, new MyComparator())로 넘겨주면 된다.
직접만든 객체의 정렬은 Comparator를 구현하면 된다.
객체의 기본 정렬 방법은 객체에 Comparable을 구현해서 정의한다. 이러면 이름 그대로 비교할 수 있고 기본 정렬 방법을 가진다.
하지만 다른 정렬 방법을 사용하고 싶으면 Comparator를 별도로 구현해서 정렬 메서드에 전달하면 된다.
자바가 제공하는 기본 객체들은 대부분 Comparable을 구현해 두었다.
```
```java
//Comparable을 구현하고 compareTo()를 오버라이딩 하면 된다.  
public class MyUser implements Comparable<MyUser> {
    @Override
    public int compareTo(MyUser o) {
        return this.age < o.age ? -1 : (this.age == o.age ? 0 : 1);
    }
}
// 직접 Comparator를 만들려면 Comparator를 구현하고 compare()를 오버라이딩 한 다음에 실행할때 넘겨주면 된다.
// Arrays.sort(array, new IdComparator());
// 그러면 객체가 기본으로 가지고 있는 Comparable을 무시하고 별도로 전달한 비교자를 사용해서 정렬한다.
// 직접 만든 개체에 Comparator와 Comparable을 구현하지 않으면 에러가 발생한다.
public class IdComparator implements Comparator<MyUser> {
    @Override
    public int compare(MyUser o1, MyUser o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
```

10-3 리스트와 정렬
```java
순서가 있는 리스트와 같은 자료구조에도 정렬을 활용할 수 있다.
list.sort(new MyComparator());
Collections.sort(list)를 사용하면 기본 정렬이 적용된다. 이 방법보다는 객체 스스로의 정렬 메서드를 가지고 있는 list.sort()를 사용하자.
        list.sort(null)인 경우 별도의 비교자가 없으므로 Comparable로 비교해서 정렬한다.
```

10-4 트리 구조와 정렬
```java
이진 탐색 구조는 데이터를 정렬하면서 보관한다. 따라서 정렬 기준을 제공하는 것이 필수이다.
TreeMap과 TreeSet은 데이터를 저장할 때 왼쪽 노드에 저장할지 오른쪽 노드에 저장할지 비교가 필요하다. 
Comparable또는 Comparator가 필수이다.
new TreeSet<>(new IdComparator()) : 생성시 별도의 비교자를 제공하면 전달한 비교자를 사용해서 정렬한다.
결론 : 객체의 정렬이 필요한 경우 Comparable를 통해 기본 자연 순서를 제공하고 다른 정렬 기준이 필요하면 Comparator를 제공하자.
```

10-5 컬렉션 유틸
```java
**Collections 정렬 관련 메서드**
max: 정렬 기준으로 최대 값을 찾아서 반환한다.
min: 정렬 기준으로 최소 값을 찾아서 반환한다.
shuffle: 컬렉션을 랜덤하게 섞는다.
sort: 정렬 기준으로 컬렉션을 정렬한다.
reverse: 정렬 기준의 반대로 컬렉션을 정렬한다.
of() 메서드 : 컬렉션을 편리하게 생성 가능. 이때 불변 컬렉션이 생성된다.
불변 리스트를 가변 리스트로 전환하려면 new ArrayList<>() 를 사용하면 된다.
가변 리스트를 불변 리스트로 전환하려면 Collections.unmodifiableList() 를 사용하면 된다.
물론 다양한 unmodifiableXxx() 가 존재한다.
빈 리스트 생성시 가변일 경우에는 구현체를 직접 생성하면 되고 불변일 경우에는 List.of()를 사용하자.(Collection.emptyList(), Arrays.asList() 말고)
멀티 스레드 : Collections.synchronizedList()를 사용하면 멀티스레드 상황에서 동기화 문제가 발생하지 않는 안전한 리스트로 만들 수 있다.
```

10-6 컬렉션 인터페이스의 필요성
```java
컬렉션 인터페이스는 자바 컬렉션 프레임워크의 가장 기본적인 인터페이스로 가장 기본적인 메서드들을 정의한다.
그리고 기본 규약을 정의한다. 이는 일관성과 재사용성을 높여준다. 
일관성 : 모든 컬렉션들이 기본적인 동작을 공유한다는 것을 보장한다. 개발자가 일관된 방식으로 접근할 수 있게 해준다.
재사용성 : 다양한 컬렉션 타입들에 공통으로 적용되기 때문에 코드의 재사용성을 높이고 유지 보수를 용이하게 한다.
확장성 : 새로운 컬렉션 타입을 만들때 컬렉션 인터페이스를 구현함으로써 기존에 정의된 알고리즘과 도구를 사용할 수 있게 된다.
다형성 : 다양한 컬렉션 타입들을 같은 타입으로 다룰 수 있다. 
```

10-7 컬렉션 인터페이스
```java
Collection 인터페이스에는 다음과 같은 주요 메서드들이 포함된다.
add(E e): 컬렉션에 요소를 추가한다.
remove(Object o): 주어진 객체를 컬렉션에서 제거한다.
size(): 컬렉션에 포함된 요소의 수를 반환한다.
isEmpty(): 컬렉션이 비어 있는지 확인한다.
contains(Object o): 컬렉션이 특정 요소를 포함하고 있는지 확인한다.
iterator(): 컬렉션의 요소에 접근하기 위한 반복자를 반환한다.
clear(): 컬렉션의 모든 요소를 제거한다.
Collection은 Map을 제외한 모든 컬렉션의 부모이므로 모든 컬렉션을 받아서 유연하게 처리할 수 있다.
대표적으로 iterator를 제공하므로 데이터를 단순히 순회할 목적이라면 Collection을 사용하면 모든 컬렉션 타입의 데이터를 순회할 수 있다.
컬렉션 : 단일 루트 인터페이스, 모든 컬렉션 클래스가 이 인터페이스를 상속받는다.
리스트 : 순서가 있는 컬렉션이며 중복을 허용한다. 인덱스를 통해 접근 가능
세트 : 중복을 허용하지 않는 컬렉션이다. 인덱스를 통해 접근 불가
큐 : 요소가 처리되기 전에 보관되는 컬렉션
맵 : 키값 쌍으로 요소를 저장하는 객체이다. Map은 컬렉션 인터페이스를 상속받지 않는다.
구현 :
자바는 각 인터페이스의 여러 구현을 제공한다:
        List: `ArrayList` 는 내부적으로 배열을 사용하며, `LinkedList` 는 연결 리스트를 사용한다.
        Set: `HashSet` 은 해시 테이블을, `LinkedHashSet` 은 해시 테이블과 연결 리스트를, `TreeSet` 은 레드-블랙 트리를 사용한다.
        Map: `HashMap` 은 해시 테이블을, `LinkedHashMap` 은 해시 테이블과 연결 리스트를, `TreeMap` 은 레드-블랙 트리를 사용한다.
        Queue: `LinkedList` 는 연결 리스트를 사용한다. `ArrayDeque` 는 배열 기반의 원형 큐를 사용한다. 대부분 의 경우 `ArrayDeque` 가 빠르다.
```

10-8 선택 가이드
```java
선택 가이드
**순서가 중요하고 중복이 허용되는 경우**: `List` 인터페이스를 사용하자. `ArrayList` 가 일반적인 선택이지만, 추 가/삭제 작업이 앞쪽에서 빈번한 경우에는 `LinkedList` 가 성능상 더 좋은 선택이다.
**중복을 허용하지 않고 순서가 중요하지 않은 경우**: `HashSet` 을 사용하자. 순서를 유지해야 하면
`LinkedHashSet` 을, 정렬된 순서가 필요하면 `TreeSet` 을 사용하자
**요소를 키-값 쌍으로 저장하려는 경우**: `Map` 인터페이스를 사용하자. 순서가 중요하지 않다면 `HashMap` 을, 순서 를 유지해야 한다면 `LinkedHashMap` 을, 정렬된 순서가 필요하면 `TreeMap` 을 사용하자
**요소를 처리하기 전에 보관해야 하는 경우**: `Queue` , `Deque` 인터페이스를 사용하자. 스택, 큐 구조 모두
`ArrayDeque` 를 사용하는 것이 가장 빠르다. 만약 우선순위에 따라 요소를 처리해야 한다면 `PriorityQueue` 를 고려하자.
실무 선택 가이드
    `List` 의 경우 대부분 `ArrayList` 를 사용한다.
    `Set` 의 경우 대부분 `HashSet` 을 사용한다.
    `Map` 의 경우 대부분 `HashMap` 을 사용한다. 
    `Queue` 의 경우 대부분 `ArrayDeque` 를 사용한다.
```
