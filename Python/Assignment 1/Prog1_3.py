
if __name__ == "__main__":

    odd = []
    even = []
    num = 1
    while len(odd) <= 10 or len(even) <= 10:
        if num%2 == 0:
            even.append(num)
        else:
            odd.append(num)
        num += 1
    
    print("first 10 odd numbers: " + str(odd))
    print("first 10 even numbers: " + str(even))

# couldn't figure out what maam meant by "compress"
    
