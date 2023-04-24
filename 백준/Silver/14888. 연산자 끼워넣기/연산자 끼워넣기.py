import sys
input = sys.stdin.readline

def sol1(ans,i,add,sub,mul,div):
    global maxval,minval

    if i==n:
        maxval=max(maxval,ans)
        minval=min(minval,ans)
        return
    if add:
        sol1(ans+nums[i],i+1,add-1,sub,mul,div)
    if sub:
        sol1(ans-nums[i],i+1,add,sub-1,mul,div)
    if mul:
        sol1(ans*nums[i],i+1,add,sub,mul-1,div)
    if div:
        sol1(int(ans/nums[i]),i+1,add,sub,mul,div-1)

n=int(input())                          # 수열 개수
nums=list(map(int,input().split()))        # 수열
a,s,m,d = map(int,input().split())

maxval=-10**10
minval=10**10
sol1(nums[0],1,a,s,m,d)

print(maxval)
print(minval)