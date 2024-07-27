8. Set

8-1. 자바의 HashSet, LinkedHashSet
```html
Collection 인터페이스를 Set 인터페이스가 상속하고 HashSet,TreeSet이 상속하고 LinkedHashSet이 HashSet를 상속받는다.
    Collection
        Set
HashSet     TreeSet
LinkedHashSet
Set인터페이스는 중복을 허용하지 않는 유일한 요소의 집합을 나타낸다. 순서를 보장하지 않고
특정 요소가 집합에 있는지 여부를 확인하는데 최적화되어 있다.
```

8-2 HashSet
```html
해시 자료 구조를 사용해서 요소를 저장한다.
요소들은 특정한 순서 없이 저장된다.
추가 삭제 검색은 평균 O(1) 시간 복잡도를 가진다.
데이터의 유일성만 중요하고 순서가 중요하지 않은 경우에 적합한 구조이다.
```

8-3 LinkedHashSet
```html
HashSet에 연결 리스트를 추가해서 요소들의 순서를 유지한다.
요소들은 추가된 순서대로 유지된다. 순서대로 조회 시 요소들이 추가된 순서대로 반환된다.
O(1)의 시간 복잡도를 가진다.
데이터의 유일성과 함께 삽입 순서를 유지해야 할때 적합하다.
HashSet에 LinkedList를 합친 것으로 이해하면 된다.
```

8-4 TreeSet
```html
이진 탐색 트리를 개선한 레드-블랙 트리를 내부에서 사용한다.
요소들은 정렬된 순서로 저장된다. 순서의 기준은 비교자로 변경 가능하다.
O(log n)의 시간 복잡도를 가진다.
데이터들을 정렬된 순서로 유지하면서 집합의 특성을 유지해야 할 때 사용한다. 범위 검색이나
정렬된 데이터가 필요한 경우에 유용하다. 데이터 값의 순서이다.
자식이 2개까지 오고 왼쪽은 더 작고 오른쪽이 더큰 값을 가지는 것을 이진 탐색 트리라고 한다.
이진 탐색 트리의 핵심은 입력 순서가 아니라 데이터의 값을 기준으로 정렬해서 보관한다는 점이다.
따라서 정렬된 순서로 데이터를 차례로 조회할 수 있다.
중위 순회 순서란 자신의 왼쪽 모든 노드를 처리하고 자신의 노드를 처리하고 자신의 오른쪽 모든 노드를 처리하는 방식이다.
이를 사용하면 데이터를 차례로 순회할 수 있다.
따라서 HashSet은 입력 순서를 보장하지 않고 LinkedHashSet은 입력 순서를 보장하고 TreeSet은 데이터 값을 기준으로 정렬한다.
```

8-5 최적화
```html
데이터가 동적으로 추가되면 배열의 크기가 75%를 넘어가면 해시 인덱스가 자주 충돌하기 때문에 동적으로 배열을 2배 늘리고
해시 인덱스를 다시 적용한다. HashSet의 기본 크기는 16이다.
실무에서는 HashSet를 가장 많이 사용한다. 그리고 입력 순서 유지, 값 정렬의 필요에 따라 LinkedHashSet, TreeSet을 선택한다.
```

