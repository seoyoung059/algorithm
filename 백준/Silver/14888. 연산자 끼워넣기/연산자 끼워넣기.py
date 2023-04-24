import sys
input = sys.stdin.readline

def calculation(i,ans,next):
    if i==0:
        return ans+next
    elif i==1:
        return ans-next
    elif i==2:
        return ans*next
    elif i==3:
        if ans < 0:
            return -((-ans)//next)
        else:
            return ans//next
        
def dfs(a,i,c,cal_num,ans):
    global maxval
    global minval
    cal_num[c]-=1
    ans=calculation(c,ans,a[i+1])
        
    
    if cal_num==[0,0,0,0]:
        if maxval < ans:
            maxval=ans
        if minval>ans:
            minval=ans
    
    for next_c in range(4):
        cal = cal_num.copy()
        if cal[next_c]>0:
            dfs(a,i+1,next_c,cal,ans)
            
def sol(a,cal_num):
    for c in range(4):
        cal=cal_num.copy()
        if cal[c]>0:
            dfs(a,0,c,cal,a[0])
    print(maxval)
    print(minval)
    
n=int(input())                          # 수열 개수
a=list(map(int,input().split()))        # 수열
cal = list(map(int,input().split()))    # +, -, *, /

maxval=float("-inf")
minval=10**10+1
sol(a,cal)