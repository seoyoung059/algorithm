a=int(input())
b=int(input())

ab=a*b
while b > 0:
    print(a*(b % 10))
    b=b//10
print(ab)