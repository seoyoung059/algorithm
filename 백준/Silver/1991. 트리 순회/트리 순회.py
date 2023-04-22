n=int(input())
nodes=[]
for i in range(n):
    p,l,r = map(str,input().split())
    if l == '.':
        l=None
    if r == '.':
        r=None
    nodes.append([p,l,r])

class Node:
    def __init__(self, value):
        self.value = value
        self.parent = None
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self,root):
        self.root = root
        self.length = 1
    
    def _preorder(self,curr):
        ans=[curr.value]
        if curr.left!=None:
            ans=ans+self._preorder(curr.left)
        if curr.right!=None:
            ans=ans+self._preorder(curr.right)
        return ans

    def preorder(self):
        ans = self._preorder(self.root)
        print("".join(ans))

    def _inorder(self,curr):
        ans=[]
        if curr.left!=None:
            ans=ans+self._inorder(curr.left)
        ans=ans+[curr.value]
        if curr.right!=None:
            ans=ans+self._inorder(curr.right)
        return ans

    def inorder(self):
        ans = self._inorder(self.root)
        print("".join(ans))
        
    def _postorder(self,curr):
        ans=[]
        if curr.left!=None:
            ans=ans+self._postorder(curr.left)
        if curr.right!=None:
            ans=ans+self._postorder(curr.right)
        ans=ans+[curr.value]
        return ans

    def postorder(self):
        ans = self._postorder(self.root)
        print("".join(ans))
        
def makeTree(node, nodes):
    c,l,r = node
    c_node=Node(c)
    if l!=None:
      for i in nodes:
          if i[0]==l:
             l_node=makeTree(i,nodes)
             c_node.left=l_node
             l_node.parent=c_node
    if r!=None:
       for i in nodes:
          if i[0]==r:
             r_node=makeTree(i,nodes)
             c_node.right=r_node
             r_node.parent=c_node
    return c_node
            
root = makeTree(nodes[0],nodes)
tree=BinaryTree(root)
tree.preorder()
tree.inorder()
tree.postorder()