# JAVA 필기 테스트 2차

## 이름 : 오민성

1. **접근제한자의 접근 가능 범위가 넓은 것부터 차례대로 기술하시오.** <br>
( public ) > ( protected ) > ( default ) > ( private )

2. **접근제한자(Access modifier) 각각의 접근 가능범위를 간략하게 기술하시오.** <br>
① public ( 전역 )<br>
② protected ( 같은 패키지 이내 ) 비상속시 패키지 이내 /상속 시 패키지 밖 상속받은 후손 클래스 안<br>
③ default ( 같은 패키지 이내 )<br>
④ private ( 같은 클래스 이내 )<br>

3. **메소드 오버로딩(Overloading)에 대한 설명으로 해당되지 않는 것은?** ( 2 , 4 )<br>
① 한 클래스 안에 같은 이름의 메소드가 여러 개 작성된 경우를 말한다.<br>
② 반환자료형은 달라도 된다.<br>
③ 메소드 매개변수의 갯수나 자료형이 다르게 구성되어야 한다.<br>
④ 접근제한자는 달라도 된다. (더 큰 범위로는 가능하다.)<br>

4. **클래스에 상수 필드 NUM 을 선언하고 초기값 100 으로 초기화하는 구문을 작성하시오.**<br>
( pubilc final static int NUM = 100; )
5. **클래스가 가진 인스턴스 변수가 메모리에 할당될 때의 초기화 순서를 맞게 나열하시오.**<br>
① JVM 이 정한 기본값<br>
② 초기화 블럭<br>
③ 매개변수 있는 생성자<br>
④ 명시적 초기값<br>
( 1 ) - ( 4 ) - ( 2 ) - ( 3 )

6. **기본자료형 1차원 배열의 특징으로 틀린 것은?** ( 3 )<br>
① 배열이름은 레퍼런스이다.<br>
② 자료형이 같은 변수들이 연속 나열된 묶음이다.<br>
③ 정적 메모리 영역에 배열을 할당할 수 있다.<br>
④ 배열 할당시 기본값으로 자동 초기화된다.<br>

7. **객체 배열에 대한 설명으로 옳은 것은?** ( 1 )<br>
① 객체 배열은 기본자료형 2차원배열과 유사한 레퍼런스 배열이다.<br>
② 한번의 할당으로 지정한 갯수만큼 자동 객체가 생성된다.<br>
③ 생성된 객체의 인스턴스 변수에는 쓰레기값이 들어간다.<br>
④ 메모리에 객체들을 연속 나열한다.<br>

8. **변수의 생성 시기와 소멸 시기를 기술하시오.**<br>
생성시기 소멸시기<br>
지역변수(Local Variable) ( 메소드 호출 시 ) ( 메소드 종료 시 )<br>
인스턴스변수(Field) ( 클래스 변수 생성 시 ) ( 클래스 호출이 안되면 GC로 이동 후 소멸)<br>
정적변수(static field) ( 프로그램 시작 시 ) ( 프로그램 종료 시 )<br>

9. **this 레퍼런스의 설명으로 틀린 것은?** ( 3 )<br>
① 생성자와 일반 메소드 안에 기본으로 존재하는 레퍼런스 변수이다.<br>
② 메소드와 생성자 실행시 자동으로 주소를 전달받는다.<br>
③ 정적 메소드에서도 사용할 수 있다.<br>
④ 전달받은 주소로 인스턴스 변수에 접근하는 레퍼런스이다.<br>
10. **아래 소스 코드의 컴파일 및 실행 결과값은?** ( 2 )<br>
public class Exam{<br>
    public static void main(String[] args){<br>
        int i = 1;<br>
int j = i++; // i = 2, j = 1;<br>
if((i>++j) && (i++ == j)){ // 2 > 2 false 이므로 i++은 일어나지 않는다.<br>
i += j;<br>
}<br>
System.out.println(i); // i = 2, j = 2;<br>
}<br>
}<br>
11. **다음에서 설명하고 있는 내용을 쓰시오.** ( 메소드 )<br>
추상화된 대상의 행위(기능)을 담당한다. <br>
이것이 호출되면 수행에 필요한 메모리 영역을 할당 받는다.<br>
12. **다음 코드에서 temp 변수의 최종값은?** ( 1 )<br>
long temp = (int)3.9; // int 형변환을 못봤다. 형변환 시 소수점 아래는 버린다.
temp %= 2;
13. **다음 중 식별자(idectifier)로 사용 가능한 것을 모두 고르시오.** ( 3, 5, 7 )<br>
식별자란 클래스명 OR 변수명 등..<br>
① %fred<br>
② #Fred<br>
③ _public<br>
④ 2fred<br>
⑤ Fred2<br>
⑥ My$Tom<br>
⑦ 나이<br>

14. **아래 소스 코드의 컴파일 및 실행 결과는?** ( 4 )<br>
public class Pass {<br>
void doStuff(int x) {<br>
System.out.print("doStuff x = " + (x++)); <br>doStuff x = 5<br>
}<br>
public static void main(String [] args) {<br>
int x = 5;<br>
Pass p = new Pass();<br>
p.doStuff(x);<br>
System.out.print("main x = " + x); main x = 6<br>
}<br>
}<br>
① Compilation fails.<br>
② An exception is thrown at runtime.<br>
③ doStuff x = 6 main x = 6<br>
④ doStuff x = 5 main x = 5 // 기본 자료형은 메소드 호출 후에도 값 변경 적용 X (주소를 참조하지 않기 때문)<br>
⑤ doStuff x = 5 main x = 6<br>
⑥ doStuff x = 6 main x = 5<br>

15. **아래 소스 코드의 컴파일 및 실행 결과는?** ( 8 )<br>
public class SwitchExample {<br>
public static intswitchIt(int x) {<br>
int j = 1;<br>
switch (x){<br>
case 1 : j++;<br>
case 2 : j++;<br>
case 3 : j++;<br>
case 4 : j++; // j = 1;<br>
j = 2;<br>
case 5 : j++;<br>
default : j++; j = 2;<br>
}<br>
return j + x; j = 3; 3 + 4;<br>
}<br>
public static void main(String[] args){<br>
System.out.println(switchIt(4));<br>
}<br>
}<br>
16. **아래 소스 코드의 컴파일 및 실행 결과는?** ( )<br>
public class Test{<br>
private int val;<br>
public Test(int val){<br>
this.val = val;<br>
}<br>
public static void main(String[] args){<br>
Test a = new Test(10);<br>
Test b = new Test(10);<br>
Test c = a;<br>
int d = 10;<br>
double e = 10.0;<br>
System.out.println(a == c); (true)<br>
System.out.println(d == e); (true)<br>
System.out.println(a == b); (false)<br>
System.out.println(b == c); (false)<br>
System.out.println(d == 10.0); (true)<br>
}<br>
}<br>
17. **OOP 의 4 대 특징은 ( 추상화(Abstraction) ), (** 다형성 **), (** 캡슐화 **), (** 상속 **) 이다.**<br>

18. **아래 소스 코드의 컴파일 및 실행 결과는?** ( 2 )<br>
public class WhileExample{<br>
public static void main(String[] args) {<br>
int x=0;<br>
int y=10;<br>
do {<br>
y--; 10 -> 9 -> 8 -> 7 -> 6<br>
++x; 1 -> 2 -> 3 -> 4 -> 5<br>
} while (x < 5);<br>
System.out.print(x + “,“ + y);<br>
}<br>
}<br>
① 5, 6<br>
② 5, 5<br>
③ 6, 5<br>
④ 6, 6<br>
19.  **자바 소스 코드 컴파일시 명시(직접)적으로 코딩하지 않을 경우 컴파일러에 의해 자동
생성되는 코드를 3 개이상 적으시오.**<br>
( 기본 생성자 )<br>
( super() )<br>
( default[접근 제어자] ).<br>
20.  **JVM 에 의해 관리되는 메모리는 크게 3 가지 영역으로 분류되어 관리된다.<br> 프로그램
실행시 클래스가 로드(load)되는** ( 정적 메모리 ) **영역<br>, 지역변수(local variable)가
할당되는** ( stack ) 영역<br>, **인스턴스(instance == 객체)가 할당되는**
( heap ) **영역이다.<br> 이중 생명주기가 가장 짧은 영역은** ( stack ) **이고,
<br>가장 긴 영역은** ( 정적 메모리 ) **이다.**