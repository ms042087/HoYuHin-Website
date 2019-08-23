### Node.js  

learn once, write anywhere  
asyn display  
js running off the main thread  
3 pillars:  
- touch handling  
- native components  
- style & layout  

### Install Node.js in raspberry pi

    curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -
    sudo apt-get install -y nodejs
##### check version
	node -v
##### Testing
Create a js file  
```nano helloworld.js```  
with the following content  
```console.log("Hello World");```  
Run the js  
```node helloworld.js```  

### MQTT
#### Install Mosquitto in raspberry pi
Open a terminal to install mosquitto

    sudo wget http://repo.mosquitto.org/debian/mosquitto-repo.gpg.key
    sudo apt-key add mosquitto-repo.gpg.key
    cd /etc/apt/sources.list.d/
    sudo wget http://repo.mosquitto.org/debian/mosquitto-jessie.list
    sudo apt-get update
    sudo apt-get install mosquitto
    sudo apt-get install mosquitto mosquitto-clients python-mosquitto
Stop the service and configure it

    sudo /etc/init.d/mosquitto stop
    sudo nano /etc/mosquitto/mosquitto.conf
Modify it to

    # Place your local configuration in /etc/mosquitto/conf.d/
    #
    # A full description of the configuration file is at
    # /usr/share/doc/mosquitto/examples/mosquitto.conf.example
    
    pid_file /var/run/mosquitto.pid
    
    persistence true
    persistence_location /var/lib/mosquitto/
    
    log_dest topic
    
    
    log_type error
    log_type warning
    log_type notice
    log_type information
    
    connection_messages true
    log_timestamp true
    
    include_dir /etc/mosquitto/conf.d

Restart the service
```sudo /etc/init.d/mosquitto start```

##### Testing  
Terminal 1:
```mosquitto_pub -d -t hello/world -m "Hi"```  
Terminal 2:
```mosquitto_sub -d -t hello/world```

Guide:
http://www.switchdoc.com/2016/02/tutorial-installing-and-testing-mosquitto-mqtt-on-raspberry-pi/

### Install a mqtt library to node.js
	sudo npm install mqtt -g // global

## Other
- React-Native-Android-Studio  
[https://blog.csdn.net/dream_an/article/details/53787183](https://blog.csdn.net/dream_an/article/details/53787183)
- React Native 簡介：以 JavaScript 建構 iOS App  
[https://www.appcoda.com.tw/react-native-introduction/](https://www.appcoda.com.tw/react-native-introduction/)
- Nginx vs Apache  
[https://hk.saowen.com/a/e7a664c40c81c27274fc56daa689d02f40dd88995416186891618f6475caa81e](https://hk.saowen.com/a/e7a664c40c81c27274fc56daa689d02f40dd88995416186891618f6475caa81e)
- HTTP Load balancing with Nginx  
[https://www.youtube.com/watch?v=SpL_hJNUNEI](https://www.youtube.com/watch?v=SpL_hJNUNEI)