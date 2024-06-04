9. MapStackQueue

9-1. Map
```html
Map은 키-값의 쌍을 저장하는 자료 구조이다.
키는 유일해야 한다. 키를 통해 값을 빠르게 검색할 수 있다.
값은 중복될 수 있다.
Map은 순서를 유지하지 않는다.
        Map
HashMap     TreeMap
LinkedHashMap
Map의 키는 바로 Set과 같은 구조이다. Map은 모든 것이 Key를 중심으로 동작한다.
키는 중복을 허용하지 않고 순서를 보장하지 않는다.
Value는 단순히 Key 옆에 따라 붙은 것 뿐이므로 Key 옆에 Value만 추가하면 Map이 되는 것이다.
따라서 Map과 Set은 거의 같다. 단지 옆에 Value를 가지고 있는가의 차이만 있을 뿐이다.
따라서 Set과 Map의 구현체는 거의 같다.
Map의 Key로 사용되는 객체는 hashCode(), equals()를 반드시 구현해야 한다.
실무에서는 HashMap을 많이 사용하고 순서 유지, 정렬의 필요에 따라 LinkedHashMap, TreeMap을 선택하면 된다.
```

9-2 스택
```html
후입선출. 스택에 값을 넣는 것을 push, 꺼내는 것을 pop라고 한다.
Stack클래스는 사용하지 말자
```

9-3 큐
```html
선입선출의 구조는 큐라고 한다.
값을 넣는 것을 offer라고 하고 값을 꺼내는 것을 poll이라고 한다.
        Collection
            Queue
            Deque
ArrayDeque      LinkedList
Queue의 대표적인 구현체는 ArrayDeque, LinkedList이다.
```

9-4 Deque
```html
Deque는 양쪽 끝에서 요소를 추가하거나 제거할 수 있다. 일반적인 큐와
스택의 기능을 모두 포함하고 있어서 매우 유연한 자료 구조이다. 데크,덱으로 불린다.
ArrayDeque가 LinkedList보다 더 나은 성능을 보여준다.
ArrayDeque는 배열을 사용하고 원형 큐 자료 구조를 사용하기 때문이다.
Deque는 스택과 큐의 역할을 모두 수행할 수 있다.
Stack 자료구조가 필요하면 ArrayDeque를 사용하자.
Deque는 Queue의 자식이기 때문에 더 많은 기능이 필요하다면 Deque 인터페이스를 사용하면 된다. 그리고
구현체로 성능이 빠른 ArrayDeque를 사용하자.
```


