import numpy as np
import matplotlib.pyplot as plt
import numpy.polynomial.polynomial as polynomial
from scipy.integrate import solve_ivp #ivp = initial value problem
from scipy.optimize import curve_fit
import requests, os

def uppgift1():
    def y(t, y):                        #Differentialekvationen 
        return 8*t + 1.3**t - 6*y**2

    y0 = np.array([4])                  #Startvillkoret 
    t_span = [3, 8]                     #Intervallet jag vill integrera över
    sol = solve_ivp(y, t_span, y0)      #Utför integrationen
    tVec = sol.t                        #Vektor med t värden som jag ska plotta
    yVec = sol.y[0]                     #Vektor med y värden

    tNum = 8
    for i in range(len(tVec)):
        if (np.abs(tVec[i] - tNum)) < 1e-1:     #Finns nummret eller ett nummer nära nog i vektorn sparar jag indexet
            index = i
            break
    yNum = yVec[index]                  #Hittar y-koordinaten i vektorn med y värden
    print(yNum)

    plt.plot(tVec, yVec, 'b-', label='y(t)')
    plt.plot(tNum, yNum, 'ro')
    plt.xlabel('t')
    plt.ylabel('y(t)')
    plt.show()

    # Om du skriver y[8] i Python (där y är vektorn av y-värden från den numeriska lösningen) får du fel värde. Varför då?
    # svar: För att indexeringen på vektorn inte överensstämmer med funktionen, dvs att på nionde plats kommer vi inte hitta 
    # värdet på y(8)

def uppgift2():  
    def func(x, a, b, c, d, e, f):      #Skapar ett generiskt femtegradspolynom
        return a*x**5 + b*x**4 + c*x**3 + d*x**2 + e*x + f

    x = np.array([ 0.000, 1.000, 2.000, 3.000, 4.000, 5.000 ])
    y = np.array([ 3.749, 4.689, 6.273, 5.897, 6.381, 7.003 ])
    plt.plot(x, y, 'r+', label='Rå-data')                    #Plottar punkterna

    popt, pcov = curve_fit(func, x, y)      #Hittar ett polynom som matchar med koordinaterna jag skickar in
    print("Polynom:")                       #Skriver ut polynomet på ett läsbart sätt
    print(str(round(popt[0], 3)) + '*x^5 + ' + str(round(popt[1], 3)) + '*x^4 ' + str(round(popt[2], 3)) + '*x^3 + ' + str(round(popt[3], 3)) + '*x^2 ' + str(round(popt[4], 3)) + '*x + ' + str(round(popt[5], 3)))
    xPol = np.linspace(0, 5, 100)
    yPol = np.polyval(popt, xPol)
    plt.plot(xPol, yPol, 'k', label='Polynom')

    yFit = np.polyval(np.polyfit(x, y, 1), xPol)
    plt.plot(xPol, yFit, 'b', label='Minsta kvadrat-metoden')


    plt.grid()
    plt.axis([0, 5, 3, 8])
    plt.legend()
    plt.show()

def uppgift3():
    x = [0.10, 0.20, 0.30, 0.40, 0.50, 0.60, 0.70, 0.80, 0.90, 1.00, 1.10, 1.20, 1.30, 1.40, 1.50]
    y = [1.52,1.51,1.87,1.81,2.03,3.05,3.53,4.45,3.55,3.91,5.53,6.74,8.57,7.01,8.85]
    plt.plot(x,y, 'ro')

    p = np.polyfit(x, np.log(y), 1)     #Tar den naturliga logaritmen av alla tal i vektorn och sen uppskattar jag en linje som matchar
    a = np.exp(p[1])                    #de värderna. Tar sedan e upphöjt till riktningskoffecienten och det blir konstanten
    b = p[0]
    xFun = np.linspace(np.min(x), np.max(x))
    yFun = a * np.exp(b * xFun)         #Skapar funktionen som baserat på värderna
    print('a*b^x: ' + str(round(a, 2)) + '*' + str(round(b, 2)) + '^x')

    plt.plot(xFun, yFun, 'k', label='Uppskattad kurva')
    plt.legend()
    plt.show()

def uppgift4():
    # data = requests.get('https://cs.lth.se/edaa55/numpy/race').text
    # with open('race.txt', 'w') as f: f.write(data)

    v = np.loadtxt('Labb3/race.txt')
    t = np.linspace(0,40, v.size)
    plt.plot(t,v)
    plt.show()

def uppgift5():
    v = np.loadtxt('Labb3/race.txt')
    v = np.where(v > 80, np.roll(v, -1), v)     #Ersätter alla värden över 80 med värdet på indexet innan
    print('Maxhastighet:', np.max(v))
    t = np.linspace(0,40, v.size)
    plt.plot(t,v)
    plt.grid()
    plt.show()

def uppgift6():
    def func(x, a, b, c, d, e, f):      #Skapar ett generiskt femtegradspolynom
        return a*x**5 + b*x**4 + c*x**3 + d*x**2 + e*x + f

    v = np.loadtxt('Labb3/race.txt')
    v = np.where(v > 80, np.roll(v, -1), v)     #Ersätter alla värden över 80 med värdet på indexet innan
    t = np.linspace(0, 40, v.size)
    plt.plot(t,v)

    popt, pcov = curve_fit(func, t, v)      #Hittar ett polynom som matchar med koordinaterna jag skickar in
    xPol = np.linspace(0, 40, 100)
    yPol = np.polyval(popt, xPol)           #Skapar en vektor baserat på polynomet

    s1 = np.trapz(v, t)
    s2 = np.trapz(yPol, xPol)
    print(s1)
    print(s2)       #De är samma sträcka både med den uppskattade grafen och den faktiska mätdatan vilket tyder på att de är rimligt
    print(s1/40)    #Medelhastigheten är 58 m/s vilket jag anser också är rimligt

    plt.plot(xPol, yPol, 'k', label='Polynom')
    plt.legend()
    plt.show()

def uppgift7(): 
    # data = requests.get('https://cs.lth.se/EDAA55/numpy/const_accel').text
    # with open('const_accel.txt', 'w') as f: f.write(data)
    v = np.loadtxt('Labb3/const_accel.txt')
    t = np.linspace(0, 5, v.size)

    plt.plot(t,v)
    plt.show()

def uppgift8():
    def func(x, a, b, c, d,):      #Skapar ett generiskt tredjegradspolynom
        return a*x**3 + b*x**2 + c*x + d

    v = np.loadtxt('Labb3/const_accel.txt')
    t = np.linspace(0, 5, v.size)
    plt.plot(t,v)

    popt, pcov = curve_fit(func, t, v)      #Hittar ett polynom som matchar med koordinaterna jag skickar in
    y = popt
    dy = np.polyder(y)

    xVec = np.linspace(0, 5, 100)
    yVec = np.polyval(y, xVec)
    dyVec = np.polyval(dy, xVec)            #Tar derivatan på det uppskattade polynomet
    print(np.average(dyVec), "m/s^2")       #Genomsnittet på derivatan är den genomsnittliga hastighetsökningen
    plt.plot(xVec, yVec, 'k', label='Polynom')
    plt.plot(xVec, dyVec, 'b', label='Derivata')
    plt.legend()
    plt.grid()
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