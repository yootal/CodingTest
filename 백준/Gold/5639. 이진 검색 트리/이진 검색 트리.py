from sys import stdin,setrecursionlimit
input = stdin.readline

setrecursionlimit(10**6)

def postorder(root,end):
    if root > end:
        return
    right = end + 1
    for i in range(root+1,end+1):
        if preorder[root] < preorder[i]:
            right = i
            break
    postorder(root+1,right-1)
    postorder(right,end)
    print(preorder[root])

preorder = []
while True:
    try:
        preorder.append(int(input()))
    except:
        break
    
postorder(0,len(preorder)-1)
            
    