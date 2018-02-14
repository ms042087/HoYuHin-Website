import serial
import time
import datetime
import MySQLdb

ser=serial.Serial("/dev/ttyUSB2",9600)
ser.baudrate=9600

db = MySQLdb.connect("localhost", "monitor", "password", "temps")
cur = db.cursor()

while True:
    line = ser.readline().strip();
    values = line.decode('ascii').split(',')
    temperature, humidity = [int(s) for s in values]

    print("temperature = ",float(temperature),"\nhumidity = ",float(humidity),"\n")

    sql = "INSERT INTO Monitoring.TempHumid ('ComputerTime', 'temperature', 'humidity' VALUES (CURDATE(), %s, %s)"
    data = (currenttime, temperature, humidity)
    cur.execute(sql,(data))
    db.commit()
db.close()
print('end')
    
