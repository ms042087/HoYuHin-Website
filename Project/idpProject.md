#### Server:  
1. Install LAMP server  
	You should have your **L** (Linux environment) e.g. Raspbian prepared  
	Install **A** - Apache 2 Server  
	`sudo apt-get install apache2  `  
	Install **M** - MySQL  
    	`sudo apt-get install mysql-server  `  
    	`sudo mysql_secure_installation  `  
	Install **P** - PHP and phpmyadmin  
	`sudo apt-get install phpmyadmin  `  
	Setup (if needed)  
	`sudo nano /etc/apache2/apache2.conf  `  
	add a line:  
	Include /etc/phpmyadmin/apache.conf  
	sudo /etc/init.d/apache2 restart  
	
	To access the phpmyadmin:  
	goto [ip address]/phpmyadmin  


	Check status of apache2 server  
	`sudo systemctl status apache2  `  

	Check listening port  
	`sudo lsof -i -P -n  `  

	Check port status  
	`netstat -tuplen  `  

	Configure MySQL to accept external connections to Raspberry Pi  
	`sudo nano /etc/mysql/my.cnf  `  
	`#bind-address = 127.0.0.1`
	`/etc/init.d/mysql restart`
2. Set up the database structure through phpMyAdmin. For easy design of database structure, you can use [MySQL workbench](https://www.mysql.com/products/workbench/) to configure the database  
3. Create User with appropriate grant of access  
4. Go to [no-ip.com](https://www.noip.com/) to get a free hostname and get DDNS service. To automatically updates the hostname to the correct IP address, download the [Dynamic Update Client (DUC)](https://my.noip.com/#!/dynamic-dns/duc)  
![](XAMPP.jpg =120x) 
5. In firewall, allow the access of 3306(default in MySQL) port for both Inbound and OutBound and for both TCP and UDP.  
6. Enter 192.168.0.1 to configure router setting  
7. Set the DDNS service and port forwarding  
- Service Port: 3306  
- Internal Port: 3306  
- IP Address: 192.168.x.x  
8. Go to this [website](https://www.yougetsignal.com/tools/open-ports/)  
To check if Port 3306 is open on your IP.  

#### Android
The most common way of accessing MySQL database through Android app is php since it is more secure, but this maybe quite complicated. Therefore, here we use Java Database Connector (JDBC).  
We use JDBC API to connect MySQL database and use Simple Object Access Protocol (SOAP) for the web service.  
1. Download mysql-connector-java-5.1.23-bin.jar and ksoap2-android-assembly-2.5.8-jar-with-dependencies.jar. Put them in  .\app\libs  
2. Open AndroidManifest.xml add the permission of accessing internet.  

    <uses-permission android:name="android.permission.INTERNET" />

Open build.gradle to add dependencies
    
    compile files('libs/mysql-connector-java-5.1.23-bin.jar')
    compile files('libs/ksoap2-android-assembly-2.5.8-jar-with-dependencies.jar')  

After that, we create some class for connection  
3. Create a ConnectionClass  
	
		package com.example.idpproject;
		import android.annotation.SuppressLint;
		import android.os.StrictMode;
		import android.util.Log;
		
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.SQLException;
		

		public class ConnectionClass {
		    String classs = "com.mysql.jdbc.Driver";
		
		    String url = "jdbc:mysql://<hostname>/mydb";
		    String user = "<username>";
		    String password = "<password>";

		    @SuppressLint("NewApi")
		    public Connection CONN() {
		        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		                .permitAll().build();
		        StrictMode.setThreadPolicy(policy);
		        Connection conn = null;
		        String ConnURL = null;
		        try {
		            Class.forName(classs);
		            conn = DriverManager.getConnection(url, user, password);
		            conn = DriverManager.getConnection(ConnURL);
		        } catch (SQLException se) {
		            Log.e("ERROR", se.getMessage());
		        } catch (ClassNotFoundException e) {
		            Log.e("ERROR", e.getMessage());
		        } catch (Exception e) {
		            Log.e("ERROR", e.getMessage());
		        }
		        return conn;
		    }
		}

4. 

