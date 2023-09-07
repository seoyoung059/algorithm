def bfs(now, idx, numbers, target):
    if idx == len(numbers):
        if now == target:
            return 1
        else:
            return 0
    return bfs(now+numbers[idx], idx+1, numbers, target) + bfs(now-numbers[idx], idx+1, numbers, target)

def solution(numbers, target):
    answer = 0
    answer = bfs(0,0,numbers,target)
    return answer

