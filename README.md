# SiteWhere Java Model and REST API Library
This repository contains the core Java API and data model used to interact
with REST services on a SiteWhere instance.

## Using the Java Client
The Java client wraps the Spring `RestTemplate` mechanism and takes care
of acquiring a JWT from the SiteWhere instance and storing it for use in the REST
API calls. A new client with the default settings may be created as follows:

```
ISiteWhereClient client = SiteWhereClient.newBuilder().build().initialize();
```

The default settings are:

| Attribute   | Value        |
|:------------|:-------------|
| Protocol    | HTTP         |
| Hostname    | localhost    |
| Port        | 8080         |

