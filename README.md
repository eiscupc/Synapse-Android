# Synapse Android

## Installation

Go to [JitPack](https://jitpack.io/#eiscupc/Synapse-Android/1.0.0) and follow all steps to add synapse library to your android project.

## Usage

Once added Synapse for Android to your project, all functionalities are ready to use.

```java
// EXAMPLES
// Get Ip
ConnectMethods connectMethods = new ConnectMethods();
String myIpAddress = connectMethods.FindMyIpAddress(this);

// Find Servers
String port = "8080" // port number of WebSocket Server
List<String> possibleServers = new ArrayList<>();
possibleServers = connectMethods.FindServers(myIpAddress,port);
```

## Contributing

All feedback is welcome. If in doubt, communicate through the available means. For any changes, please open an issue first to discuss what you would like to change.
