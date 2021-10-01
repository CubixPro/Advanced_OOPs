class MyString:
    def __init__(self,s):
        self.str=s
    def __len__(self):
        words=list(self.str.split())
      
        

myString = MyString('Hello i am 42 years old')
print("Length of '{0}' : {1}".format(myString.str,len(myString)))

myString = MyString('Helloiam42yearsold')
print("Length of '{0}' : {1}".format(myString.str,len(myString)))                
