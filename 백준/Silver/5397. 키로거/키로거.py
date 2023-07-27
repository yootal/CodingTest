class Node:
    def __init__(self,data,prev,next):
        self.data = data
        self.prev = prev
        self.next = next
        
class DList:
    def __init__(self):
        self.head = Node(None,None,None)
        self.tail = Node(None,self.head,None)
        self.head.next = self.tail
        self.size = 0
        
    def printAll(self):
        cur = self.head
        result = []
        # head부터 다음이 tail일 때 까지 result에 쌓아서 리턴
        while cur.next is not self.tail:
            cur = cur.next
            result.append(cur.data)
        return result
    
    def insert(self,cur,data):
        new_node = Node(data,None,None)
        cur_prev = cur.prev
        cur_prev.next = new_node
        cur.prev = new_node
        new_node.prev = cur_prev
        new_node.next = cur
        self.size += 1
        return cur
    
    def remove(self, cur):
        prv = cur.prev.prev
        cur.prev.prev.next = cur
        cur.prev = cur.prev.prev
        self.size -= 1
        if prv is self.head:
            return self.head.next
        else:
            return cur
        
answers=[]
for _ in range(int(input())):
    ans = DList()
    command = input().rstrip()
    cur_node = ans.head.next
    for c in command:
        if c == '<':
            if cur_node.prev == ans.head:
                continue
            else: cur_node = cur_node.prev
        elif c == '>':
            if cur_node == ans.tail:
                continue
            else:
                cur_node = cur_node.next
        elif c == '-':
            if ans.size == 0 or cur_node.prev == ans.head:
                continue
            else:
                cur_node = ans.remove(cur_node)
        else:
            cur_node = ans.insert(cur_node,c)
    print("".join(ans.printAll()))
    