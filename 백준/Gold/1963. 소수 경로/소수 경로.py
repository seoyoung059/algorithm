from collections import deque
n=int(input())

def findPrime():
    for i in range(2, 100):
        if prime[i] == True:
            for j in range(2*i, 10000, i):
                prime[j]=False

def bfs(start, end):
    q = deque()
    q.append([start, 0])
    visit = [0 for i in range(10000)]
    visit[int(start)] = 1

    while q:
        now, cnt = q.popleft()
        if now==end:
            return cnt
        for i in range(4):
            for j in range(10):
                tmp = now[:i]+str(j)+now[i+1:]
                if visit[int(tmp)]==0:
                    if prime[int(tmp)] and int(tmp) >= 1000:
                        visit[int(tmp)]=1
                        q.append([tmp,cnt+1])
                        
prime = [True for _ in range(10000)]
findPrime()

for i in range(n):
    start, end = input().split()
    print(bfs(start, end))