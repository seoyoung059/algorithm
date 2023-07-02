n_a, n_b = map(int,input().split())
a=list(map(int,input().split()))
b =list(map(int,input().split()))

a.sort()
b.sort()
# print(a,b)

idx_a=0
idx_b=0
ans=0
while idx_a < n_a and idx_b < n_b:
    if a[idx_a] < b[idx_b]:
        idx_a+=1
    elif a[idx_a] > b[idx_b]:
        idx_b+=1
    else:
        ans+=1
        idx_a+=1
        idx_b+=1
        
print(n_a+n_b-2*ans)