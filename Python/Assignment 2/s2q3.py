# Generate GP sequence as 
# long as a term is < 10^5
def GP(a, q):
    while a < 100000 :
        yield a
        a = a*q

    # Print when the sequence
    # has completed execution
    print("Sequence complete")

# Take values of a & q 
# as input
a = int(input("a = "))
q = int(input("q = "))

# Print the sequence
for i in GP(a, q):
    print(i, end=", ")

print("\b\b\n")