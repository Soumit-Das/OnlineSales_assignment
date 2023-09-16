
# Testcases

# testcase 1 : input = 4  output = 16
# testcase 2 : input = 15  output = 120
# testcase 3 : input = 25  output = 15


# Code with Bug

# def compute(n):
#     if n < 10:
#         out = n ** 2
#     elif n < 20:
#         out = 1
#         for i in range(1,n-10):
#             out *= i
#     else:
#         lim = n - 20
#         out = lim * lim
#         out = out - lim
#         out = out / 2
#     print(out)

# n = int(input("Enter an integer: "))
# compute(n)   


# Debugging details
# In testcase 2 with 15 as input we are getting 24 as output , so in order to get output 120 we need to change the n - 10 to n - 9
# In testcase 3 with 25 as input we are getting 10 as output , so in order to get output 15 we need to change the n - 20 to n - 19



# Debugged code

def compute(n):
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
    print(out)

n = int(input("Enter an integer: "))
compute(n)                    



