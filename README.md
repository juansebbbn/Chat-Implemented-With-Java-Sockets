Socket Chat - Messaging Application

A lightweight, multi-client chat application implemented in Java using TCP Sockets for real-time, bi-directional communication.

📖 Description

This application allows multiple clients to establish concurrent connections to a central server. The server acts as a message broker, dynamically managing active clients and routing private messages between them using unique client identifiers (IDs).

📁 Project Structure

Server.java: The central coordinator. It listens for incoming connection requests, maintains an active registry of client sessions, and handles packet routing.

Cliente.java: The client-side application. It establishes a socket connection to the server, manages local UI/console interactions, and handles sending and receiving messages.

✨ Features

Multi-Client Concurrency: Supports multiple simultaneous client connections using multi-threading.

Targeted Message Routing: Send messages directly to specific users utilizing their unique client IDs.

Non-Blocking I/O: Separate dedicated threads handle message listening on the client side, ensuring the UI/console input remains responsive.

TCP Reliability: Built on top of the TCP protocol to guarantee ordered, lossless delivery of chat messages.

In-Memory History: Temporary message buffering utilizing local data structures (HashMap) on the client side.

🚀 How to Run

Follow these steps to compile and run the application locally.

1. Compilation

Compile both the Server and Client source files using the Java compiler:

javac Server.java Cliente.java


2. Start the Server

Launch the server coordinator first. By default, it will bind to port 8081:

java Server


💡 System Note: Ensure port 8081 is free and not blocked by local firewalls.

3. Launch Clients

Open a new, separate terminal window for each client instance you want to run:

java Cliente


⚙️ Requirements

Java Development Kit (JDK): Version 8 or higher.

Network: An available TCP socket on port 8081 (default local host execution).

🛠️ Implementation Details

Client Threading: Each client spawns a background listener thread immediately after connecting. This prevents incoming network data reads from blocking user input.

Connection Management: The server maps active connections inside a thread-safe registry to prevent resource conflicts or race conditions during rapid client logins/logouts.

🗺️ Planned Roadmap

Future iterations of this project will shift from a basic prototype to a production-ready messaging architecture:

Structured Domain Models: Refactor plain-text payloads into formal object representations (User, Message, Conversation).

Persistent Storage: Replace in-memory HashMap structures with a relational database schema (MySQL or PostgreSQL) using an ORM.

Layered Software Architecture: Re-organize the codebase into standard enterprise patterns (Controllers, Services, and Repositories) to improve overall testability and decoupling.
