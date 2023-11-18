n = int(input())
arr = []

arr.append(int(input()))
for i in range(n-1):
    tmp = int(input())

    for j in range(len(arr)):
        if tmp < arr[j]:
            arr.insert(j,tmp)
            break
        if j==len(arr)-1:
            arr.insert(j+1, tmp)

for a in arr:
    print(a)