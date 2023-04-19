a=int(input())
b=int(input())
c=int(input())

answer=str(a*b*c)
for i in range(10):
    print(answer.count(str(i)))