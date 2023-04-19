n=int(input())
array=[]

for i in range(n):
    new=int(input())
    length=len(array)
    if len(array)==0:
        array.append(new)
    else:
        for j in range(length):
            if array[j] > new:
                array.insert(j,new)
                break
            else:
                if j==length-1:
                  array.insert(j+1,new)
            
for i in array:
    print(i)