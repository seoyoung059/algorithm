from collections import deque

string = deque(input())
explode_string = input()
explode_len = len(explode_string)

ans = deque()

while string:
    ans.append(string.popleft())
    if len(ans) >= explode_len:
        for i in range(explode_len):
            if ans[-i-1] != explode_string[-i-1]:
                break
            if i==explode_len-1:
                for i in range(explode_len):
                    ans.pop()


if len(ans)==0:
    print('FRULA')
else:
    print(''.join(ans))