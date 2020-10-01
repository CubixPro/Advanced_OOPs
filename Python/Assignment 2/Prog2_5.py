# class square to take a number
# in constructor and find it's
# square.  
class square:
    def __init__(self, n):
        self.n = n
    def getSquare(self):
        return self.n*self.n

# Print the square 
a = int(input("a = "))
sq = square(a)

print("Square is ::", sq.getSquare())