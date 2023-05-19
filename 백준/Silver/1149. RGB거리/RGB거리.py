import sys
input = sys.stdin.readline

n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
dp = [[0]*(4) for _ in range(n+1)]

prev=[0,0]
curr=[1,1]
curr_val1=1000*n+1
curr_val2=1000*n+1
for i in range(1,n+1):
    curr=[1,1]
    curr_val1=1000*n+1
    curr_val2=1000*n+1
    for j in range(1,4):
        if j==prev[0]:
            dp[i][j]=dp[i-1][prev[1]]+arr[i-1][j-1]
        else:
            dp[i][j]=dp[i-1][prev[0]]+arr[i-1][j-1]
        
        if dp[i][j]<curr_val1:
            curr[1]=curr[0]
            curr_val2=curr_val1
            curr[0]=j
            curr_val1=dp[i][j]
        elif dp[i][j]<curr_val2:
            curr[1]=j
            curr_val2=dp[i][j]
    prev=curr
    
print(min(dp[-1][1:]))