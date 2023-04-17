import numpy as np
import numpy.polynomial.polynomial as polynomial
import matplotlib.pyplot as plt
from numpy.linalg import norm
import foo, os

g = lambda x: np.exp(-0.1*x)*np.cos(x)
x = np.linspace(0, 10, 100)
y = g(x)
h = 10**-6
deriv = lambda f,x: (f(x+h)-f(x))/h


def uppgift2():
    print("a)" , str(np.pi), "\nb)" , str(np.sqrt(3)) , "\nc)" , str(np.emath.sqrt(-3)) , "\nd)", str(np.sqrt(1j)),  "\ne)", np.exp(np.pi*1j))

def uppgift3():
    z = 1j
    print(np.absolute(z), np.angle(z))

def uppgift4():
    a = 3 + 2j
    b = 5 - 1j
    x = a * b
    print(x)

def uppgift5():
    print('g(0) är', g(0))
    print('g(2) är', g(2))

def uppgift6():
    print('x[0] är', x[0])
    print('x[26] är', x[26])
    print('x[99] är', x[99])
    print(len(x))
    print('y[26] är', y[26])
    print('g(x[26]) är', g(x[26]))
    plt.title("Uppgift 6")
    plt.plot(y)
    plt.show()

def uppgift7():
    print(deriv(np.sin, 0)- np.cos(0))
        
def uppgift8():
    plt.plot(y, color = 'green')
    plt.plot(deriv(g,x), color = 'red')
    plt.legend(['f(x)',"f'(x)"])
    plt.savefig('funktionsbild.png')
    plt.show()

def uppgift9():
    h1 = lambda x: np.exp(-0.1*x)*np.cos(x)         - 0.1*np.exp(-0.1*x)*np.sin(x)      #Bent
    h2 = lambda x: -0.1*np.exp(-0.1*x)*np.cos(x)    - np.exp(-0.1*x)*np.sin(x)          #Alva
    h3 = lambda x: -0.1*np.exp(-0.1*x)*np.cos(x)    - 0.1*np.exp(-0.1*x)*np.sin(x)      #Kit
    y0 = deriv(g,x)
    print(norm(h1(x)-y0))
    print(norm(h2(x)-y0))
    print(norm(h3(x)-y0))
    
def uppgift10():
    a = np.eye(5)*9
    b = np.ones((5,2))*5
    M1 = np.hstack([a,b])
    print(a)
    print(b)
    print(M1)
    # M2 = np.hstack([np.eye(4)*7,np.ones((4,3))*6])
    # print('M1 =\n',M1)
    # print('M2 =\n',M2)


def uppgift11():
    a = np.array([[-8,4,-8],[6,-6,3],[9,6,-3]])
    b = np.array([[8],[30],[-45]])
    x = np.linalg.solve(a,b)
    print('A =\n',a)
    print('X =\n', x)
    print('B =\n',b)
    
def uppgift12():
    a = np.array([[1,1,-1],[2,1,1],[4,3,-1]])
    b = np.array([[2],[3],[4]]) 
    x = np.linalg.det(a)
    print(x)
    try:
        x2 = np.linalg.solve(a,b)
        print(x2)
    except:
        print("Funktionen saknade lösning")

def uppgift13():
    s = int(input('Roten ur: '))
    x = s/2
    for i in range(10):
        print(str(i+1) + ": " + str(x))
        x = (x+(s/x))/2

    
def uppgift14():
    s = int(input('Roten ur: '))
    x0 = 0
    x = s/2
    i = 0
    while np.absolute(x - x0) > 1e-6:
        i+=1
        print(str(i+1) + ": " + str(x))
        x0 = x
        x = (x+(s/x))/2

if __name__ == "__main__":
    while True:
        os.system('cls')
        inpt = input("Skriv in nummret på uppgiften du vill köra (mellan 2 och 14):\n")
        try:
            print('###### Uppgift ' + inpt + ' ######')
            k = globals()['uppgift' + inpt]()
            input()
        except:
            print('Skriv in ett korrekt nummer')
            input()