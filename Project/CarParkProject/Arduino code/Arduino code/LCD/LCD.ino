#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 10, 9, 8, 7);

String incomingByte;
void setup()
{
  lcd.begin(16,2);
  lcd.clear();
  delay(1000);
  Serial.begin(9600);
}

void loop ()
{  
  if (Serial.available() > 0) {
    incomingByte=Serial.readString();
    int length = incomingByte.length();
    incomingByte = incomingByte.substring(0,length-2);
    Serial.println(incomingByte);
   }
  lcd.setCursor(0, 0) ;
  String show = "Vacancy:" +incomingByte;
  lcd.print(show); 
  lcd.setCursor(0, 1) ;
  lcd.print(""); 
  delay(500);    
}


