# Java Module System

자바 9의 핵심 기능은 모듈 시스템, Jigsaw 프로젝트 내부에서 개발된 기능으로 완성까지 10년 걸림 <br>
10년이 걸렸다는 것은 모듈 시스템이 얼마나 중요한 기능인지를 반증한다

### 그렇다면 모듈 시스템이 뭐가 그렇게 중요한걸까? <br>

람다, 스트림은 문제를 그대로 서술하는 듯한 코드, 이해하기 쉽고 유지보수 하기 쉬운 코드를 작성하는데 도움을 준다 <br>
이것만으로는 저수준의 영역에 그치고 고수준의 영역, 아키텍처 관점에서 유지보수 하기 쉽도록 만들어준다 <br>
좋은 소프트웨어를 만들 때 관심사 분리 (Separation of Concern) 원칙을 지켜 프로그램을 고유의 기능 단위로 나눈다 <br>
Encapsulation 을 통해 변하는 부분을 외부에 숨겨 코드를 관리하고 유지보수하기 쉽게 만든다 <br>
캡슐화는 접근 제어자 / 제한자를 이용하는데 어쩔 수 없이 public 으로 만들어야 하는 클래스나 메서드의 경우, <br>
일부 클래스나 메서드에서만 사용하면 되지만 원치 않게 전부 공개해야 할 때가 있다 <br>
이런 부작용을 막기 위해 모듈 시스템이 등장했고 모듈 간의 의존성을 설정하지 않는 이상 같은 프로젝트 내에 있더라도<br>
모듈 시스템은 다른 프로젝트에 있는 것처럼 public 접근 제어자를 사용하더라도 해당 클래스를 사용할 수 없도록 만든다

### 모듈화의 필요성

Java 를 사용하는 이들 뿐만 아니라 만드는 이들에게도 모듈화는 필요했다 <br>
sun.misc.Unsafe 라는 클래스는 JDK 내부에서만 사용되도록 만들어야 했지만 모듈화 시스템이 없었기 때문에 공개되었고<br>
Spring, Netty, Mockito 에서 Unsafe 클래스를 가져다 썼다 <br>
Unsafe 와 같은 클래스를 수정할 때, 호환성을 깨지 않고는 변경하기 쉽지 않게 되었고 모듈의 필요성이 대두되었다
<hr>