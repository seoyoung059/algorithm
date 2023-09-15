from collections import deque

def solution(s):
    answer = -1
    left = deque([s[0]])
    right = deque(list(s[1:]))
    # print(left, right)
    
    while right:
        popped = right.popleft()
        if left:
            if popped == left[-1]:
                left.pop()
                continue
        left.append(popped)
    if not left and not right:
        answer = 1
    else:
        answer = 0

    return answer