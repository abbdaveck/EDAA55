import numpy as np
import matplotlib.pyplot as plt
import numpy.polynomial.polynomial as polynomial
import scipy.optimize as optimize
import foo, os
import mandelbrot as mandelbrot



def uppgift1():
    p1 = [1, 19, 37, -1299, -9558, -19440]
    r1 = np.roots(p1)
    r2 = polynomial.Polynomial(p1).roots()
    y1 = polynomial.polyval(r2, p1)
    y2 = polynomial.polyval((1,2,3), p1)

    print('Rötter:\n', r1)
    print('Y-värden med rötter\n', y1)
    print('Y-värden med själv valda x-värden\n', y2)

def uppgift2():
    r1 = (-4, -3, 4, 8)                 #Rötter som skickas in
    p1 = polynomial.polyfromroots(r1)   #Polynom
    r2 = polynomial.Polynomial(p1).roots()
    print('Rötterna vi skrev in:\n', r1)
    print('Polynomet som räknades ut:\n', p1)
    print('Dubbelkollar att rötterna är samma:\n', r2)
    
    x = np.linspace(-50,50, 10000)
    y = np.polyval(p1, x)
    plt.plot(x, y, 'k')
    plt.grid()
    plt.ylim(-10, 10)
    plt.xlim(-2.5, 2.5)
    plt.show()

def uppgift3():
    f = lambda t: 4*np.sin(3*t)+3*t**2
    t =  np.linspace(1,2.6)
    y = f(t)
    integral = np.trapz(f(t), t)
    print(integral)
    plt.plot(t,y, 'k')
    plt.show()

def uppgift4():
    g = lambda x: (np.cos(np.exp(x)))/(1-x)
    x = np.linspace(2,3)
    y = g(x)
    min = optimize.minimize(g, 2)       #Hittar minimipunkten där 2 är min första gissning
    xmin = min.x[0]
    ymin = min.fun
    print('Koordinater för minimipunkt: x:', xmin , 'y:', ymin)
    
    plt.plot(x,y, 'k')
    plt.plot(xmin, ymin, 'ro')   #min.x är x koordinaten för minimipunkten och min.fun är y
    plt.xlim(1.5,3.5)
    plt.grid()
    plt.show()

def uppgift5():
    h = lambda x: 4*x**2+2*x-np.exp(-x**2)
    x = np.linspace(-1.5,1.5)
    y = h(x)
    plt.plot(x,y, 'k')

    min = optimize.minimize(h,0)
    xmin = min.x[0]
    ymin = min.fun
    plt.plot(xmin, ymin, 'ro')
    print('Koordinater för minimipunkt:\nx:', xmin , 'y:', ymin)


    guesses = [-0.5,0.5]
    r1 = optimize.fsolve(h,guesses)
    yzero1 = r1[0]
    yzero2 = r1[1]
    plt.plot(yzero1, 0, 'ro')
    plt.plot(yzero2, 0, 'ro')
    print('Nollställen:\n', yzero1, ',', yzero2)
    plt.grid()
    plt.show()

def uppgift6():
    a = np.eye(10)*2
    b = np.eye(10, k = 1)* 4
    c = np.eye(10, k = -1) * 4
    res = np.add(np.add(a, b), c)
    det = np.linalg.det(res)
    print(res)
    print(det)

def uppgift7():
    m = mandelbrot.complexmat(5, -2+1j, 1 - 1j)
    print(m)

def uppgift8():
    z = c = 0.1j
    for i in range(8):
        z = z*z + c
    print(z)

def uppgift9():
    print(mandelbrot.converge(0.5+0.5j))
    print(mandelbrot.converge(1.1))

def uppgift10():
    m = mandelbrot.complexmat(5, -2+1j, 1 - 1j)
    vConverge = np.vectorize(mandelbrot.converge)
    v = vConverge(m)
    print(v)
    plt.imshow(v, aspect=2/3)
    plt.show()    
    # (2,1), (2,2), (2,3), (3,2), (3,3), (4,2)

def uppgift11():
    m = mandelbrot.complexmat(200, -2+1j, 1 - 1j)
    vConverge = np.vectorize(mandelbrot.converge)
    v = vConverge(m)
    plt.imshow(v, aspect=2/3)
    plt.show()    


def uppgift12():
    m = mandelbrot.complexmat(1000, -2+1j, 1 - 1j)
    # m = mandelbrot.complexmat(1000, -1.4+0.48j, -1.1+0.24j)
    # m = mandelbrot.complexmat(1000, -0.7+0.7j, -0.5+0.6j)
    # m = mandelbrot.complexmat(1000, -1.8+0.03j, -1.5-0.03j)
    # m = mandelbrot.complexmat(1000, -0.18-1.02j, -0.14-1.05j)
    vConverge = np.vectorize(mandelbrot.converge2)
    v = vConverge(m)
    plt.imshow(v, aspect=2/3,  cmap = plt.get_cmap('inferno'))
    # plt.savefig("mandelbrotfig1.png")
    plt.show()


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