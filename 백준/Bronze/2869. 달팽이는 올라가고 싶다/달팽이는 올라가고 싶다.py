a, b, v = map(int, input().split())

day = 1 + (v - a) // (a-b)
if (v-a)%(a-b) > 0:
    day+=1
    
print(day)