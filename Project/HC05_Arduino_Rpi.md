### Connecting Rpi and Arduino using HC-05 Bluetooth module
#### Arduino side:

Connect pin 2 to Tx (Transmission pin)  
Connect pin3 to 1k Ohm resistor, then to Rx (Receiver pin), with a 2k Ohm resistor to ground. This act as a voltage   divider 5V-> 3.3V
Connect 5V to VCC  
Connect GND to GND  

Upload the following code to Arduino
 
	#include <SoftwareSerial.h>
	SoftwareSerial BTserial(2, 3); 
	 
	char c = ' ';  
	char bc = ' ';  
	String readstr = "" ; 
	
	void setup() 
	{
	Serial.begin(9600); 
	BTserial.begin(38400);  
	}
	
	void loop()
	{
	 
	   if (BTserial.available()) 
	{  
	   bc = BTserial.read();  
	   Serial.write(bc);   
	   }
	
	 
	if (Serial.available())  
	{
	c =  Serial.read();
	   BTserial.write(c); 
	}
	   
	}

Open the serial monitor, enter AT+ADDR to check the address of the bluetooth module and enter AT+PSWD to check the pin code.

#### Raspberry Pi 3 side:
Open the terminal and enter:  

	sudo nano /etc/systemd/system/dbus-org.bluez.service
change

	ExecStart=/usr/lib/bluetooth/bluetoothd
to

	ExecStart=/usr/lib/bluetooth/bluetoothd -C
	ExecStartPost=/usr/bin/sdptool add SP
Reboot the Raspberry Pi

Open the terminal and enter:  

	sudo bluetoothctl
After enter the bluetooth mode, enter

	power on
	agent on
	default-agent
	scan on
	pair <addr>
Then enter the PIN code of Bluetooth module.

Enter 

	hciscan on 
	sudo rfcomm bind 0 <addr>
in the terminal.  
This binds the address to RF Interface.  

Run a python script to test.

	import serial
	
	btSerial = serial.Serial("/dev/rfcomm0", baudrate=9600, timeout=0.5)
	
	while True:
	    #btSerial.write("RaspberryPi to Arduino")
	
	    rcv = btSerial.readline().strip()
	    if rcv:  
	        print("Arduino says: " + rcv)

#### Testing
Type "hi" in serial monitor of Arduino, you should receive

	Arduino says: hi
in the python shell in Raspberry Pi