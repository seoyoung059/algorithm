num = input()
ans=0
if num[:2]=='0x':
    ans=int(num,16)
elif num[0]=='0':
    ans=int(num,8)
else:
    ans=num
print(ans)