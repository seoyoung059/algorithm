n = int(input())
c = list(map(int, input().split()))
count=0
for i in c:
    k=True
    if i==1:
        k=False
    for j in range(2,i):
        if i % j==0:
            k=False
            break
    if k==True:
        count+=1
print(count)