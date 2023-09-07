def dfs(computers, now, n, visited):
    visited[now] = True
    for i in range(n):
        if now!=i and computers[now][i]==1 and not visited[i]:
            visited = dfs(computers, i,n, visited)
    return visited

def solution(n, computers):
    answer = 0
    visited = [False]*(n)
    cnt=0
    for i in range(n):
        if not visited[i]:
            visited = dfs(computers, i, n, visited)
            answer+=1
    return answer