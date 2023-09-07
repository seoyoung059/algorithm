from collections import deque
def solution(s):
    answer = True
    stack = deque()
    for i in range(len(s)):
        if s[i]=="(":
            stack.append(s[i])
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False

    return True