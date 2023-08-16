def dfs(arr, ans, visit, n, depth):
    if depth == 6:
        print(' '.join(map(str,ans)))
    for i in range(n):
        if not visit[i]:
            if (len(ans)>0 and arr[i] < ans[-1]):
                continue
            visit[i]=True
            ans.append(arr[i])
            dfs(arr,ans,visit,n,depth+1)
            visit[i]=False
            ans.pop()
            
while True:
    arr = list(map(int,input().split()))
    if arr[0]==0:
        break
    n=arr.pop(0)
    dfs(arr,[],[False]*n,n,0)
    print()