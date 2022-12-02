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

## Chapter 9

- 단일식은 충분히 짧은 계산식에 사용하면 좋습니다.
- java 에서는 if-else 보다는 early return 형태가 적절했습니다.
    - 하지만 kotlin 의 when 은 if-else 와 같은 효과이면서도 충분한 가독성을 챙길 수 있습니다.
- 단순 사용되는 private 메서드는 let 을 활용하면 좋습니다.
- 확장 함수는 companion object 가 아닌 최상위 레벨로 올립니다.
    - 정확한 이유는 명시되어 있지 않습니다.. 
