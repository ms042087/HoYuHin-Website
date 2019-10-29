# Database

## MongoDB

### MongoDB Atlas

**MongoDB Atlas** provides cloud services  
**MongoDB Stitch** provides Backend as a Service (BaaS) for mobile app

Mongo DB concept:

1. NoSQL (One of common practice: <=GB: SQL, >=TB: NoSQL)
2. Document paradigm
3. Document -> Collection -> DB

CRUD operation  

### Create

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
serverless: cloud-based services: Google cloud, AWS, Azure, IBM
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

# Express JS

## Server

1. Install Express generator globally  
```npm install express-generator -g```
2. Create a Express App called serer  
```express --view=pug server```
3. Go to the folder and run  
```cd server```  
```npm install```
4. go to bin/www  
on line 15 change port 3000 -> 9000  
5. goto server/routes  
create a new API called myAPI.js with content

```
var express = require("express");
var router = express.Router();

router.get("/", function(req, res, next) {
    res.send("API is working properly");
});

module.exports = router;
```

6. goto server/app.js  
on line 24 add  
```app.use("/myAPI", myAPIRouter);```  
on line 9 add  
```var myAPIRouter = require("./routes/myAPI");```

7. Go back to root directory
```cd ..```

## Client

1. Create client app

```
npx create-react-app client
cd client/src
```

2. Change the following code in app.js

```

import React,{Component} from "react";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { apiResponse: "" };
  }

  callAPI() {
    fetch("http://localhost:9000/myAPI")
      .then(res => res.text())
      .then(res => this.setState({ apiResponse: res }));
  }

  componentWillMount() {
    this.callAPI();
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p className="App-intro">{this.state.apiResponse}</p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}
```

3. solve CORS problem  
```npm install --save cors```  
On line 6 of app.js, add  
```var cors = require("cors");```  
On line 15 of app.js, add  
```app.use(cors());```

Run both the server and client, and navigate to <http://localhost:3000/> done

  fetchCTData() {
    fetch("<https://emsd.arupneuron.com/api/DP/GetAllCTData")>
      .then(function(res) {
        return res.json();
      })
      .then(function(res) {
        var result = res[0].minute;
        console.log(result);
        return result;
      })
      .then(res => this.setState({ apiResponse: res }));
  }
