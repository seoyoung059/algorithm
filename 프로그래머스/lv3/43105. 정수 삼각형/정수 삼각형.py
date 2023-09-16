def solution(triangle):
    answer = 0
    n = len(triangle)
    for i in range(n):
        triangle[i].insert(0,0)
        triangle[i].append(0)
        if i==0: continue
        for j in range(1,len(triangle[i])-1):
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
            
    answer = max(triangle[n-1])
    return answer