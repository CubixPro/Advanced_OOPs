class MyString:
    def __init__(self,s):
        self.str=s
    def __len__(self):
        words=list(self.str.split())
        if len(words)==1:
            length=0
            for ch in words[0]:
                length+=1
            return length
        else:
            length=0
            count=len(words)
            for ch in words[count-1]:
                length+=1
            if count>=2:
                for ch in words[count-2]:
                    length+=1
            if count>=3:
                for ch in words[count-3]:
                    length+=1
            length+=count-1
            return length

myString = MyString('India is now on 210th day of quarantine')
print("Length of '{0}' : {1}".format(myString.str,len(myString)))

myString = MyString('But also we have to submit inhuman task')
print("Length of '{0}' : {1}".format(myString.str,len(myString)))                
