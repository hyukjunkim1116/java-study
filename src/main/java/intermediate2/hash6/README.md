6. Hash

6-1 리스트 vs 세트
```html
리스트 : 순서 유지, 중복 허용, 인덱스 접근
세트 : 순서 미보장, 유일성, 빠른 검색
리스트는 순서가 중요하거나 중복된 요소를 허용해야 하는 경우에 사용되고 세트는 중복을 허용하지 않고 요소의 유무만 중요한 경우에 사용된다.
```

6-2 해시 알고리즘
```html
데이터의 값 자체를 배열의 인덱스로 사용하면 검색 성능을 O(n)에서 O(1)로 개선할 수 있다.
해시 인덱스를 사용하면 입력 값의 범위가 넓어도 실제 모든 값이 들어오지는 않기 때문에 배열의 크기를 제한하고
나머지 연산을 통해 메모리가 낭비되는 문제도 해결할 수 있다.
하지만 이런 경우 해시 충돌이 발생할 수 있다.
이를 인정하고 같은 해시 인덱스 값을 같은 인덱스에 함께 저장한다.
이때, 배열 안에 배열을 만들면 된다.
따라서 해시 인덱스를 사용하면 최악의 경우 O(n)의 성능을 보인다.
하지만 확률적으로 매우 낮기 때문에 대부분 O(1)의 성능을 제공한다.
해시 충돌이 가끔 발생해도 내부에서 값을 몇 번만 비교하면 되기 때문에 매우 빠르게 값을 찾을 수 있다.
통계적으로 데이터의 수가 배열의 75%를 넘지 않으면 해시 인덱스는 자주 충돌하지 않는다.
배열의 크기를 크게 만들면 충돌은 줄어서 성능은 좋아지지만 많은 메모리가 낭비된다. 따라서 75%를 적절한 크기로 보고 기준을 잡는 것이 효과적이다.
```

6-3 해시 인덱스와 빅오
```html
데이터 저장
    평균: O(1)
    최악: O(n)
데이터 조회
    평균: O(1)
    최악: O(n)
```

