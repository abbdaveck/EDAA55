import numpy as np

def complexmat(N, z0, z1):
    # skapar en N x N-matris med komplexa tal a + bi
    # där re(z0) <= a <= re(z1) och im(z1) <= b <= im(z0)
    # (jämnt fördelade i matrisen)
 
    xs = np.linspace(z0.real, z1.real, num = N)  # realdelar
    ys = np.linspace(z0.imag, z1.imag, num = N)  # imaginärdelar
 
    # skapa två matriser med real- respektive imaginärdelar
    [X, Y] = np.meshgrid(xs, ys)
 
    # matrisen X innehåller resultatets realdelar
    # matrisen Y innehåller resultatets imaginärdelar
    # arr = np.vstack([X.ravel(), Y.ravel()])
 
    return X + 1j*Y    # <<< denna rad behöver utökas
# end

def converge(c):
    z = c
    i = 0
    while i<100 and np.abs(z) <= 2:
        i += 1
        z = z*z

    return i

def converge2(c):
    z = c
    i = 0
    while i<100 and np.abs(z) <= 2:
        i += 1
        z = z*z + c

    return i