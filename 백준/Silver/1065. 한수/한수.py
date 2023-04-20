n=int(input())
count=0
for i in range(1,n+1):
    if i < 100:
        count+=1
    else:
        answer=True
        str_i=str(i)
        gap=int(str_i[1])-int(str_i[0])
        for j in range(len(str_i)-1):
            if int(str_i[j+1])-int(str_i[j])!=gap:
                answer=False
        if answer:
            count+=1
print(count)