``` java
StringBuffer 자료형은 String 자료형보다 무거운 편에 속한다. new StringBuffer()로 객체를 생성하면 String을 사용할 때보다 메모리 사용량도 많고 속도도 느리다. 따라서 문자열을
추가학거나 변경하는 작업이 많으면 StringBuffer를, 적으면 String을 사용하는 것이 유리하다. 

그리고 StringBuffer는 멀티 쓰레드 환경에서 동기화를 보장한다. 따라서 멀티 쓰레드 환경에서 안전하게 사용할 수 있다.

StringBuilder는 StringBuffer와 동일한 기능을 제공하지만 동기화를 보장하지 않는다. 따라서 멀티 쓰레드 환경에서 사용할 때는 주의해야 한다. 하지만 동기화 처리를 하지 않아 성능상 우수하다.  
```


