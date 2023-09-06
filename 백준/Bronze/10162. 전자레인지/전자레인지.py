a = 5*60
b = 60
c = 10

t = int(input())
def sol(t):
    ans = [0]*3
    if t % c != 0:
        print(-1)
        return
    while t > 0:
        if t >= a:
            ans[0]+=t//a
            t = t%a
        elif t >= b:
            ans[1]+=t//b
            t = t%b
        else:
            ans[2]+=t//c
            t = t%c
    for cnt in ans:
        print(cnt, end=" ")
    return

sol(t)