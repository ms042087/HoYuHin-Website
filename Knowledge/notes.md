# Notes
## AutoCAD
1. BatchPlot: Need to save the file before running the command, otherwise the file list cannot save
2. Plot style choose Arup A0-A1 for B&W printing
3. In plot, use window button to select the area to be printed
4. **Hide grid line** in layout: F7/Fn+F7/Ctrl+G/Cmd+G
5. For Simplified Chinese, please use command SYSCODEPAGE to check the system code. It should be ANSI_936. If not, go to window tab -> Region & language settings -> Administrative language settings -> change system locale : Chinese (simplified, China)

line, circle, polyline, arc, rec, text  
move, copt, rotate, trim, mirror, array, fillet, join  
units, dim, dimsty  

standard: inches
ISO-25: meters

## React-native
1. Create a react-native with a specific version
```react-native ProjectName --version react-native@VersionNumber``` 
e.g. 0.59.1 (which pair with React 16.8.3)
2. Set the version again
```react-native upgrade --legacy```
3. Debugging
```react-native run-android```

5. Encounter problem

a) remove modules_node, ```npm install again```  
b) goto ./android, run ```gradlew clean```  
c) ```react-native start -- --reset-cache```  
d) checking the version  
```npm -v```  
```node -v```


## MongoDB
### MongoDB Atlas 
**MongoDB Atlas** provides cloud services
**MongoDB Stitch** provides Backend as a Service (BaaS) for mobile app

Mongo DB concept:
1. NoSQL (<=GB: SQL, >=TB: NoSQL)
2. Document paradigm
3. Document -> Collection -> DB


http://localhost:3000/confirmation
http://localhost:3000/reset
http://localhost:3000/reset
Email and Password Confirmation


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


## Other knowledge
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

5. MongoDB vs Amazon Dynamo, mongodb is self-managed, Dynamo is Amazon-managed
ES5/ES6 are JS syntax
ES6 provide input => {}, let function
JSX is embedding XML within JS
Life cycle of React Native
Mounting -> Updating -> Unmounting
Render
react component -> DOM node that browser can understand
props -> store components properties
async:
try
    const _ await _:
Virtual DOM
Update the difference instead if recreate everything
Style Control:
StyleSheet.create
Storage:
save and load 

6. Node-Red is a Browser-based flow editor

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


## Other tools
1. Background transperant: 
pixlr.com/editor/

## Work done
1. NingBo: Use Bluebeam to mark the region of BGM coverage in PDF, Use AutoCAD to draw the PA ducting and Etransmit and Batchplot
2. Research on Amazon RTOS 
3. Research on HK building energy uses
4. HKIA: Modify schematics


## Arup stuff:
#### charge code:
1. Bank holiday (include N.o. 8 signal)  
2. holiday (AL)  
3. illness  