
myDict = {
    "sunday" : 100,
    "monday" : 1.5,
    "tuesday" : 5,
    "wednesday" : 76,
    "thursday" : 34.6,
    "friday" : 2,
    "saturday" : 10
}


if __name__ == "__main__":

    day = str(input("Enter the day of the week: "))
    day = day.lower()
    if day in myDict.keys():
        print("OMG! You got {0}% discount!\n Happy Shopping :)".format(myDict[day]))
    else:
        print("I am not sure this day exists!:( \nTry again!!!")