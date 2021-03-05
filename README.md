# MukamSocket 

MukamSocket is a Android library for easy using Socket.

## Installation

Add MukamSocket library in your project.

```java
dependencies {
   implementation 'com.github.Mkurbanov:MukamSocket:1.0.0'
}
```

## Usage

```java
import com.mkurbanov.mukamsocket.MukamSocket;

MukamSocket mukamSocket;
mukamSocket = new MukamSocket(HOST, PORT);

//open socket
mukamSocket.openConnection();
Log.d(MukamSocket.LOG_TAG, "Соединение установлено");

//send data to socket
mukamSocket.sendData(text.getBytes());
Log.d(MukamSocket.LOG_TAG, "Отправка сообщения");

//close socket
mukamSocket.closeConnection();
Log.d(MukamSocket.LOG_TAG, "Соединение закрыто");
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
