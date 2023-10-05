# 럭키 스트레이트

s = input()
l = len(s)

left = int(s[:l//2])
right = int(s[l//2:])

sum_l=0
sum_r=0

for i in range(l//2):
    sum_l+=left%10
    sum_r+=right%10

    left//=10
    right//=10

if sum_l==sum_r:
    print("LUCKY")
else:
    print("READY")