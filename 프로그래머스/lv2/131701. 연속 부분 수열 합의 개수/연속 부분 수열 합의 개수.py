def solution(elements):
    answer = 0
    n = len(elements)
    sol = set()
    for i in range(n):
        tmp = 0
        for j in range(n):
            tmp += elements[(i+j)%n]
            sol.add(tmp)
    answer = len(sol)
                
    return answer

