#### Setup iBeacon - Bluetooth LE

	#include <SoftwareSerial.h>
	SoftwareSerial myBT(10, 9); // Pin 10 for Receive, Pin 9 for Send
	char chrRecv;              
	
	void setup() {
	  Serial.begin(9600);
	  Serial.print("BT is Ready");
	  
	  myBT.begin(9600);
	  
	}
	
	void loop() {
	  if (Serial.available())
	  {
	    chrRecv = Serial.read(); // Read from Serial Monitor
	    myBT.print(chrRecv);    // Write command or data to Bluetooth
	  }
	
	  if (myBT.available()) // when receive data
	  {
	    chrRecv = myBT.read(); // Read from Bluetooth
	    Serial.print(chrRecv); // Write command or data to Serial Monitor
	  }
	}

#### Check version
AT+VERR?
#### Renew 
AT+RENEW
#### Reset
AT+RESET
#### Start iBeacon
AT+IBEA1
#### Set UUID
AT+IBE074278BDA
AT+IBE1B6444520
AT+IBE28F0C720E
AT+IBE3AF059935
#### Set Major
AT+MARJ0x4134
#### Set Minor
AT+MINO0x4134
#### Set broadcast time
AT+ADVI0
#### Set Name
AT+NAMExxx
#### Set mode
AT+DELO2 //broadcast only
#### Set broadcast mode
AT+ADTY3 //advertising only
#### Auto sleep
AT+PWRM0 // 0 = auto sleep, 1 = always wake up
#### Reset
AT+RESET  

Source:
http://www.pondoudou.com/?p=2004