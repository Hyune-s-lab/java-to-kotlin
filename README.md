# java-to-kotlin

> 챕터별로 개인적으로 얻은 점을 기록합니다.

> commit 제목은 책의 예제 번호 입니다.

[yes24 Link](http://www.yes24.com/Product/Goods/115221699)

## Chapter 4

- takeIf 도 좋지만 과도기라면 when 사용도 좋다.
- Object, companion object 메서드는 확장 함수로 만들면 좋다.

## Chapter 6

- kotlin collection 은 불변이 아니라 읽기 전용이다.
    - mutablelist 로 선언한 list 를 다운 캐스팅할 수 있다.
    - 하지만 이것은 매우 이상하며 혼동을 줄 수 있어 사용하면 안된다.
- 매개변수에 배열이 들어가 있고 그것을 처리하는 경우 확장 함수로 만들면 좋다.
