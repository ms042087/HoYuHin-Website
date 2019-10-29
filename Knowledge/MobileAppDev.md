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
    ```Invariant Violation: Native component for "RNCWebView does not exist"``` =>  Run
    ```react-native link react-native-webview```  
    White screen/ Plain text =>
    Change source to
    ```source = {(Platform.OS == 'ios') ? require('../highcharts-layout/index.html') : { uri: 'file:///android_asset/highcharts-layout/index.html' }}```

6. Every setState() trigger a render event. Try using less setState() to improve the performance.
