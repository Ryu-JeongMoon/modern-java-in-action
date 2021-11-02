# Functional Programming

<hr>

## Why FP ?
함수형 프로그래밍이 제공하는 특별한 두 가지
- immutability
- no side effect

레거시 코드의 유지보수가 어려운 이유는 shared mutable data 를 이용해 물고 뜯고 맛보기 때문 <br>
리스트 하나가 있고 이놈을 참조하는 여러 클래스가 있다고 하면 변경이 일어났을 때 바로 알아차릴 수 있는가?<br>
이런 어려움 때문에 데이터의 불변성을 이용해 부작용을 없애는 함수형 프로그래밍이 필요하다
<hr>

## How define FP ?
부작용이란 자료구조 변경, 필드에 값 할당, 예외 ?!, I/O 작업 등을 의미한다 <br>
아니 이걸 어케 다 없앰? 싶은데 방법이 있나보당 <br>
부작용 없는 시스템에서는 메서드 간 간섭이 없기 때문에 병렬성을 아주 쉽게 처리할 수 있다!!

- 그럼 함수형 프로그래밍이 뭔데 ?!!! <br>
함수를 이용하는 프로그래밍
- 그럼 함수는 또 뭔데 ?!?! <br>
수학에서의 함수와 같음, 같은 input -> 같은 output 

엄밀한 정의에 따라 부작용이 전혀 없는 것을 `순수 함수형 프로그래밍` <br>
부작용이 일어나더라도 클라이언트가 모르면 장땡인게 `함수형 프로그래밍`

자바에서는 I/O 작업에 부작용이 따르기 땜시 순수 함수형은 어렵고 함수형으로 타협한다 <br>
외부 변수를 건드리는 순간 부작용 발생하니 지역 변수만을 변경해야 한다 <br>
또한 함수나 메서드가 어떤 예외도 일으켜서는 안 된다, 같은 return 이 나와야 하는데 예외 터지면 안 되니께

>그럼 예외가 어쩔 수 없이 터지는 상황에서는 어떻게 함??
>- Optional 로 감싸서 빈 Optional 반환
>- 다른 컴포넌트에 영향 주지 말고 지역적으로만 예외 터트림
<hr>

## Declarative Programming and Reference Transparency
프로그램을 구성하는 방식에는 두 가지가 있다
1. _어떻게 문제를 처리하는지_ 에 집중하는 명령형 프로그래밍
2. _무엇을 처리하는지_ 에 집중하는 선언형 프로그래밍

부작용을 감춰야 한다는 제약은 `참조 투명성` 개념으로 귀결된다 <br>
같은 입력 넣었을 때 같은 출력 값 나오는게 참조적으로 투명한 함수라고 한다 <br>
참조 투명성은 시간이 오래 걸리는 작업을 memoization & caching 할 수 있당
<hr>

## Iteration and Recursion
순수 함수형 프로그래밍에서는 for, while 문을 포함하지 않는다 <br>
for, while 을 사용하면 내부에 변경이 스며들 수 있기 때문이다 <br>
대신 Iterator 를 사용하거나 재귀를 사용한다

자바 8 스트림을 이용해 변화를 피할 수 있고, 반복을 재귀로 바꾸면 더 간결, 부작용 노노