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

### Class

### Visibility/Access Modifier

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
- **this** can not be used in static method

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

It cannot be instantiated as object.
The subclass inherit it must implement all methods in abstract class.
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

### Interface & inheritance
#### Interface:  
1. used to define actions and behaviour to class, a class that **implements** the interface contains all the methods/CONSTANT (NO instance variable) of the interface
2. everything is **abstract** in interface
3. **abstract method** is a method header **without a method body**, a class that implements the interface MUST implement ALL methods.
4. CANNOT be instantiated (NEVER use **new** in interface), but it can be a type that referencing an object that implement the interface. 
E.g. InterfaceName a = new Classname();
P.S.
String class implements Comparable, we can compare strings

	ClassName implements Comparable  
	public int compareTo(Object other){  
	ClassName a = (ClassName) other;  
	…
	}

#### Inheritance:
1. a class that **extends** the class (superclass/parent class) is called subclass/ child class
2. child class contain all the methods/data from the parent
3. Only can extends 1 class
4. **protected** is used when the variable can be used by its child/ itself only
5. **final** is used when no class can be inherited from this class / this method cannot be overridden
6. In constructor of child class, the **no argument constructor** of the parent will be called automatically if we do not specify.
We can use **super( <Arg List>)** to invoke specific constructor of the parent class 
7. Child class can override methods in the parent class, the child class can invoke the not overrided method by super.methodName()
8. suppose A->B->C and they have a variable called test. To called test of A in C, we use ((A)this).test. NOT super.super.test
9. **abstract class** represent generic concept and cannot be instantiated, it can contains abstract/ non-abstract methods

### Polymorphism
Polymorphic reference is a variable that can refer to different types of objects at different points in time.
widening/narrowing conversion  
widening: assign child to parent reference  
narrowing: assig  parent to child reference  
利用父類別的型態  
接受子類別的物件  
做相同的動作  
引發不同的行為  
將相同的訊息傳遞給不同的物件，進而引發出不同的行為反應  
可使程式的執行不在於編譯時期決定，而延後到執行期間才動態決定呼叫何者。  

((Bird)animalList[0]).fly();  
((Dog)animalList[0]).bark();  
// invoke methods in a child class

//widening conversion

Animal a = new Bird(); 
Animal b= new Dog(); 

It is the type of the object being referenced, not the reference type, determines which method is invoked  

Polymorphism means that the sender of a stimulus does not need to know the receiving instance’s class. The receiving instance can belogin to an arbitrary class.

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

### Sorting 
Merge Sort
O(nlogn)
divide into half O(logn)
Combine, at most n-1 comparison -> O(n)
=> O(nlogn)

Quick Sort
Take the leftmost element as pivot
separate into two sublists with elements that are smaller/larger than the pivot
average case: half half => O(logn)
worst case (sorted list) => O(n)
Combine, at most n-1 comparison -> O(n)
=> average case = O(nlogn), worst case = O(n^2)

Bubble Sort
Compare the first one and the second one, if the first is larger than second, swap. Same for the second and the third one, and i-1 and i one. After this, the last element will be the largest. Repeat the process to i-2 and i-1, then i-3 and i-2.
O(n) scan
O(n) compare
n+(n-1)+(n-2)+... = O(n^2)

Insertion Sort
Take the first element in the array to sorted array.
compare the second element with elements in sorted array.
Insert in correct position.
O(n) scan
O(n) compare
1+2+...+(n-1)+(n) = O(n^2)