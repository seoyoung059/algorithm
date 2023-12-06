import sys


def back_tracking(x):

    # x가 n개라면 => x == len(temp)
    # 조건에 맞게 수를 더해준다.
    if x == n:
        answer.append(sum(abs(m[temp[i + 1]] - m[temp[i]]) for i in range(n - 1)))
        return

    # 반복문을 통해 idx를 temp에 저장
    for i in range(n):
        if i not in temp:
            temp.append(i)
            back_tracking(x + 1) # 백 트래킹
            temp.pop()


n = int(sys.stdin.readline())
m = list(map(int, sys.stdin.readline().split()))
answer = []
temp = []
back_tracking(0)

print(max(answer))