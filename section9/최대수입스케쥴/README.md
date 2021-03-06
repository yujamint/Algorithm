# 최대 수입 스케쥴(PriorityQueue 응용문제)

## 문제

```
[설명]
현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


[입력]
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


[출력]
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
```
```
예시 입력 1 
6
50 2
20 1
40 2
60 3
30 3
30 1

예시 출력 1
150
```

**풀이방법**
- 강연료와 강연날짜를 속성으로 갖는 Lecture 클래스를 생성한다.
- 문제의 예시처럼 총 3일간 강연을 할 수 있다고 할 때, day가 3인 강연으로는 1일차에 강연할 수 있지만, day가 1인 강연으로는 3일차에 강연할 수 없다.
    - 그러므로 더욱 많은 선택지에서 최선의 선택을 하기 위해 Lecture 클래스를 day를 기준으로 내림차순 정렬한다.
- 같은 원리로 강연을 선택할 때도 3일차,2일차,1일차 순으로 강연을 선택한다.
  - 입력받을 때 가자 날짜가 널널한 강연의 day를 max로 저장
- 강연 가능 날짜가 max(3)와 같은 강연들을 PriorityQueue(pQ)에 넣는다.
- 모두 넣은 뒤에는 pQ에서 poll을 해서 answer에 더한다.
    - pQ를 내림차순으로 정렬했기 때문에 날짜가 가능한 강연 중에 제일 강연료가 비싼 강연부터 뽑게 된다.
- 강연 가능 날짜를 하루 늘려 day가 (max-1)~(max)인 강연을 pQ에 넣는다.
- 위와 같이 pQ에서 poll을 해서 answer에 더한다.
    - 이때, day가 2,3인 강연들이 들어있을 것이다. 그 중에서 가장 강연료가 비싼 강연을 고르는 것이다.
- 마지막으로, 강연 가능 날짜를 하루 더 늘려 day가 (max-2)~(max)인 강연을 pQ에 넣는다.
    - 이미 선택(poll)된 강연을 제외하고 day가 1,2,3인 강연들이 pQ에 들어있다.
- 위와 같이 pQ에서 poll을 해서 answer에 더한다.

**얻어갈 것**
- ArrayList를 day로 내림차순 정렬함으로써 2중 for문에서 j를 for문 바깥에다 선언하고, day가 3인 강연 2개를 뽑고 j가 2가 되었을 때(day가 2인 강연이 나오기 시작했을 떄), break하면서 그 상태 그대로 멈췄다가 2일차 공연을 뽑을 때 j가 2에서부터 다시 반복문을 시작할 수 있다. 
- pQ를 내림차순 정렬함으로써 poll만 하면 가장 큰 금액을 뽑을 수 있도록 pQ에 넣을 때 날짜를 고려해서 넣는다. -> Lecture 객체를 list에 담고 list를 내림차순 정렬하는 것도 day 별로 순차적으로 넣기 위해서 하는 것이다.
- pQ에 날짜와 강연료 모두 담고 있는 Lecture 객체를 넣어서 해결하려고 했던 것이 패착인가..?
- Priority Queue 사용법