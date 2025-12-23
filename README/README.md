프로젝트 개요

기본적인 커머스 플랫폼 프로그래밍
객체 지향 설계를 적용한 상품 관리의 클래스 관리
객체 지향 설계를 적용한 순서 제어의 클래스 관리
객체 지향 설계를 적용한 상품 카테고리와 고객 관리의 클래스 기반 관리
캡슐화 적용



주요 기능
메뉴 출력
카테고리별 제품 출력
선택제품 장바구니 저장
장바구니에 담긴 제품 일괄결제

기술 스택
Language: Java 17
IDE: IntelliJ IDEA

패키지 구조
src/
├── commerceStep1/          Step 1: 기본 상품 목록
│   ├── CommerceApp.java
│   ├── Product.java
│   ├── CommerceSystem.java
│   └── CategoryProduct.java
│
├── commerceStep2/          Step 2: 비즈니스 로직 분리
│   ├── CommerceApp.java
│   ├── Product.java
│   ├── CommerceSystem.java
│   └── CategoryProduct.java
│
├── commerceStep3/          Step 3: 카테고리 관리
│   ├── CommerceApp.java
│   ├── CommerceSystem.java
│   ├── CategoryProduct.java
│   ├── Product.java
│   └── Customer.java
│
├── commerceLv1/            도전기능Lv1: 장바구니 + 주문 기능
│ ├──CommerceApp.java
│ ├──CommerceSystem.java
│ ├──CategoryProduct.java
│ ├──Product.java
│ ├──Cart.java
│ └──Customer.java

실행 방법
- CommerceApp 클래스 main 메서드 실행