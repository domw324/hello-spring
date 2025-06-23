*Rpm Study (for the Spring and Spring boot) - RPM 서비스 기획팀 BE 개발자들의 스터디 공간입니다.*

## 학습 정보
추후 합류하게 될 Motiiv BE 업무 대비, spring 및 spring boot를 익힌다.
### 학습 목표
- inflearn 강의를 듣고 공유한다.

### 학습 진행 방법
#### 진행 규칙
- 각자 맡은 예제 프로젝트 완성 후 오프라인에서 설명&질문 타임
	- 섹션 3: 상준 / 섹션 4: 태이/ 섹션 5: 정빈
	- 자기가 맡은 부분이 별 게 없어서 다른 사람 영역까지 하면 완전 멋쟁이!
- 6월 17일, 6월 24일, 7월 2일. 세 번의 오프라인 스터디를 진행한다.

#### 강의 링크
[스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술 (inflearn/김영한)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard)
> inflearn은 동시 접속 불가 (동시 접속 다회 발생 시 제한 발생)


## 개발 환경 소개
### 예제 생성
[spring initializr](https://start.spring.io/) 에서 프로젝트를 생성한다.

- Project: Gradle - Groovy
- Language: Java
- Spring Boot: 3.5.0
- *Project Mateadata (변경 가능)*
	- *Group: hello*
	- *Atifact: hello-spring*
	- *Name: hello-spring*
	- *Description: Demo project for Spring Boot*
	- *Package name: hello.hello-spring*
- Java: 17
- Dependencies: Spring Web, Thymeleaf

### 예제 관련 설명
- Motiiv 에서는 **Gradle + Kotlin언어** 조합의 spring boot 환경을 사용 중
- 다만 강의의 내용은 **Gradle + Grooby + Java언어** 이기 때문에 일단은 강의대로 따라간다.
- 실제 Java와 Kotlin은 문법 차이가 크지 않기 때문에, 최우선적으로 spring boot를 이해하는 것을 주 목적으로 하고 추후 Kotiln은 적응하는 것으로 한다.