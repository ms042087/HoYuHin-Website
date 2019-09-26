# Notes
## AutoCAD

1. BatchPlot: Need to save the file before running the command, otherwise the file list cannot be saved
2. In plot, use window button to select the area to be printed
3. **Hide grid line** in layout: F7/Fn+F7/Ctrl+G/Cmd+G
4. For Simplified Chinese, please use command SYSCODEPAGE to check the system code. It should be ANSI_936. If not, go to window tab -> Region & language settings -> Administrative language settings -> change system locale : Chinese (simplified, China)


## React-native

### Life cycle of React Native  
Mounting -> Updating -> Unmounting 

Render  
react component -> DOM node that browser can understand  
props -> store components properties  
async:  
```
try
    const _ await _:
```
Virtual DOM  
Style Control:  
StyleSheet.create  
Storage:  
save and load 

1. Create a react-native with a specific version
```react-native ProjectName --version react-native@VersionNumber``` 
e.g. 0.59.1 (which pair with React 16.8.3)
2. Set the version again
```react-native upgrade --legacy```
3. Debugging
```react-native run-android```

4. Building
```keytool -genkeypair -v -keystore mykeystore.keystore -alias mykeyalias -keyalg RSA -keysize 2048 -validity 10000``` in Android/App
```gradlew assembleRelease``` in Android
```react-native run-android --variant=release```

5. Encounter problem

    a) remove modules_node, ```npm install``` again  
    b) goto ./android, run ```gradlew clean```  
    c) ```react-native start -- --reset-cache```  
    d) check the version  
    ```npm -v```  
    ```node -v```  
    e) When building application, key error occur try ```gradlew clean```  
    f) ```react-native link```  
    g) Could not upload to Android device: ```adb reverse tcp:8081 tcp:8081```  

    WebView problem:
    ```Invariant Violation: Native component for "RNCWebView does not exist" ``` =>  Run
    ```react-native link react-native-webview```  
    White screen/ Plain text => 
    Change source to   
    ```source = {(Platform.OS == 'ios') ? require('../highcharts-layout/index.html') : { uri: 'file:///android_asset/highcharts-layout/index.html' }}```

6. Every setState() trigger a render event. Try using less setState() to improve the performance.

## MongoDB
### MongoDB Atlas 
**MongoDB Atlas** provides cloud services  
**MongoDB Stitch** provides Backend as a Service (BaaS) for mobile app

Mongo DB concept:
1. NoSQL (One of common practice: <=GB: SQL, >=TB: NoSQL)
2. Document paradigm
3. Document -> Collection -> DB


CRUD operation  
### Create:
```
db.CollectionName.insertOne(
   { 
       item: "canvas", 
       qty: 100
    }
)
```
```
db.inventory.insertMany([
   { item: "journal", qty: 25},
   { item: "mat", qty: 85},
   { item: "mousepad", qty: 25}
])
```
### Read
```
db.inventory.find( {
     status: "A",
     $or: [ { qty: { $lt: 30 } }, { item: /^p/ } ]
} )
```
### Update
```
db.inventory.updateOne(
   { item: "paper" },
   {
     $set: { "size.uom": "cm", status: "P" },
     $currentDate: { lastModified: true }
   }
)
```
```
db.inventory.updateMany(
   { "qty": { $lt: 50 } },
   {
     $set: { "size.uom": "in", status: "P" },
     $currentDate: { lastModified: true }
   }
)
```

### Delete
```
db.inventory.deleteMany({ status : "A" })
```


## Big Data Knowledge
1. Hadoop is a distributed file system
2. Big data system: a) data acquisition b) data processing and storage c) data analytics
3. AWS (Amazon Web Services)  
- **EC2** is VPS (Virtual Private Server), for creating virtual server, each machine is called an instance  
- **S3** provides simple storage services  
- **IAM (Identity and Access Management)** provides MFA, setting up types of users and the permission granted for the user Kinesis Data FireHouse collects data and goto S3  
- **Lambda** transform data
- **Free RTOS** is for the controlling microcontroller using AWS cloud service 

4. Real-time video analytics
- **kafka** (Data stream platform)
- **spark** (cluster computing platform)

## Other knowledge
1. MongoDB vs Amazon Dynamo, mongodb is self-managed, Dynamo is Amazon-managed
ES5/ES6 are JS syntax
ES6 provide input => {}, let function
JSX is embedding XML within JS


6. Node-Red is a Browser-based flow editor based on node.js for writing backend application
7. Backend development: 
-> server v.s. serverless
severless: cloud-based services: Google cloud, AWS, Azure, IBM
server: 
on-cloud (e.g. EC2)
on-premises
Install Ubuntu -> Use flask for fast development
-> Use Redis as in-ram key-value caching
-> Use influx db as time-series database or use mongoDB as NOSQL document type DB
-> If influx db is used, can use telegraf as middleware, then use grafana to make a dashboard

SQL: DB Table Row  
MongoDB: DB Collection Record  
InfluxDB: DB Measurement Point  

8. Docker
Docker compose: define the relationship of multiple services, in a YAML file
Dockerfile describe the information of image

Useful command:
docker ps -a
docker run -d --name xxx --restart=always -p 80:80 -v ...

## ELV system design rule of thumb
1. Projector system  
- 20 sqm/item
- 3 kW/item
- Ceiling installation assume 20 kg
- Example calculation: 20 projectors -> 20*3kW = 60kW. With 20% spare => 70 kW
2. LED panel
- Indoor P2.5 (P stand for pixel pitch)
- 0.9 kW/sqm
- 30kg/item
3. IT room
- 20* 1200x800 雙門機櫃 (一個機櫃 4kW)
- 1 workstation
- 120 mins UPS
- FM200 氣體滅火
- environment monitoring
- Earthing 端子 <1ohm
- 500 Lx 照明
- 18-24 temperature, 40-55% humidity
4. Optical fibre 
- 2 modes: OS & OM (Optical single mode & Optical multiple mode)
- >1km use OS, >10Gb/s use OM
5. WiFi system
- RSSI > 65dbm
6. data network
- Load balancer
- DMZ (demilitarized zone)
7. BGM system
- ambient noise sensor collects background noise to adjust the volume of BGM
8. curved LED
- p2.5
- 800 cd/sqm
- IP31
- 7kg/sqm
9. outdoor LED screen
- p8
- 6000 cd/sqm
- IP 65 & IP54 for front and back
- 38kg/sqm
10. 機房接地系統
- SPD (Surge Protection Device)

設計概念:  
住宅系統，大物業系統  
電訊接入方法: 園區接入，地塊接入  
電訊商 -> 電訊設備房 ->總配線架->光纖配線架->分光器  
主幹橋架-> 垂直配線架->分光器->水平配線架  
網絡結構: 三層: 核心層，匯聚層，接入層

## Other tools
1. Make background transperant: 
pixlr.com/editor/
