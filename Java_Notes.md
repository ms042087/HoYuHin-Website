### Object creation and aliases
    int data = 1;  // primitive variable stores the value  
    ClassDemo demo1 = new ClassDemo(1);  // object reference stores the address of address  
    ClassDemo demo2 = new ClassDemo(2);  

data [aaa] -> 1  
demo1 [bbb] -> [ccc] -> 1  
demo2 [ddd] -> [eee] -> 2

    demo2 = demo1;  

data [aaa] -> 1  
demo1 [bbb] -> [ccc] -> 1  
demo2 [ddd] -> [ccc] -> 1

### Visibility Modifier
||Same class|Same package|inheritance|other package|
|:--|:--|:--|:--|:--|
|public|o|o|o|o|
|protected|o|o|o|x|
|friendly|o|o|x|x|
|private|o|x|x|x|

### Static
Static variable: same for whole class  
Static method:  
- It is invoked by the Java interpreter without creating an object  
- Cannot reference instance variables because instance variables don't exist until an object exists

### Method
PASS BY VALUES in JAVA
#### overloading:  
    public int method1(int i)  
    return i;  
    public String method1(int i)  
    return "A";  
NOT OK  

    public int method1(int i)  
    return i;  
    public int method1(int i, int j)  
    return i+j;  
OK


### Enum
    enum Color {RED, BLUE}  
    Color color = Color.RED;  
    for (Color color:Color.value())  

### Array and ArrayList
Array is an OBJECT in Java  

    Array.length  
    ArrayList.size()

    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList.get(i)  
    ArrayList.add(i) or ArrayList.add(pos, i)  
    ArrayList.remove(i)

### Abstract class and interface  
A class can only extends one abstract class, but can implements lots of interface.  
AlarmDoor is door with alarm, not alarm with door.  

    abstract class Door {  
     abstract void open();  
     abstract void close()；  
    }  

    interface Alarm {  
     void alarm();  
    }  

    class AlarmDoor extends Door implements Alarm {  
     void open() { … }  
     void close() { … }  
        void alarm() { … }  
    }  

### Multi-threading
    public class RunnableThread implements Runnable{
      public void run() {
        for (int i = 0; i < 5; i++)
        System.out.println("Runnable: " + i);
      }
    }

    Thread t = new ExtendedThread();
    t.start();
#### Join
    public static void main (String[] args) {
      PrintOddThread thread1 = new PrintOddThread();
      PrintEvenThread thread2 = new PrintEvenThread();

    thread1.start();
    thread2.start();

    try	{
    thread1.join();
    thread2.join();
    } catch	(InterruptedException e)	{
    System.exit(1);
    }
    System.out.println(“end	of	program”);
    }

#### Lock
    public	class	ThreadInterleaveSharedDataMutex {
      public static	int sharedData = 0;
      public static	Object lock	= new Object();	//	for	thread	synchronization

      static class MyThread extends Thread	{
        private	int id;
        public	MyThread(int i)	{
          id = i;
        }
        public void run() {
          synchronized(lock) {
            System.out.println("Thread " + id + " before update: " +	sharedData++);
            System.out.println("Thread " +	id + " after update:	" + sharedData);
          }
        }
    }
### Socket programming
Client sends request, Server provides services  
IP address identifies user machine  
Port number identifies the process  
Each IP packet contains  
source & destination IP address & port number  
Socket is a facility for machine to establish a process-to-process connection with another machine  
- Stream sockets: TCP  
- Datagram sockets: UDP  
#### TCP	Server
    public static void main(String[] args) throws Exception {

    // Create server socket listening on port
    int port = 1234; // port should be 1024-65535 (web server = 80)
    ServerSocket serverSocket = new ServerSocket(port);

    // Declare client socket
    Socket clientSocket;

    // Provide service continuously
    while (true) {
    clientSocket = serverSocket.accept();
    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
    request = in.readObject();

    // Process the request accordingly
    out.writeObject(result);
    out.flush();
    out.close();
    in.close();
    clientSocket.close();
    }
    }

#### TCP	Client
    public static void main(String[] args) throws Exception {

    // Bind the socket to the server with the appropriate port
    Socket socket = new Socket(<Server IP address>, 1234);

    // Setup I/O streams
    ObjectOutputStream out = new
    ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream in = new
    ObjectInputStream(socket.getInputStream());

    // Prepare the request, let req be the request
    out.writeObject(req);
    out.flush();
    result = in.readObject();
    }

### Sensor network
Challenge:
- Energy (Limited battery, may not be rechargeable, need to goto sleep most of the time, reduce data exchange by data aggregation)
- Time and location management (GPS is expensive)
- security and privacy
- fault tolerance (the network should work well under node failure)
- communication infrastructure
- maintenance (replacement may not be available, remote software upgrade)
