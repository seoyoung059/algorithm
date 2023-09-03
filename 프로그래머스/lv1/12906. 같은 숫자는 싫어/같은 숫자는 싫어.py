from collections import deque

def solution(arr):
    answer = []
    for e in arr:
        if len(answer)==0:
            answer.append(e)
            continue
        if answer[-1]!=e:
            answer.append(e)
    return answer