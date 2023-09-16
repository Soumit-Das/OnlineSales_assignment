import pytest

def func(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
        for i in range(1,n-9):
            out *= i
    else:
        lim = n - 19
        out = lim * lim
        out = out - lim
        out = out / 2
    return out


def testOne_func():
    assert func(4) == 16

def testTwo_func():
    assert func(15) == 120

def testThree_func():
    assert func(25) == 15