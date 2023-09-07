from collections import deque

def solution(n, edge):
    answer = 0
    # graph = {i:{} for i in range(n+1)}
    graph = [[] for i in range(n+1)]
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])
    answer = bfs(n,graph)
    return answer

def bfs(n,graph):
    
    q = deque()
    q.append(1)
    
    visited = [-1]*(n+1)
    visited[1] = 0
    
    max_val = 0
    cnt = 0
    
    while q:
        curr = q.popleft()
        
        for i in graph[curr]:
            if visited[i] == -1:
                visited[i] = visited[curr]+1
                if visited[i] > max_val:
                    max_val = visited[i]
                    cnt = 1
                elif visited[i] == max_val:
                    cnt+=1
                q.append(i)
                
    return cnt