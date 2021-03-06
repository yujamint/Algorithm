# 조합의 경우수(메모이제이션)

## 문제
```
설명

다음 공식으로 계산합니다.
```
![image](https://cote.inflearn.com/public/upload/8f99ebbe8d.jpg)
```
하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
```
![image2](https://cote.inflearn.com/public/upload/b4a8e9f795.jpg)
```
[입력]
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.


[출력]
첫째 줄에 조합수를 출력합니다.
```
```
예시 입력 1 
5 3

예시 출력 1
10

예시 입력 2 
33 19

예시 출력 2
818809200
```

nCr = (n-1)C(r-1) + (n-1)C(r) 원리
- n = 5, r = 3 => 5명의 학생 중 3명의 학생을 뽑는 상황이라고 가정
- 5명의 학생 중 3명의 학생을 뽑는 경우의 수는 다음과 같이 나눌 수 있다.
    - 특정 학생을 확정적으로 포함하고, 남은 4명의 학생 중 2명을 뽑는 경우 : 4C2
    - 특정 학생을 확정적으로 포함하지 않고, 남은 4명의 학생 중 3명을 뽑는 경우 : 4C3
    - 이 두 가지 경우를 합하면 5명의 학생 중 3명의 학생을 뽑는 것과 같다.

**풀이방법**
- 위 원리를 이용해서 Combination을 계속 나누면 r=0 또는 r=n이 된다.
- r=0 또는 r=n 일 때, 그 조합의 결과값은 무조건 1이다. (5C0 = 1, 17C0 = 1)
    - 즉, 1을 리턴한다.
- 1을 리턴한 값들이 합쳐져서 구하고자 했던 조합의 결과값을 찾을 수 있게 된다.
- 하지만, DFS의 특성 상 n과 r이 커질수록 시간복잡도가 매우 커진다.
- 이를 방지하기 위해 메모이제이션을 사용한다.

**메모이제이션**
- 이미 계산했던 값을 또 계산하지 않고, 처음 계산할 때 기록해놓고 나중에 또 필요하면 기록해놓은 곳에서 바로 가져와서 사용한다.
- 즉, n과 r을 입력받으면 이를 분리하기 위해 재귀호출을 하기 전에, nCr 값이 메모이제이션 배열에 저장돼있는지 먼저 확인한다.
    - 만약 저장되어 있다면, 그 값을 바로 리턴한다. 
    - 저장되어 있지 않다면 재귀호출을 통해 값을 얻어오고 그 값을 다음에 또 필요할 때 사용하기 위해 배열에 기록해놓도록 한다.
    
**얻어갈 것**
- 메모이제이션 사용 -> 시간복잡도 줄임
- 조합 계산