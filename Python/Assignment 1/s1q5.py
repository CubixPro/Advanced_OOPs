

def matrixMultiplication(mat1, mat2):

    row1 = len(mat1)
    col1 = len(mat1[0])

    row2 = len(mat2)
    col2 = len(mat2[0])

    if col1 != row2:
        print("matrix multiplication cannot be performed")
    elif row1 == 0 or col1 == 0 or row2 == 0 or col2 == 0 :
        print("Multiplication cannot be performed! Row and Column mismatched! Bad Input!")
    else:
        
        #initializing the result matrix
        result = [[0 for i in range(col2)] for j in range(row1)]

        for i in range(row1):
            for j in range(col2):
                for k in range(row2):
                    result[i][j] += mat1[i][k] * mat2[k][j]

        for row in result:
            print(row)


if __name__ == "__main__":

    mat1 = [
        [1,2,3],
        [5,34,9],
        [-23,23,0]
    ]

    mat2 = [
        [-1,2,9],
        [-3,34,45],
        [-5,98,32],
        [67,98,23]
    ]

    matrixMultiplication(mat1, mat2)