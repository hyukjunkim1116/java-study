7. 배열

7-1 배열이 필요한 이유
```html
배열이 없다면 변수를 계속 추가해야 한다. 결국 비슷한 변수를 반복해서 선언하는 문제가 생길 수 있다.
이렇게 같은 타입의 변수를 반복해서 선언하고 사용하지 않게 하기 위해 배열이 등장했다.
```
7-2 배열의 선언과 생성
```java
public class Array1Ref1 {
    public static void main(String[] args) {
        int[] students; //배열 변수 선언 
        students = new int[5]; //배열 생성. 5개의 int 공간이 생성된다. 이렇게 될 경우 자바는 배열을 자동으로 초기화 하는데, 숫자는 0 boolean은 false, String은 null로 초기화 된다.
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;
        //변수 값 사용
        System.out.println("학생1 점수: " + students[0]);
        System.out.println("학생2 점수: " + students[1]);
        System.out.println("학생3 점수: " + students[2]);
        System.out.println("학생4 점수: " + students[3]);
        System.out.println("학생5 점수: " + students[4]);
    } 
}
```
```html
배열의 크기만큼 메모리를 확보하고 students 변수에는 배열의 참조값이 보관된다. 이를 통해 배열을 참조 한다.
```
7-3 기본형 vs 참조형
```html
사용하는 값을 직접 넣으면 기본형이고 메모리의 참조값을 넣으면 참조형이다.
기본형 : int` , `long` , `double` , `boolean`. 선언과 동시에 크기가 정해짐
참조형 : int[] students, 객체, 클래스. 동적으로 크기 정할 수 있음. 동적 메모리 할당이라고 한다.
기본형은 빠르게 메모리를 효율적으로 처리할 수 있다. 참조형은 복잡한 데이터 구조를 만들고 관리할 수 있다.
```
7-4 배열 리팩토링
```html
int[] students;
students = new int[]{90,80,70,60,50};
편리한 초기화 : int[] students = {90,80,70,60,50};
```
7-5 이차원 배열
```html
int[][] arr =new int[2][3]
arr[행][열] arr[가로][세로]
```
7-6 이차원 배열의 리팩토링
```html
이차원 배열도 편리하게 초기화 가능하다.
int[][] arr = {
    {1,2,3},
    {4,5,6}
}
```
7-7 향상된 for문
```html
for (변수 : 배열 or 컬렉션) {
}
증가하는 index값이 필요하면 사용할 수 없다.
그냥 배열을 처음부터 끝까지 탐색하고 싶을때 사용한다.
```
