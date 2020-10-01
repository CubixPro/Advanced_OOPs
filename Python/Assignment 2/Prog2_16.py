# Calculating Minimum Edit Distance
def calcMED(str1, str2):
    m = len(str1)
    n = len(str2)

    # Creating a 2D array
    dp = [[0 for x in range(n+1)] for x in range(m+1)]


    for i in range(m+1):
        for j in range(n+1):
            # If no character from string 1 is taken
            # after j operations on string 2
            if i == 0 :
                dp[i][j] = j
            # if no character from string 2 is taken
            # after i operations on string 1
            elif j == 0:
                dp[i][j] = i
            # if the character are same
            elif str1[i-1] == str2[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else :
                # If they are different
                dp[i][j] = 1 + min(dp[i][j-1] # deletion in str1
                            , dp[i-1][j-1],   # substitution
                             dp[i-1][j])      # insertion in str1

    cnt = dp[m][n]

    backtrace = ""

    while m > 0 and n > 0 :
        # if there's no operation
        if dp[m][n] == 0 :
            backtrace += "s"
            m -= 1
            n -= 1
        # if the characters are same
        elif dp[m-1][n-1] == dp[m][n] and str1[m-1] == str2[n-1]:
            backtrace += "s"
            m -= 1
            n -= 1
        # if there's deletion of a character from str1
        elif dp[m-1][n] + 1 == dp[m][n]:
            backtrace += "D"
            m -= 1
        # if there's insertion of a character in str1
        elif dp[m][n-1] + 1 == dp[m][n]:
            backtrace += "I"
            n -= 1
        # if there's substitution
        else :
            backtrace += "S"
            m -= 1
            n -= 1
    
    # reverse the backtrace
    backtrace = backtrace[::-1]
    return cnt, backtrace

str1 = input("1st string = ")
str2 = input("2nd string = ")
cnt, backtrace = calcMED(str1, str2)
print(cnt, backtrace)