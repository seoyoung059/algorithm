def solution(n, s):
    answer = []
    div = s//n
    nameoji = s%n
    
    if div == 0:
        return [-1]
    
    answer = [div] * n
    for i in range(nameoji):
        answer[n-1-i] += 1
    return answer