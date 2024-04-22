6.날짜와 시간

6-1 날짜와 시간 라이브러리가 필요한 이유
```html
1. 날짜와 시간 차이 계산시 윤년, 각 달의 일수 등을 모두 고려해야 해서 정확한 결과를 얻기 어렵다
2. 윤년 계산이 빡세다
3. 일광 절약 시간 변환하기 빡세다
4. 세계의 다양한 타임존을 변환해서 계산하기 빡세다
```

6-2 LocalDate, LocalTime, LocalDateTime
```html
LocalDate : 날짜만 표현할 때 사용
LocalTime : 시간만 표현할 때 사용
LocalDateTime : 위 둘 합한 개념
```

6-3 ZonedDateTime, OffsetDateTime
```html
ZonedDateTime: 시간대를 고려한 날짜와 시간을 표현할 때 사용. 시간대를 표현하는 타임존 포함
OffsetDateTime: 위와 같지만 타임존은 없고 UTC로부터의 시간대 차이인 고정된 오프셋만 포함
```

6-4 Instant
```html
Instant는 시간의 한 지점이다. 날짜와 시간을 나노초 정밀도로 표현
내부에 초 데이터만 들어있다.
```

6-5 시간의 개념
```html
Period : 두 날짜 사이의 간격을 년월일 단위로 나타냄
Duration : 두 시간 사이의 간격을 시,분,초 단위로 나타냄
모든 날짜 클래스는 불변이므로 항상 반환값을 받아야 한다.
```

6-6 메서드
```html
isEqual() 은 시간이 같으면 true : 논리적
equals() 은 구성용소가 같아야 true : 동일성
```

6-7 시간 단위와 시간 필드
```html
시간 단위는 ChronoUnit 열거형으로 구현되어 있다.
시간 필드는 ChronoField 열거형으로 구현되어 있다.
```

6-8 정리
```html
LocalDateTime의 주요 메서드
ZonedDataTime의 주요 메서드
Instant의 주요 메서드
보고 나중에 필요할때 찾자
```