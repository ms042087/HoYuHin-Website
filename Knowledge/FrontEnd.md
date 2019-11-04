# Electron

## How to build

1. The stack is Electron+Create React App + Rescripts + Electron Builder
Create React App is a APP to create react app, save time for configuration.  
Rescripts allows customization the CRA setup without rejecting.  
Electron Builder is used to package the desktop app for distribution
2. Create React APP
```npx create-react-app my-app```  
```cd my-app```  
3. Add electron and tools
```yarn add electron electron-builder --dev```
```yarn add wait-on concurrently --dev```  
```yarn add electron-is-dev```  
4. Add new file, ```public/electron.js``` with

```
const electron = require('electron');
const app = electron.app;
const BrowserWindow = electron.BrowserWindow;

const path = require('path');
const isDev = require('electron-is-dev');

let mainWindow;

function createWindow() {
  mainWindow = new BrowserWindow({width: 900, height: 680});
  mainWindow.loadURL(isDev ? 'http://localhost:3000' : `file://${path.join(__dirname, '../build/index.html')}`);
  if (isDev) {
    // Open the DevTools.
    //BrowserWindow.addDevToolsExtension('<location to your react chrome extension>');
    mainWindow.webContents.openDevTools();
  }
  mainWindow.on('closed', () => mainWindow = null);
}

app.on('ready', createWindow);

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

app.on('activate', () => {
  if (mainWindow === null) {
    createWindow();
  }
});
```

5. Add the following to the package.json scripts tag

```
"electron-dev": "concurrently \"BROWSER=none yarn start\" \"wait-on http://localhost:3000 && electron .\""
```

6. Add the following to the package.json main tag
```"main": "public/electron.js",```
7. Run ```yarn electron-dev```

<https://www.codementor.io/randyfindley/how-to-build-an-electron-app-using-create-react-app-and-electron-builder-ss1k0sfer>

## How to run

1. ```yarn install```
2. ```yarn electron-dev```

## knowledge

1. Disabling opening of the browser in server start  
```set BROWSER=none&&npm start```  
please note that no space in between
2. electron is not recognized as an internal or external command  
```npm i -g electron``` to install electron globally

# HTML CSS JQuery Ajax

1. Modifying files related

- Modifying a file

```
var fs = require('fs');

function readWriteAsync() {
  fs.readFile('filelist.txt', 'utf-8', function(err, data){
    if (err) throw err;

    var newValue = data.replace(/^\./gim, 'myString');

    fs.writeFile('filelistAsync.txt', newValue, 'utf-8', function (err) {
      if (err) throw err;
      console.log('filelistAsync complete');
    });
  });
}

function readWriteSync() {
  var data = fs.readFileSync('filelist.txt', 'utf-8');

  var newValue = data.replace(/^\./gim, 'myString');

  fs.writeFileSync('filelistSync.txt', newValue, 'utf-8');

  console.log('readFileSync complete');
}

readWriteAsync();
readWriteSync();
```

- Upload files  
Please refer to  
<https://www.npmjs.com/package/express-fileupload>

2. Form related

- Ignore form response

```
<iframe id="invisible" name="invisible" style="display:none;"></iframe>
<form method="post" target="invisible" action="url.com/whatever?x=y" id="fileForm" enctype="multipart/form-data">
```

- Ajax form with response

```
$("#my_form").submit(function(event){
    event.preventDefault(); //prevent default action
    var post_url = $(this).attr("action"); //get form action url
    var request_method = $(this).attr("method"); //get form GET/POST method
 var form_data = new FormData(this); //Creates new FormData object
    $.ajax({
        url : post_url,
        type: request_method,
        data : form_data,
  contentType: false,
  cache: false,
  processData:false
    }).done(function(response){ //
        $("#server-results").html(response);
    });
});
```

```
<form action="path/to/server/script" method="post" id="my_form">
    <label>Name</label>
    <input type="text" name="name" />
    <label>Email</label>
    <input type="email" name="email" />
    <label>Website</label>
    <input type="url" name="website" />
    <input type="file" name="my_file[]" /> <!-- File Field Added -->
    <input type="submit" name="submit" value="Submit Form" />
<div id="server-results"><!-- For server results --></div>
</form>
```




3. Pure HTML JQuery related


- hiding a div by default  
```<div class="toshow" style="display:none"></div>```

- Toggle visibility  

```

function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

```

- Element in array
``` var n = array.includes('element')```



## React 

