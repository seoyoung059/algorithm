# 안테나

n=int(input())
arr = list(map(int, input().split()))

arr.sort()

right = sum(arr)
left = 0
answer = 0
min_val = float('INF')
for i, a in enumerate(arr):
    if min_val > right - (n-i)*a + i*a - left:
        answer = a
        min_val = right - (n-i)*a + i*a - left
    left+=a
    right-=a
print(answer)