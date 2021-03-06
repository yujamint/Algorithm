# 가장 높은 탑 쌓기

## 문제
```
[설명]
밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.

아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.

(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.

(조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.

(조건3) 벽돌들의 높이는 같을 수도 있다.

(조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.

(조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.


[입력]
입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.

둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.

각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.


[출력]
첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.
```
```
예시 입력 1 
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

예시 출력 1
10
```

**첫 번째 풀이 방법**
- dy 배열 : i번째 벽돌이 꼭대기인 탑의 최대 길이
- 넓이, 높이, 무게를 속성으로 갖는 Brick 클래스를 생성하고, 입력받은 벽돌의 정보로 Brcik 객체를 만들어 배열에 저장한다.
- 최대 부분 증가수열의 길이를 찾을 때와 같이, 앞의 인덱스부터 탑을 세운다고 가정하고, dy 배열을 채워나간다.
- 이미 만들어진 탑 중에 꼭대기의 넓이,무게가 모두 i번째 벽돌보다 큰 탑을 찾는다.
- 위 조건을 만족하는 탑 중에서, 최대 높이를 가지는 탑에 i번째 벽돌의 높이를 더해서 dy[i]를 채운다.
- 조건을 만족하는 탑이 없다면, i번째 벽돌의 높이가 탑의 길이가 된다.(i번째 벽돌만 올라가있는 탑인 것)
- **이렇게 풀었을 때, 5가지 케이스 중 3가지 케이스에서 오답 처리됐다.**

**강의 풀이방법**
- Brick 클래스를 생성해 객체를 만들어 ArrayList에 저장한다.
- 벽돌을 넓이 기준으로 내림차순 정렬한다.
- 내림차순으로 정렬함으로써 i번째 벽돌이 올라갈 수 있는 탑을 찾을 때, 꼭대기 벽돌과 무게만 비교한다.
    - 내 풀이에서는 꼭대기 벽돌의 무게와 넓이 모두 비교했다.
- 이렇게 했을 땐 5가지 케이스 모두 정답 처리됐다.
- 어쨌든 위 풀이에서도 넓이에 대해서 비교를 했는데 뭐가 문제였던 걸까?
    - 내 풀이에서는 다음과 같은 문제가 있었다.
    - dy[0~(i-1)] 중에 i번째 벽돌이 꼭대기로 올라갈 수 있으면서 제일 길이가 높은 탑의 길이가 12였다고 가정하자. 그렇다면 내 풀이에서는 길이가 12인 탑에 i번째 벽돌을 올렸을 것이고, 그게 최대라고 생각했을 것이다. 하지만, dy[i+2] = 14인 탑이 들어왔고, 이 탑의 위에도 i번째 벽돌이 올라갈 수 있다면, i번째 벽돌은 자신이 올라갈 수 있는 탑 중에 최대길이의 탑에 올라간 것이 아니다. 그저 i번 전까지 만든 탑 중에서만 고른 것일 뿐이었다.
    
**얻어갈 것**
- 두 가지 조건 중에 한 가지 조건을 정렬함으로써 한 가지의 조건만 본다.