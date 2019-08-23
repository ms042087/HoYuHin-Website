#include <SoftwareSerial.h>

char ReadReceived_Char; 
const int trigL = 8;
const int echoL = 9;
const int trigR = 6;
const int echoR = 7;
long durationL = 0;
long durationR = 0;
float distanceL = 0;
float distanceR = 0;
float threshold = 30; 

void getData(){
 // Trigger for Left
 digitalWrite(trigL,1);
 delayMicroseconds(15);
 digitalWrite(trigL,0);
 // Echo for Left
 durationL = pulseIn(echoL, HIGH);
 
// Trigger for Right
 digitalWrite(trigR,1);
 delayMicroseconds(15);
 digitalWrite(trigR,0);
 // Echo for Right
 durationR = pulseIn(echoR, HIGH);
  
  // Calculate the distance
  distanceL = durationL/58 ; 
  distanceR = durationR/58 ; 
  
  String L,R,str;
  if(distanceL>threshold)
    L="N";
  else
  L="P";
   if(distanceR>threshold)
    R="N";
  else
    R="P";
    str= L+","+R;
  Serial.println(str);
  
  // Reset parameters
  durationL = 0; distanceL = 0;
  durationR = 0; distanceR = 0;
  
  // Set the sampling interval
  delay(2000);
}
void setup() {

  pinMode(trigL, OUTPUT);
  pinMode(trigR, OUTPUT);
  pinMode(echoL,INPUT);
  pinMode(echoR,INPUT);
  Serial.begin(9600);
}

void loop() {
  getData();

}      
