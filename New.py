#!/usr/bin/python
# datademo.py 
# a simple script to pull some data from MySQL

import MySQLdb

db = MySQLdb.connect(host="localhost", user="root", passwd="ms084092", db="sensorData")

#create a cursor for the select
cur = db.cursor()

#execute an sql query
cur.execute("SELECT DateTime, Temperature, Humidity FROM sensorData.TempHumid")

print ("%s\t\t%s\t%s\t" %("DateTime","Temperature","Humidity"))

##Iterate 
for row in cur.fetchall() :
      #data from rows
      dateTime = str(row[0])
      temperature = str(row[1])
      humidity = str(row[2])

      #print
      print ("%s\t%s\t\t%s\t" %(dateTime,temperature,humidity))

# close the cursor
cur.close()

# close the connection
db.close ()
DateTime		Temperature	Humidity	
2018-02-14 14:18:29	18		19	
2018-02-14 14:18:45	18		19	
2018-02-14 14:18:50	21		31	
2018-02-14 14:18:55	18		19	
