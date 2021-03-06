# 연속 부분수열

##문제
```
설명
    N개의 수로 이루어진 수열이 주어집니다.
    
    이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
    
    만약 N=8, M=6이고 수열이 다음과 같다면
    
    1 2 1 3 1 1 1 2
    
    합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.


입력
    첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
    
    수열의 원소값은 1,000을 넘지 않는 자연수이다.


출력
    첫째 줄에 경우의 수를 출력한다.
```
```
예시 입력 1 
8 6
1 2 1 3 1 1 1 2

예시 출력 1
3
```

**풀이방법(Two Pointers)**
- 수열의 위치를 가리키는 두 개의 포인터 lt,rt를 만든다.
- lt와 rt 사이의 (연속적인) 값을 모두 더한 값이 m이 되는지 확인하며 lt와 rt를 이동시킨다.

**얻어갈 것**
- 연속적인 수라는 점에서 Window Sliding을 떠올렸지만, Window의 Size가 특정되어있지 않기 때문에 효율적이지 않은 방법인 거 같다.
- 인덱스를 하나하나씩 이동해가며 풀어야 된다는 것에서 Two Pointers를 떠올려보도록 하자.