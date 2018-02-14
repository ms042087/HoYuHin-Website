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
You should be able to see something like ttyUSBX.  
iii) 