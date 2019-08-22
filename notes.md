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
3. Amazon EC2 is VPS (Virtual Private Server), for creating virtual server, each machine is called an instance
4. kafka?, spark?, 
AWS IAM (Identity and Access Management) provides MFA, setting up types of users and the permission granted for the user Kinesis Data FireHouse collects data and goto S3
Amazon S3 provides simple storage services
5. Node-Red is a Browser-based flow editor
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

## Other tools
1. Background transperant: 
pixlr.com/editor/

## Work done
1. NingBo: Use Bluebeam to mark the region of BGM coverage in PDF, Use AutoCAD to draw the PA ducting and Etransmit and Batchplot
2. Research on Amazon RTOS 
3. Research on HK building energy uses
4. HKIA: Modify schematics



## Arup stuff:
### charge code:
1. Bank holiday (include N.o. 8 signal)  
2. holiday (AL)  
3. illness  