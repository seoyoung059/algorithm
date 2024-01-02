def available(skill, tree):
    arr = [-1] * len(skill)
    for i, s in enumerate(skill):
        for j, t in enumerate(tree):
            if t==s:
                if i==0 or -1<arr[i-1]<j:
                    arr[i]=j
                else:
                    return False
    return True

def solution(skill, skill_trees):
    answer = 0
    s_num = len(skill)
    for tree in skill_trees:
        if available(skill, tree):
            answer+=1
        
    return answer