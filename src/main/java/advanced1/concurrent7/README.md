7. 고급 동기화 - concurrent.Lock

7-1 LockSupport
```html
synchronized는 무한대기와 공정성의 문제가 있다.
그래서 java.util.concurrent라는 동시성 문제 해결을 위한 라이브러리 패키지가 만들어졌다.
LockSupport는 스레드를 WAITING 상태로 변경한다.
대표적인 기능은
park() : 스레드를 WAITING 상태로 변경한다.
parkNanos(nanos) : 스레드를 나노초 동안만 TIMED_WAITING 상태로 변경한다.
unpark(thread) : WAITING 상태의 대상 스레드를 RUNNABLE 상태로 변경한다.
```

7-2 ReentrantLock
```html
synchronized의 단점을 보완하기 위해 Lock 인터페이스와 ReentrantLock 구현체를 제공한다.
Lock 인터페이스는
void lockInterruptibly() : 락 획득을 시도하되 다른 스레드가 인터럽트 할 수 있도록 한다. 다른 스레드가 락을 획득했다면 현재 스레드는 락을 획득할 때 까지 기다린다.
boolean tryLock() : 락 획득을 시도하고 성공여부를 반환한다.
boolean tryLock(long time, TimeUnit unit) : 주어진 시간동안 락 획득을 시도한다.
void unlock() : 락을 헤제한다.
Condition newCondition() : Condition 객체를 생성하여 반환한다. 스레드가 특정 조건을 기다리거나 신호를 받을 수 있도록 한다.

ReentrantLock는 스레드가 공정하게 락을 얻을 수 있는 모드를 제공한다.
비공정 모드는 락을 먼저 요청한 스레드가 락을 먼저 획득한다는 보장이 없다. 성능 우선, 선점 가능, 기아 현상 가능성이 있다.
공정 모드는 생성자에서 true를 전달하면 된다. 공정성을 보장하며 기아 현상을 방지하지만 성능 저하의 단점이 있다.
```





