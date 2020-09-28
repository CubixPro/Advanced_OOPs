

def printPermutation(word, start, end):
    if start == end:
        print(str(word))
    
    else:
        for i in range(start, end+1):
            word[start], word[i] = word[i], word[start]
            printPermutation(word, start+1, end)
            word[start], word[i] = word[i], word[start] #to revert the previous change



if __name__ == "__main__":
    word = "ABCD"
    newWord = list(word) # just because strings are immutable in python
    n = len(word)
    printPermutation(newWord, 0, n-1)