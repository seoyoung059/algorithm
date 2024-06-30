import sys
sys.setrecursionlimit(10**4)

n = int(sys.stdin.readline())
a = sys.stdin.readline().rstrip()

g=[[] for i in range(n+1)]
for i in range(1,n):
    k,l = [int(x) for x in sys.stdin.readline().split()]
    g[k].append(l)
    g[l].append(k)
    
def dfs(g,s,a):
    global flag
    # visited[s]=True
    flag = flag|1<<s
    cnt=0
    for i in g[s]:
        if flag & 1<<i:
            pass
        else:
            if a[i-1]=='0':
                cnt+=dfs(g,i,a)
            else:
                cnt+=1
    return cnt

def sol(n,g,a):
    cnt=0
    global flag
    for i in range(1,n+1):
        if a[i-1]=='1':
            # visited=[False]*(n+1)
            flag=0
            cnt+=dfs(g,i,a)
    return cnt

flag=0
print(sol(n,g,a))