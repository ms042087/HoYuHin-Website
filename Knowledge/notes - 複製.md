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


Run both the server and client, and navigate to http://localhost:3000/ done



  fetchCTData() {
    fetch("https://emsd.arupneuron.com/api/DP/GetAllCTData")
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

