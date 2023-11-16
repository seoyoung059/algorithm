n = int(input())
arr = list(map(int, input().split()))

cnt = 0

for i in arr:
    tmp = True
    if i==1:
        tmp = False
    for j in range(2, i):
        if i % j ==0:
            tmp = False
            break
    if tmp:
        cnt += 1
print(cnt)