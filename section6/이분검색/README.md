# 이분검색(Binary Search)

## 문제
```
[설명]
임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면

이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.


[입력]
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.

두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.


[출력]
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
```
```
예시 입력 1 
8 32
23 87 65 12 57 32 99 81

예시 출력 1
3
```
**풀이방법**
- 배열을 정렬한다.(삽입 정렬 사용했음) // 또는 Arrays.sort()
- 이진탐색을 통해 m의 위치를 찾아낸다.
    - low의 초기값을 배열의 첫 인덱스인 0, high의 초기값을 배열의 끝 인덱스인 n-1로 잡는다.
    - mid 의 값은 low와 high에 의거해 (low+high)/2 이다.
    - 만약 arr[mid] == m 이라면, m이 몇 번째 인덱스인지 바로 리턴한다.
    - arr[mid]가 m보다 크다면, 정렬된 상태이므로 mid 인덱스 전까지로 범위를 축소해서 탐색한다. 즉, low 인덱스부터 mid -1 인덱스까지 찾을 것이므로 high = mid-1
    - arr[mid]가 m보다 작다면, 탐색 범위를 mid 인덱스의 바로 뒤부터 배열의 끝까지로 축소해서 탐색한다. 즉, mid+1 인덱스부터 high 인덱스까지 찾을 것이므로 low = mid+1
    - arr[mid] != m 일 경우, 위와 같이 low 또는 high의 값이 변경되면서 mid의 값도 변경된다. 이에 따라 범위를 좁혀가면서 탐색하는 알고리즘이다.

**공부할 내용**
- 이진탐색(Binary Search) 구현
- 순차탐색(Sequential Search)은 첫 인덱스부터 끝까지 하나씩 검사하는 방법
    - 시간복잡도 : O(n)