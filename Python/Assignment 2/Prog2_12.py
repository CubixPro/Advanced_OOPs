# To flatten the dict, we've to 
# recursively traverse and check 
# if there's a key : dict mapping
# if so, fix that
# if not return a prefix : d

def flatten(d, prefix=""):
    if isinstance(d, dict):
        newDict = {}
        for k, v in d.items():
            getDict = flatten(v, prefix+"_"+k if prefix != "" else k)
            for kk, vv in getDict.items():
                newDict[kk] = vv
        return newDict
    else :
        return {prefix: d}

# example dict
mydict = {
    "fullname" : "Alessandra",
    "age" : 41,
    "phone_numbers" : ["+447421234", "+9910938383"],
    "residence" : {
        "address" : "Alexindra Road",
        "second_line" : "Nothing Special",
        "zip" : "YOHERE",
        "city" : "London",
        "country" : "UK"
    }
}

# Flatten the above dict
newdict = flatten(mydict)

# Print the flattened dict
print(newdict)
