# 국영수

n = int(input())
arr = []

for i in range(n):
    name, k,y,s = input().split()
    arr.append([name, int(k), int(y), int(s)])

arr.sort(reverse=False, key=lambda x:[-x[1], x[2], -x[3], x[0]])

for q,w,e,r in arr:
    print(q)