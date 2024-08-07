10. CAS - 동기화와 원자적 연산

10-1 원자적 연산
```html
BasicInteger : 가장 빠르다. CPU 캐시를 적극 사용한다. 안전한 임계 영역도 없고 volatile도 사용하지 않기 때문에 멀티스레드 상황에서 사용할 수 없다.
따라서 단일 스레드가 사용하는 경우에 효율적이다.
VolatileInteger : volatile을 사용해서 CPU 캐시를 사용하지 않고 메인 메모리를 사용한다.
안전한 임계 영역이 없기 때문에 멀티 스레드 상황에서는 사용할 수 없다. 단일 스레드가 사용하기에는 BasicInteger보다 느리다. 그리고 멀티스레드 상황에도 안전하지 않다.
SyncInteger : synchronized를 사용한 안전한 임계 영역이 있기 때문에 멀티스레드 상황에도 안전하게 사용할 수 있다.
락을 걸지 않고 원자적인 연산을 수행할 수 있는 방법을 CAS(Compare-And-Swap, Compare-And-Set)연산이라고 한다. 이 방법은 락을 사용하지 않으므로 락 프리 기법이라고도 한다.
CAS 연산은 락을 완전히 대체하는 것은 아니고 작은 단위의 일부 영역에 적용할 수 있다.
new AtomicInteger(), compareAndSet()를 통해 CAS 연산을 지원한다.
이 메서드는 원자적으로 실행된다.
```

10-2 CAS와 락의 비교
```html
락 방식
-비관적 접근법
-데이터에 접근하기 전에 항상 락을 획득
-다른 스레드의 접근을 막음
-다른 스레드가 방해할 것이다라고 가정
-> 스레드 충돌을 방지하기 위해 모든 스레드가 락을 획득하고 반환하는 과정을 거친다. 따라서 순서대로 하나씩 수행된다.
CAS 방식
-낙관적 접근법
-락을 사용하지 않고 데이터에 바로 접근
-충돌이 발생하면 그때 재시도
-대부분의 경우 충돌이 없을 것이라고 가정
-> 모든 스레드를 한번에 실행한다. 그리고 충돌이 나는 경우만 재시도 한다.
```

10-3 락 VS CAS 사용 방식 정리
```html
CAS
장점 1. 낙관적 동기화 : 락을 걸지 않고 값을 안전하게 업데이트 가능
2. 락 프리 : CAS는 락을 사용하지 않기 때문에 락을 획득하기 위해 대기하는 시간이 없다.
단점 1. 여러 스레드가 동시에 동일한 변수에 접근하여 업데이트를 시도할 때 충돌 발생. 발생하면 CAS는 루프를 돌며 재시도 한다. 이때 CPU 자원을 계속 소모할 수 있다.
2. CAS는 충돌 시 반복적인 재시도를 하므로 스핀락과 유사한 성능 저하가 발생할 수 있다.
동기화 락
장점 1. 충돌 관리
2. 안정성
3. 스레드 대기
단점 1. 락 획득 대기 시간 : 스레드가 락을 획득하기 위해 대기하는 시간이 길어질 수 있다.
2. 컨텍스트 스위칭 오버헤드

결론적으로, 일반적인 상황에는 동기화 락을 사용하고 특별한 경우에 CAS를 사용해서 최적화 한다.
스레드를 RUNNABLE로 살려둔 상태에서 계속 락 획득을 반복 체크하는 것이 더 효율적인 경우에 CAS를 사용하는것이 좋다.
다만 이때 대기 시간이 아주 짧아야 한다.
예를 들어 숫자 값의 증가, 자료 구조의 데이터 추가/삭제와 같이 CPU 사이클이 금방 끝나지만 안전한 임계영역, 또는 원자적인 연산이 필요한 경우에 사용해야 한다.
반면에 데이터베이스를 기다린다거나 다른 서버의 요청을 기다리는 것 처럼 오래 기다리는 작업에 CAS를 사용하면 CPU를 계속 사용하며 기다리는 최악의 결과가 나올 수 있다.
이럴 때는 동기화 락을 사용하자

실무 관점에서는 대부분의 어플들은 공유자원을 사용할 때 충돌 가능성보다 충돌하지 않을 가능성이 훨씬 크다.
따라서 실무에서는 단순한 연산의 경우 CAS 처럼 낙관적인 방식이 더 나은 성능을 보인다.
```






