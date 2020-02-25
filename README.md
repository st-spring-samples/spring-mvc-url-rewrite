# Use-case
**Given** a semi monolith application (Petstore) exposing REST API endpoints for multiple resources with support for URI based API versioning
```$xslt
/v1/pets
/v1/orders
/v1/users
```
**When** a breaking change in introduced (with backward compatibility support) for one of the resources
```$xslt
/v1/pets
/v1/orders
/v2/orders
/v1/users
```
**Then** change versioning for all resources without making code changes
```$xslt
/v1/pets
/v2/pets
/v1/orders
/v2/orders
/v1/users
/v2/users
```
# Benefits (???)
Easy for consumers not to deal with a lot of different versions for different resources exposed by same applications
# Drawbacks
Unnecessarily increment version number for lot of other resources just because of a backward-incompatible change introduced for one resources
# Remarks
This is not a good situation to be in. But we are not living in an ideal world. From time to time we need to work with monolith applications and this could be a valid scenario in that context.
# Implementation detail
During application startup,
- Verify that application support multiple versions of APIs (`application.api.supportedVersions` configuration)
- For each mapping defined in the application, derive a new mapping with higher version (if one doesn't exist already)