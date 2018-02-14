import serial
import RPi.GPIO as GPIO
import time

ser=serial.Serial("/dev/ttyUSB0",9600)
ser.baudrate=9600
def blink(pin):
    GPIO.output(pin,GPIO.HIGH)
    time.sleep(1)
    GPIO.output(pin,GPIO.LOW)
    time.sleep(1)
    return
GPIO.setmode(GPIO.BOARD)
GPIO.setup(11,GPIO.OUT)
while True:
    read_ser=ser.readline()
    if read_ser[0]==104:
        humidity=ser.readline()
        print("humidity=",float(humidity))
    if read_ser[0]==116:
        temperature=ser.readline()
        print("temperature=",float(temperature))
