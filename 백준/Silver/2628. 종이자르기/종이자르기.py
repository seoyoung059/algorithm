w, h = map(int, input().split())
cut=int(input())

garo = [0,w]
sero = [0,h]

for i in range(cut):
    m, n = map(int, input().split())
    if m == 0:
        sero.append(n)
    else:
        garo.append(n)
        
garo.sort()
sero.sort()

w_max=0
h_max=0

for i in range(len(garo)-1):
    if w_max<garo[i+1]-garo[i]:
        w_max=garo[i+1]-garo[i]

for i in range(len(sero)-1):
    if h_max<sero[i+1]-sero[i]:
        h_max=sero[i+1]-sero[i]

print(w_max*h_max)