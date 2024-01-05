from collections import deque

def solution(prices):
    answer = [i for i in range(len(prices)-1,-1, -1)]
    stack = deque()
    
    for i, p in enumerate(prices):
        while stack and prices[stack[-1]]>p:
            j = stack.pop()
            answer[j] = i-j
        stack.append(i)
    return answer