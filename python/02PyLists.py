#Lists

mylist = []
mylist.append(1)
mylist.append(2)
mylist.append(3)
print(mylist[0]) # prints 1
print(mylist[1]) # prints 2
print(mylist[2]) # prints 3

print( "\n" )
# prints out 1,2,3
for x in mylist:
    print( x );


print( "\n" )
numbers = [5,4,3,2,1]
strings = ["yep", "nope", "sure", "compile me"]
names = ["John", "Eric", "Jessica"]

# write your code here
second_name = names[1]


# this code should write out the filled arrays and the second name in the names list (Eric).
print(numbers)
print(strings)
print(names)
print("The second name on the names list is %s" % second_name)