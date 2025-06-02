## Http Socket communication example in Java



#### Setup:
1. Start HttpSocketServer, starts on 8082 port by default
``` 
java -cp target/classes org.example.server.HttpSocketServer
 ```

2. Start HttpSocketClient, same as server, starts on 8082 port by default
``` 
java -cp target/classes org.example.client.HttpSocketClient
 ```
3. Client and server commands should be executed in project root, after starting client, communication logs will be printed in the terminal

#### Flow
- HttpSocketClient sends POST request to HttpSocketServer and receives response if successful 
- After POST HttpSocketClient sends GET to fetch previously created order

##### Expected output:
--- POST Response ---
Order 4cab837f-654f-4552-b187-761575021b68 created

--- GET Response ---
Order 4cab837f-654f-4552-b187-761575021b68 found
