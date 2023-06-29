#include <FB_Const.h>
#include <FB_Error.h>
#include <FB_Network.h>
#include <FB_Utils.h>
#include <Firebase.h>
#include <FirebaseFS.h>
#include <Firebase_Client_Version.h>
#include <Firebase_ESP_Client.h>
#include <MB_NTP.h>
//#include <FirebaseJson.h>

#include <ESP8266WiFi.h>

#include <addons/TokenHelper.h>

// Provide the RTDB payload printing info and other helper functions.
#include <addons/RTDBHelper.h>

//#define USER_EMAIL ""
//#define USER_PASSWORD "USER_PASSWORD"
 
// Set these to run example. 
#define FIREBASE_HOST "aquabal-2b59e-default-rtdb/data/~2F" 
#define API_KEY "ULMnbQuOmuScy9SsjbROZzGxYB4hhtpO3QfOZzCX" 
#define WIFI_SSID "SSID" 
#define WIFI_PASSWORD "PASSWORD" 
#include <SoftwareSerial.h>

const byte rxPin = 0;
const byte txPin = 1;



FirebaseData fbdo;

// Define the FirebaseAuth data for authentication data
FirebaseAuth auth;

// Define the FirebaseConfig data for config data
FirebaseConfig config;

#define SENSOR  2
#define PumpRelay 5

bool toggleState_1 = false;
int FloatSensor=2;
int led=13;
int buttonState=1;

long currentMillis = 0;
long previousMillis = 0;
int interval = 1000;
float calibrationFactor = 4.5;
volatile byte pulseCount;
byte pulse1Sec = 0;
float flowRate;
unsigned long flowMilliLitres;
unsigned int totalMilliLitres;
float flowLitres;
float totalLitres;

void  IRAM_ATTR pulseCounter()
{
  pulseCount++;
} 
 
void setup() { 
  //Serial.begin(9600); 
 
  Serial.begin(115200);
  delay(10);
  pinMode(PumpRelay, OUTPUT);
  pinMode(FloatSensor,INPUT_PULLUP);
  pinMode(led,OUTPUT);

  digitalWrite(PumpRelay, HIGH);
  digitalWrite(led,LOW);

 
  pinMode(SENSOR, INPUT_PULLUP);
  pinMode(8, OUTPUT); 
  pulseCount=0;
  flowRate = 0.0;
  flowMilliLitres = 0;
  totalMilliLitres = 0;
  previousMillis = 0;
 

  // connect to wifi. 
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD); 
  Serial.print("connecting"); 
  while (WiFi.status() != WL_CONNECTED) { 
    Serial.print("."); 
    delay(500); 
  } 
  Serial.println(); 
  Serial.print("connected: "); 
  Serial.println(WiFi.localIP()); 
   // Assign the project host and api key 
config.host = FIREBASE_HOST;

config.api_key = API_KEY;

config.token_status_callback = tokenStatusCallback; // see addons/TokenHelper.h

#if defined(ESP8266)
  // In ESP8266 required for BearSSL rx/tx buffer for large data handle, increase Rx size as needed.
  fbdo.setBSSLBufferSize(512 /* Rx buffer size in bytes from 512 - 16384 */, 2048 /* Tx buffer size in bytes from 512 - 16384 */);
#endif

// Limit the size of response payload to be collected in FirebaseData
  fbdo.setResponseSize(512);

  // set up a new serial object
SoftwareSerial mySerial (rxPin, txPin);

// Assign the user sign in credentials
//auth.user.email = USER_EMAIL;
//auth.user.password = USER_PASSWORD;

// Initialize the library with the Firebase authen and config.
Firebase.begin(&config, &auth);
 // Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH); 
 Firebase.reconnectWiFi(true);

  Firebase.setDoubleDigits(5);

config.timeout.serverResponse = 10 * 1000;
//int motor=0;
//Firebase.RTDB.setInt(&fbdo,"motor",0);
//Serial.printf("Set int... %s\n", Firebase.RTDB.setInt(&fbdo, F("/test/int"), motor) ? "ok" : fbdo.errorReason().c_str());

} 

//WiFiClient client;

//void setup()
//{
  
  //attachInterrupt(digitalPinToInterrupt(SENSOR), pulseCounter(), FALLING);



 
void loop()
{
  currentMillis = millis();
  if ((Firebase.ready())&&(currentMillis - previousMillis > interval)) 
  {
    
     pulse1Sec = pulseCount;
    pulseCount = 0;
 
    // Because this loop may not complete in exactly 1 second intervals we calculate
    // the number of milliseconds that have passed since the last execution and use
    // that to scale the output. We also apply the calibrationFactor to scale the output
    // based on the number of pulses per second per units of measure (litres/minute in
    // this case) coming from the sensor.
    flowRate = ((1000.0 / (millis() - previousMillis)) * pulse1Sec) / calibrationFactor;
    previousMillis = millis();
 
    // Divide the flow rate in litres/minute by 60 to determine how many litres have
    // passed through the sensor in this 1 second interval, then multiply by 1000 to
    // convert to millilitres.
    flowMilliLitres = (flowRate / 60) * 1000;
    flowLitres = (flowRate / 60);
 
    // Add the millilitres passed in this second to the cumulative total
    totalMilliLitres += flowMilliLitres;
    totalLitres += flowLitres;
    
    // Print the flow rate for this second in litres / minute
    Serial.print("Flow rate: ");
    //flowRate=2;
    Serial.print(float(flowRate));  // Print the integer part of the variable
    Serial.print("L/min");
    Serial.print("\t");       // Print tab space
 
 
    // Print the cumulative total of litres flowed since starting
    Serial.print("Output Liquid Quantity: ");
    Serial.print(totalMilliLitres);
    Serial.print("mL / ");
    Serial.print(totalLitres);
    Serial.println("L");
  }
  
  /*if (client.connect(server, 80)) // "184.106.153.149" or api.thingspeak.com
  {
    String postStr = apiKey;
      postStr += "&field1=";
      postStr += String(float(flowRate));
      postStr += "&field2=";
      postStr += String(totalLitres);
      postStr += "\r\n\r\n";
    
    client.print("POST /update HTTP/1.1\n");
    client.print("Host: api.thingspeak.com\n");
    client.print("Connection: close\n");
    client.print("X-THINGSPEAKAPIKEY: " + apiKey + "\n");
    client.print("Content-Type: application/x-www-form-urlencoded\n");
    client.print("Content-Length: ");
    client.print(postStr.length());
    client.print("\n\n");
    client.print(postStr);
   
  }
    client.stop();*/

    //Firebase.RTDB.setFloat("flowRate",flowRate);
    //Firebase.RTDB.setFloat(&fbdo, F("test")));
      //    Firebase.RTDB.setFloat(&fbdo, F("to")) ? String(fbdo.to<int>()).c_str() : fbdo.errorReason().c_str());
      Serial.printf("Set float... %s\n", Firebase.RTDB.setFloat(&fbdo, F("/test/float"), flowRate) ? "ok" : fbdo.errorReason().c_str());
          Serial.printf("Set float... %s\n", Firebase.RTDB.setFloat(&fbdo, F("/test/float"), totalLitres) ? "ok" : fbdo.errorReason().c_str());

     //if(Serial.available()>0)
   //{ 
      //int motordb=Serial.printf("Get int ref... %s\n", Firebase.RTDB.getInt(&fbdo, F("/test/int"), &motor) ? String(motor).c_str() : fbdo.errorReason().c_str());
      
      int motordb=0;
     // int iVal = 0;
    Serial.printf("Get int ref... %s\n", Firebase.RTDB.getInt(&fbdo, F("/test/int"), &motordb) ? String(motordb).c_str() : fbdo.errorReason().c_str());
      
      //Firebase.getInt("motor");

  if(motordb==1){
           digitalWrite(8, HIGH);
           //break;
            }
           if(motordb==0)// when on   
         { digitalWrite(8, LOW);
          // when off
  // Serial.println(data);
  }   

  /*FirebaseJson json;

    if (totalLitres == 0)
    {
      json.set("value/round/" + String(totalLitres), totalLitres);
      json.set(F("value/ts/.sv"), F("timestamp"));
     // Serial.printf("Set json... %s\n", Firebase.RTDB.set(&fbdo, F("/test/json"), &json) ? "ok" : fbdo.errorReason().c_str());
    }
    else
    {
      json.add(String(totalLitres), totalLitres);
      Serial.printf("Update node... %s\n", Firebase.RTDB.updateNode(&fbdo, F("/test/json/value/round"), &json) ? "ok" : fbdo.errorReason().c_str());
    }*/
 
      
  // Serial.println(data);
delay(50);
 buttonState=digitalRead(FloatSensor);
  if(buttonState==LOW)
  {
    digitalWrite(PumpRelay, HIGH); 
    toggleState_1 = false;
    digitalWrite(led, toggleState_1);
    //Serial.println("WATER LEVEL-HIGH");
     delay(8000);
  }
  else{
    if(toggleState_1==false){
      
    digitalWrite(PumpRelay, LOW); 
     toggleState_1 = true;
     digitalWrite(led,toggleState_1); 
     delay(8000); 
    }
  }
  //delay(1000);
}

