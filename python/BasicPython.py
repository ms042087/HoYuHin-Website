# -*- coding: utf-8 -*-
"""
Created on Sun Feb 18 22:34:07 2018

@author: Ho Yu Hin
"""
#Basic input outpout if else
x = int(input("Please enter an integer: "))
if x<0:
    print('negative')
elif x==0:
    print('zero')
else:
    print('positive')
    
#Basic array manipulation
words = ['abc','2','23423423dffd']
for w in words:
    print('The length of %s is %s' % (w,len(w)))
    
seasons = ['Spring', 'Summer', 'Fall', 'Winter']
print(list(enumerate(seasons, start=1)))

#Class operation
class Student:
    def __init__(self,name,grade,age):
        self.name = name
        self.grade = grade
        self.age = age
    def __repr__(self):
        return repr((self.name,self.grade,self.age))

student=[
Student('A1','A',19),
Student('A2','C',15),
Student('A3','B',32),
]

print(student)

#Sorting
student_sorted_age = sorted(student, key=lambda student: student.age, reverse=True)
print(student_sorted_age)
student_sorted_grade = sorted(student, key=lambda student: student.grade)
print(student_sorted_grade)

#try and file operation
try:
    file = open('test.txt', 'r+')
except Exception as e:
    print('no such file exists')
    response = raw_input('Create a new file')
    if response == 'y':
        file = open('test.txt','w')
        print('created')
    else:
        pass
else:
    file.write('line1')
    file.close()