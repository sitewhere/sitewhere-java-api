[![Maven Central](https://img.shields.io/maven-central/v/com.sitewhere/sitewhere-java-client.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.sitewhere%22%20AND%20a:%22sitewhere-java-client%22)

# SiteWhere Java Model and REST API Library

This repository contains the core Java API and data model used to interact
with REST services on a SiteWhere instance.

## Using the Java Client

The Java client wraps the Spring `RestTemplate` mechanism and takes care
of acquiring a JWT from the SiteWhere instance and storing it for use in the REST
API calls. A new client with the default settings may be created as follows:

```java
ISiteWhereClient client = SiteWhereClient.newBuilder().build().initialize();
```

The default settings are:

| Attribute   | Value        |
|:------------|:-------------|
| Protocol    | HTTP         |
| Hostname    | localhost    |
| Port        | 80           |
| Username    | admin        |
| Password    | password     |

Note that the `initialize()` method must be called before using the client. This sets
up the template and connects to the server to acquire a JWT.

To change the default connection settings use:

```java
SiteWhereClient.newBuilder().withConnectionTo("https", "myhost", 8081).build().initialize();
```

To connect as a different user user:

```java
SiteWhereClient.newBuilder().forUser("myuser", "mypassword").build().initialize();
```

## Interacting with the SiteWhere Model
Once the client has been initialized, methods on it may be invoked to interact with
the data model on the remote SiteWhere instance. There are two types of calls,
global calls and tenant-specific calls.

### Global Calls
For global calls, no extra information is required in order to make the invocation. 
For instance, to get the instance version information, invoke:

```java
Version version = client.getSiteWhereVersion();
```

The object model for all of the core SiteWhere data model is included with the client.

### Tenant Calls
For calls that are tenant-specific, more information must be passed along with each
method invocation. You must provide the tenant id and tenant authentication token
which are passed as headers to the REST call (along with the JWT used for all calls).
The format for tenant calls is:

```java
DeviceType type = getClient().getDeviceTypeByToken(SiteWhereClient.defaultTenant(), "galaxytab3");
```

for the default tenant installed with the contruction example data, or for an arbitrary tenant

```java
DeviceType type = getClient().getDeviceTypeByToken(SiteWhereClient.forTenant("token", "auth"), "galaxytab3");
```

using the unique token for the tenant and the tenant authentication token specific to that tenant.


