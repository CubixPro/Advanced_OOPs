# Generate the first n cubes 

def getCube(n):
    for i in range(n):
        yield (i+1)*(i+1)*(i+1)

# Print the first 10 cubes
for i in getCube(10):
    print(i, end=", ")

print("\b\b")