class Storage:
    def __init__(self,text):
        self.text=text
    def isPal(self,word):
        for idx in range(0,len(word)-1):
            if word[idx]!=word[len(word)-1-idx]:
                return False
        return True
    def getPalindromes(self):
        words=list(self.text.split())
        for word in words:
            if self.isPal(word):
                print(word,end=' ')
        print('')
    def getUniqueWords(self):
        words=set(self.text.split())
        print(words)

storage=Storage('59 question in 5 days is just inhumane! ')
storage.getPalindromes()
storage.getUniqueWords()
