Socket Chat - Messaging Application:

Description:
  A simple chat application implemented in Java using TCP sockets for real-time communication between multiple clients.
  The application allows multiple clients to connect to a central server, which manages the routing of messages between them. Each client can send messages     to other clients identified by their unique ID.

Project Structure:
  Server.java: The server that accepts client connections, manages their identifiers, and routes messages between them.
  Cliente.java (Client): The client that connects to the server, sends, and receives messages from other clients.

Current Features:
  -Simultaneous connection of multiple clients to the server.
  -Message routing between clients.
  -Temporary in-memory message storage.
  -Communication via TCP sockets.
  -Multi-threading handling to manage concurrent connections.

How to Run
1.
  Compile:
  Bash,
  javac Server.java Cliente.java
  
2.
  Start the Server:
  Bash,
  java Server
  Note: The server will start listening on localhost:8081.

3.
  Run Clients:
  In a separate terminal window:
  Bash,
  java Cliente
  
  Requirements:
  Java 8 or higher.

Available TCP Socket on port 8081.

Implementation Notes:
  -Messages are stored in a HashMap within each client's memory.
  -The server dynamically manages active client connections.
  -Each client runs on its own thread to listen for incoming messages without blocking the UI/main execution.

