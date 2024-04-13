6.훈련

6-1: Scanner 학습
```html
프로그래머가 하는 대부분의 일은 변수,연산자,조건문,반복문을 다루는 일이다.
Scanner 클래스를 활용해서 사용자의 입력을 받을 수 있다.
Scanner scanner = new Scanner(System.in);
String str = scanner.nextLine(); : \n을 입력할때까지 문자를 가져온다
String intVal = scanner.nextInt(); : 입력을 int형으로 가져온다
String doubleVal = scanner.nextDouble(); : 입력을 double형으로 가져온다.
print() : 다음 라인으로 넘어가지 않음
println() : 다음 라인으로 넘어감
```