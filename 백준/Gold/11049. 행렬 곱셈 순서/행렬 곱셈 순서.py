import sys
input = sys.stdin.readline

def solve(s,e):
    if s==e:
        return 0
    elif arr[s][e]!=-1:
        return arr[s][e]
    else:
        result = float('INF')
        for m in range(s,e):
            result = min(result, solve(s,m)+solve(m+1,e)+matrix[s][0]*matrix[m][1]*matrix[e][1])
        arr[s][e]=result
        return result

n=int(input())
matrix=[]
for _ in range(n):
    matrix.append(list(map(int,input().split())))
arr=[[-1]*n for _ in range(n)]
print(solve(0,n-1))