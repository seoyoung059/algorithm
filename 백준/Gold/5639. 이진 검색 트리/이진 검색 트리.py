import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
nums = []
while True:                            
    try:
        nums.append(int(input()))
    except:
        break
        
def postorder(li,s,e):
    if s > e:
        return
    mid = e+1
    for i in range(s+1,e+1):
        if li[s] < li[i]:
            mid = i
            break
    
    postorder(li,s+1,mid-1)
    postorder(li,mid,e)
    print(li[s])
    
postorder(nums,0,len(nums)-1)