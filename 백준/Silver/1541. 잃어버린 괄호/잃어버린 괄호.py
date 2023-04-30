import sys
input=sys.stdin.readline

string=input().rstrip()
curr=0
input_val=[]
for i in range(len(string)):
    if string[i]=='-' or string[i]=='+':
        input_val.append(int(string[curr:i]))
        input_val.append(string[i])
        curr=i+1
    elif i==len(string)-1:
        input_val.append(int(string[curr:i+1]))
        
ans=input_val[0]
minus=False
for i in input_val[1:]:
    if i=='-':
        minus=True
    elif i=='+':
        continue
    elif minus:
        ans-=i
    else:
        ans+=i
print(ans)