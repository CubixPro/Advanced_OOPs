class student:
    # ds for Data Structure marks
    # oops for Object Oriented Programming S
    # ca for Computer Architecture
    def __init__(self, ds, oops, ca) :
        self.ds = ds
        self.oops = oops
        self.ca = ca

    def sum(self):
        return self.ds + self.ca + self.oops
    
n = int(input("Enter number of students :: "))
print("Enter ds oops ca below for", n, "students")

studlist = []

for i in range(n):
    stud = student(0, 0, 0)
    # Get the marks for a student
    stud.ds, stud.oops, stud.ca = [ int(x) for x in input().split(" ")]
    studlist.append(stud)

# Decorating the object student with
# the sum of the marks
decStudList = []
for stud in studlist :
    decStudList.append((stud, stud.sum()))

# Sorting on the basis of sum of the marks
decStudList.sort(key=lambda tupstud: tupstud[1])

# UnDecorating the list to get the original list
studlist = []

for tupstud in decStudList:
    studlist.append(tupstud[0])

# Printing the sorted list
for stud in studlist:
    print(stud.ds, stud.oops, stud.ca, stud.sum())