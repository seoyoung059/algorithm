from collections import deque


N = int(input())
building=[[] for _ in range(N+1)]
degree=[0]*(N+1)
cost=[0]*(N+1)
answer=[0]*(N+1)
q=deque()

for i in range(1,N+1):
    arr = list(map(int, input().split()))
    cost[i] = arr[0]
    for next in arr[1:-1]:
        building[next].append(i)
        degree[i]+=1
        
for i in range(1, N+1):
    if degree[i]==0:
        q.append(i)
        answer[i] = cost[i]
        
while q:
    target = q.popleft()
    for i in building[target]:
        degree[i]-=1
        answer[i] = max(answer[i], answer[target]+cost[i])
        if degree[i]==0:
            q.append(i)

for i in range(1, N+1):
    print(answer[i])