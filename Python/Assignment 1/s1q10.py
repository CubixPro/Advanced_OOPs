if __name__ == "__main__":
    
    
    #Printing odd squares upto 10000
    
    answer = list(map( lambda x:x**2 , filter(lambda y:y%2==1,range(100))))
    print("Odd squares of numbers upto 100: ")
    print(answer)
