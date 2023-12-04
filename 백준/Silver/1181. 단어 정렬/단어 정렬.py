# 단어 정렬

n = int(input())
words = [[] for i in range(51)]

for i in range(n):
    word = input()
    l = len(word)
    if word not in words[l]:
        words[l].append(word)

for i in range(51):
    if words[i]:
        words[i].sort()
        for w in words[i]:
            print(w)

