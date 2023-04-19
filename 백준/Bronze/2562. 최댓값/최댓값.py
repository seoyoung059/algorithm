max = int(input())
num=0

for i in range(8):
  a=int(input())
  if a>max:
    max=a
    num=i+1
    
print(max)
print(num+1)