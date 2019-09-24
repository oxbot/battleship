# Variables and Types

mystring = "hello";
myfloat = 10.0 * 2 * 3.1415 * 2.00000000001
myfloat = myfloat / 3.1415
myfloat = myfloat / 4.00000000001
myint = 20

# testing code
if mystring == "hello":
    print( "String: %s" % mystring )
if isinstance(myfloat, float) and myfloat == 10.0:
    print( "Float: %d" % myfloat )
if isinstance(myint, int) and myint == 20:
    print( "Integer: %d" % myint )


