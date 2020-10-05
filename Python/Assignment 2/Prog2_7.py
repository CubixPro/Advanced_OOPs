class Smooth:
    def getArea(self):
        print("Not Available at this level")
class NonSmooth:
    def getArea(self):
        print("Not Available at this level")
class TwoShape:
    def getArea(self):
        print("Not Available at this level")
class ThreeShape:
    def getArea(self):
        print("Not Available at this level")
class cuboid(ThreeShape,NonSmooth):
    def __init__(self,l,b,h):
        self.l=l
        self.b=b
        self.h=h
    def getArea(self):
        print("Area of this cuboid is {}",2*(self.h*self.b+self.l*self.b+self.h*self.l))
class cube(ThreeShape,NonSmooth):
    def __init__(self,a):
        self.a=a
    def getArea(self):
        print("Area of this cube is {}",6*self.a*self.a)
class square(TwoShape,NonSmooth):
    def __init__(self,a):
        self.a=a
    def getArea(self):
        print("Area of this square is {}",self.a*self.a)
class rectangle(TwoShape,NonSmooth):
    def __init__(self,l,b):
        self.l=l
        self.b=b
    def getArea(self):
        print("Area of this rectangle is {}",self.b*self.l)
class circle(TwoShape,Smooth):
    def __init__(self,r):
        self.r=r
    def getArea(self):
        print("Area of this circle is {}",self.r*self.r*3.1415)
class cylinder(ThreeShape,Smooth):
    def __init__(self,r,h):
        self.r,self.h=r,h
    def getArea(self):
        print("Area of this cylinder is {}",2*self.r*self.h*3.1415+2*3.1415*self.r*self.r)


cube1 = cube(5)
cube1.getArea()

cuboid1 = cuboid(5,6,7)
cuboid1.getArea()

square1 = square(5)
cuboid1.getArea()

rectangle1 = rectangle(5,6)
rectangle1.getArea()

circle1 = circle(5)
circle1.getArea()

cylinder1 = cylinder(5,6)
cylinder1.getArea()
