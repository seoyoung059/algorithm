w = input()
s=[]
ppap=['P','P','A','P']
for i in range(len(w)):
    s.append(w[i])
    if s[-4:]==ppap:
        s.pop()
        s.pop()
        s.pop()

if s == ['P'] or s==ppap:
    print('PPAP')
else:
    print('NP')
