from collections import deque

def solution(numbers):
    l = len(numbers)
    answer = [-1] * l
    stack = deque()
    
    for i, n in enumerate(numbers):
        while stack and numbers[stack[-1]] < n:
            answer[stack.pop()] = n
        stack.append(i)
    return answer