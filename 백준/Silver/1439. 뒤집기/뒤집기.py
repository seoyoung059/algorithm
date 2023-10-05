# 뒤집기

s = input()

cnt=[0,0]
for i in range(len(s)):
    if s[i-1]!=s[i]:
        cnt[int(s[i])]+=1

print(min(cnt))