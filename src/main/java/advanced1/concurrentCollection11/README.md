11. 동시성 컬렉션

11-1 동시성 컬렉션
```html
컬렉션 프레임워크가 제공하는 대부분의 연산은 원자적인 연산이 아니다.
일반적으로 자주 사용하는 ArrayList, LinkedList, HashSet, HashMap등 수 많은 자료 구조들을 단순한 연산을 제공하는 것 처럼 보인다.
하지만 그 내부에는 수 많은 연산들이 함께 사용되므로 일반적인 컬렉션들은 절대로 스레드 세이프 하지 않다!
```

11-2 동시성 컬렉션의 종류
```html
List
CopyOnWriteArrayList -> ArrayList의 대안

Set
CopyOnWriteArraySet - > HashSet의 대안
ConcurrentSkipListSet -> TreeSet의대안(정렬된순서유지, Comparator 사용가능)

Map
ConcurrentHashMap: HashMap의 대안
ConcurrentSkipListMap: TreeMap의 대안(정렬된 순서 유지, Comparator 사용 가능)

Queue
ConcurrentLinkedQueue : 동시성 큐, 비 차단(non-blocking) 큐이다.

Deque
ConcurrentLinkedDeque : 동시성 데크, 비 차단(non-blocking) 큐이다.

LinkedHashSet, LinkedHashMap은 제공되지 않는다. 필요하다면 Collections.synchronizedXxx()를 사용하자

스레드를 차단하는 블로킹 큐
BlockingQueue
    ArrayBlockingQueue
    - 크기가 고정된 블로킹 큐
    - 공정(fair) 모드를 사용할 수 있다. 공정(fair) 모드를 사용하면 성능이 저하될 수 있다.
    LinkedBlockingQueue
    - 크기가 무한하거나 고정된 블로킹 큐
    PriorityBlockingQueue
    - 우선순위가 높은 요소를 먼저 처리하는 블로킹 큐
    SynchronousQueue
    - 데이터를 저장하지 않는 블로킹 큐로, 생산자가 데이터를 추가하면 소비자가 그 데이터를 받을 때까지 대기한다. 생산자-소비자 간의 직접적인 핸드오프(hand-off) 메커니즘을 제공한다. 쉽게 이야기해서 중간에 큐 없이 생산자, 소비자가 직접 거래한다.
    DelayQueue
    - 지연된 요소를 처리하는 블로킹 큐로, 각 요소는 지정된 지연 시간이 지난 후에야 소비될 수 있다. 일 정 시간이 지난 후 작업을 처리해야 하는 스케줄링 작업에 사용된다.

자바가 제공하는 동시성 컬렉션은 멀티스레드 상황에서 최적의 성능을 낼 수 있도록 다양한 최적화 기법이 적용되어 있다.
따라서 Collections.synchronizedXxx를 사용하는 것 보다 더 좋은 성능을 제공한다.
하지만 결국 성능과 트레이드 오프가 있기 때문에 단일 스레드가 컬렉션을 사용하는 경우에는 동시성 컬렉션이 아닌 일반 컬렉션을 사용하자
세상에서 가장 해결하기 어려운 버그가 멀티스레드로 인해 발생한 버그이다.
```







