/*
 *     9          10
 *     2 3 4 5 6 7 8
 *         1
 */

// delay time
int n=1500;

void setup() {
  pinMode(led1, OUTPUT);pinMode(led2, OUTPUT);pinMode(led3, OUTPUT);pinMode(led4, OUTPUT);pinMode(led5, OUTPUT);
  pinMode(led6, OUTPUT);pinMode(led7, OUTPUT);pinMode(led8, OUTPUT);pinMode(led9, OUTPUT);pinMode(led10, OUTPUT);
  pinMode(11,INPUT);pinMode(12,INPUT);
 
  Serial.begin(9600);
}


void pathA(){
  analogWrite(9, 255);
  analogWrite(1, 255);
  delay(n);
  analogWrite(1, 0);
 
  analogWrite(4, 255);
  delay(n);
  analogWrite(4, 0);
  analogWrite(3, 255);
  delay(n);
  analogWrite(3, 0);
  analogWrite(2, 255);
  delay(n);
  analogWrite(2, 0);
  analogWrite(9, 255);
  delay(3000);
  analogWrite(9, 0);

}

void pathB(){
  analogWrite(10, 255);
  analogWrite(1, 255);
  delay(n);
  analogWrite(1, 0);
  analogWrite(4, 255);
  delay(n);
  analogWrite(4, 0);
  analogWrite(5, 255);
  delay(n);
  analogWrite(5, 0);
  analogWrite(6, 255);
  delay(n);
  analogWrite(6, 0);
  analogWrite(8, 255);
  delay(n);
  analogWrite(8, 0);
  analogWrite(7, 255);
  delay(n);
  analogWrite(7, 0);

  delay(3000);
  analogWrite(10, 0);
  
}

void loop() {

  //Serial.println(digitalRead(11));
  //Serial.println(digitalRead(12));

  // From Car Reader, pin6->11, pin7->12
  if(digitalRead(11)==HIGH)
    pathA();
  else if(digitalRead(12)==HIGH) 
    pathB();
}

