n=int(input())

def pattern(x, y, N,arr):
    if x//(N/3)==1 and y//(N/3)==1:
        return ' '
    if N > 3:
        if(len(arr)>x%(N//3)):
            if(arr[x%(N//3)][y%(N//3)]):
                return arr[x%(N//3)][y%(N//3)]
        return pattern(x%(N//3), y%(N//3), N//3,arr)
    return '*'

    
arr=[]
for i in range(n):
    str=''
    for j in range(n):
        str+=pattern(i,j,n,arr)
    arr.append(str)
    print(arr[i])