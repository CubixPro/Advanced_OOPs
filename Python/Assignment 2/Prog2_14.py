import profile

# Function to check is a
# triplet is Pythagorian Triplet
def isPythagorian(a, b, c):
    if a^2 + b^2 == c^2 :
        return True
    return False

# Function to iterate over 
# values of a, b & c
def findTriplets():
    for i in range(100):
        for j in range(i+1):
            for k in range(i+1):
                if isPythagorian(i, j, k):
                    print(i, j, k)

# Python profiler
profile.run('findTriplets()')
