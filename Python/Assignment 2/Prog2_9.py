class Person:
    def __init__(self):
        self.__name=''
        self.__age=-1
    @property
    def name(self):
        return self.__name
    @property
    def age(self):
        return self.__age
    @name.setter
    def name(self, value):
        self.__name=value
    @age.setter
    def age(self,value):
        self.__age=value
    @name.deleter
    def name(self):
        print('Deleting name property')
        del self.__name
    @age.deleter
    def age(self):
        print('Deleting Age property')
        del self.__age

p=Person()
p.name='Geek God'
print("Name: ",p.name)
p.age=18
print("Age: ",p.age)
del p.name
del p.age