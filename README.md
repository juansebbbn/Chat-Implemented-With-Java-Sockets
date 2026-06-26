# Socket Chat - Messaging Application

A Java socket-based messaging application that enables multiple clients to connect simultaneously to a central server. The server acts as a message broker, dynamically managing connected clients and routing private messages using unique client IDs.

---

## Features

* **Multi-Client Concurrency**

  * Supports multiple simultaneous client connections using multi-threading.

* **Private Message Routing**

  * Send messages directly to specific users through unique client identifiers.

* **Non-Blocking Client I/O**

  * Dedicated listener threads receive incoming messages while keeping the console responsive for user input.

* **Reliable Communication**

  * Built on the TCP protocol to ensure ordered and reliable message delivery.

* **In-Memory Message History**

  * Temporary message storage using Java `HashMap` collections on the client side.

---

## Project Structure

```text
Socket-Chat/

├── Server.java      # Central server responsible for client management and message routing
├── Cliente.java     # Client application for connecting and exchanging messages
└── README.md
```

### Server.java

The central coordinator of the application.

**Responsibilities:**

* Accept incoming client connections
* Maintain a registry of connected clients
* Route private messages between clients
* Manage active client sessions

---

### Cliente.java

The client-side application.

**Responsibilities:**

* Establish a socket connection with the server
* Handle console interaction
* Send and receive messages
* Maintain a local message history

---

## How to Run

### Prerequisites

* Java Development Kit (JDK) 8 or higher
* An available TCP socket on **port 8081** (default configuration)

---

### 1. Compile the Project

```bash
javac Server.java Cliente.java
```

---

### 2. Start the Server

Launch the server first:

```bash
java Server
```

> **Note:** Ensure port **8081** is available and not blocked by another application or firewall.

---

### 3. Launch Clients

Open a new terminal window for each client instance:

```bash
java Cliente
```

Each client will connect to the server and can begin exchanging private messages.

---

## Technical Details

### Multi-Threading

Each connected client runs a dedicated background listener thread that continuously waits for incoming messages without interrupting user input.

### Connection Management

The server maintains a thread-safe registry of active clients, allowing concurrent logins, logouts, and message routing without race conditions.

### Communication Protocol

* **Protocol:** TCP
* **Architecture:** Client–Server
* **Communication:** Private messaging between connected clients

### Data Structures

* `HashMap` for temporary client-side message storage
* Thread-safe client registry on the server

---

## Requirements

| Requirement | Version       |
| ----------- | ------------- |
| Java        | JDK 8+        |
| Network     | TCP Port 8081 |

---

## Future Improvements

* Group chat support
* Broadcast messaging
* Graphical user interface (JavaFX or Swing)
* Persistent message history
* User authentication
* Encrypted communication (SSL/TLS)
* File sharing support

---

## Author

**Juan**

## Version

**1.0.0**
