def solution(n, words):
    answer = [0,0]

    used_words = {}
    prev_letter=None
    for i in range(len(words)):
        w = words[i]
        if prev_letter!=None:
            if prev_letter != w[0]:
                answer = [i%n+1, (i)//n+1]  
                break
        if w in used_words.keys():
            answer = [i%n+1, i//n+1]
            break
        else:
            used_words[w] = 1
            prev_letter = w[-1]
        
            

    return answer