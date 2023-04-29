str1=input().rstrip()
str2=input().rstrip()

n1=len(str1)
n2=len(str2)

arr = [[0]*(n1+1) for _ in range(n2+1)]
for i in range(1,n2+1):
    for j in range(1,n1+1):
        if str2[i-1]==str1[j-1]:
            arr[i][j]=arr[i-1][j-1]+1
        else:
            arr[i][j]=max(arr[i][j-1],arr[i-1][j])
            
print(arr[-1][-1])