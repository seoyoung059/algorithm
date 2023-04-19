c = int(input())

for i in range(c):
    case = list(map(int, input().split()))
    avg = sum(case[1:])/case[0]
    good = 0.0
    for j in range(case[0]):
        if case[j+1] > avg:
            good+=1.0
    print("{:.3f}%".format(good/case[0]*100))