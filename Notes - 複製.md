## Raspberry PI 3 + Arduino + MySQL (Temperature and Humidity DHT11 sensors)

###1. Update The PI to the latest version  
    sudo apt-get update && sudo apt-get upgrade
###2. Configure The PI for serial connection  
i) Preferences -> Raspberry Pi Configuration -> Interfaces -> Serial (Enabled)  
ii) Run the following commands to install pyserial:  

    sudo apt-get install python-serial
    sudo pip install pyserial

###3.  Upload the program on Arduino
i) Download dht.cpp and dht.h  
ii) Connect the Arduino to PC and configure it  
iii) Run the following code:

    #include <dht.h>  
    dht DHT;  
    #define DHT11_PIN 4
    
    void setup()  
    {  
      Serial.begin(9600); 
    }  
      
    void loop()  
    {  
      // READ DATA  
     int chk = DHT.read11(DHT11_PIN);  
      switch (chk)  
      {  
    case 0:   break;  //Serial.print("OK,\t");
    case -1: Serial.print("Checksum error,\t"); break;  
    case -2: Serial.print("Time out error,\t"); break;  
    default: Serial.print("Unknown error,\t"); break;  
      }  
      
      String output = String(DHT.temperature,0) + "," +  String(DHT.humidity,0);
      Serial.println(output);  
      delay(5000);  // interval = 5 seconds
    }  

iv) Click ctrl+shift+m to open the serial monitor. You should be able to see two values representing the temperature and humidity, separated be a ",".

###4. Retrieve data from Arduino on the PI
i) Connect the Arduino with Raspberry PI with a USB cable  
ii) Run the following code to check the port number: 
 
    ls /dev/tty*
You should be able to see something like ttyUSB2.  
iii) Run the following python code with replacing the ttyUSBX in the second line of code:

    import serial
    
    ser=serial.Serial("/dev/ttyUSB2",9600) 
    ser.baudrate=9600
    
    while True:
    line = ser.readline().strip();
    values = line.decode('ascii').split(',')
    temperature, humidity = [int(s) for s in values]
    
    print("temperature = ",float(temperature),"\nhumidity = ",float(humidity),"\n")

You should be able to see something like
> temperature = 18.0  
> humidity = 19.0  

appearing in 5 seconds interval.
This means we successfully retrieve and interpret data from Arduino.  
Check the serial monitor in Arduino to confirm the result. 

###5. Install MySQL on the PI
i) Run the following code:

    sudo apt-get install python-dev libmysqlclient-dev mysql-client mysql-server
    sudo pip install mysql-python
During the installation, you will be prompted to setup the password of the root user.  

ii) Login to MySQL as the root user in the terminal:

    mysql -u root -p
ii) Enter your password  
iii) Setup a database

    CREATE DATABASE sensorData; 
    USE sensorData; // Enter the database
Enter the command \s to see the status, note that the Current databse is now be sensorData.

    CREATE TABLE TempHumid(CurrentDate DATE, CurrentTime TIME, Temperature NUMERIC, Humidity NUMERIC);

Enter `SELECT * FROM sensorData.TempHumid;`  
Empty set (0.00 sec) should be displayed since there is no data.  
Click quit to exit the MySQL

###6. 