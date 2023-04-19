a=[]
for i in range(9):
    a.append(int(input()))

bye=False
for i in range(9):
    if bye: break
    for j in range(i):
        if bye:break
        if sum(a)-a[i]-a[j]==100:
            a.remove(a[i])
            a.remove(a[j])
            bye=True
       

a.sort()

for i in range(7):
    print(a[i])