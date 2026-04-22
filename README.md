# Chat con Sockets - Aplicación de Mensajería

Una aplicación de chat simple implementada en Java usando sockets TCP para la comunicación en tiempo real entre múltiples clientes.

## Descripción

La aplicación permite que múltiples clientes se conecten a un servidor central, el cual gestiona el envío de mensajes entre ellos. Cada cliente puede enviar mensajes a otros clientes identificados por su ID.

## Estructura del Proyecto

- **Server.java**: Servidor que acepta conexiones de clientes, gestiona sus identificadores y enruta los mensajes entre ellos.
- **Cliente.java**: Cliente que se conecta al servidor, envía y recibe mensajes de otros clientes.

## Características Actuales

-  Conexión de múltiples clientes al servidor
-  Envío de mensajes entre clientes
-  Almacenamiento temporal de mensajes en memoria
-  Comunicación mediante sockets TCP
-  Uso de hilos para manejar múltiples conexiones

## Cómo Ejecutar

### 1. Compilar
```bash
javac Server.java Cliente.java
```

### 2. Iniciar el Servidor
```bash
java Server
```
El servidor se iniciará escuchando en `localhost:8081`

### 3. Ejecutar Clientes
En otra terminal:
```bash
java Cliente
```

## Requisitos

- Java 8 o superior
- Socket TCP disponible en puerto 8081

## Notas de Implementación

- Los mensajes se almacenan en un `HashMap` en la memoria de cada cliente
- El servidor gestiona las conexiones activas de clientes
- Cada cliente corre en su propio hilo para recibir mensajes

---

##  Mejoras Futuras Planeadas

Se planea mejorar significativamente la arquitectura de la aplicación:

- **Modelos de Datos**: Implementar clases de dominio estructuradas (Usuario, Mensaje, Conversación)
- **Base de Datos**: Persistencia de mensajes y usuarios en una BD (MySQL/PostgreSQL)
- **Separación de Servicios**: Arquitectura en capas (Controllers, Services, Repositories) para mejor mantenibilidad y escalabilidad
