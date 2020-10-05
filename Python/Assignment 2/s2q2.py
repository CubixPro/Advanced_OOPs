# Function to get the next n
# Fibonacci numbers

def next(n):
    fn   = 0
    fn_1 = 1

    while (n > 0):
        yield fn

        tmp = fn_1
        fn_1 = fn + fn_1
        fn = tmp
        
        n -= 1

# print the next 7 
# fibonacci numbers
for i in next(7) :
    print(i)