CIC Repositories
================

1. **cic-core**
  * provides core domain logic + common utilities
  * runs mainly Scala with some Java interfaces
  * should be the only dependency of the other projects
  * no other projects will be pushed to Maven without **serious** debate
  * **no other projects should have interdependencies**

2. **cic-api-inbound-micro**
  * provides API endpoints for inbound event traffic
  * this API runs Scala on Play
  * this API will be heavily concurrent in some form

3. **cic-api-outbound-micro**
  * provides API endpoints for loading detailed objects + object graphs
  * provides API endpoints for loading and filtering lists of objects and
  * provides API endpoints for managing customer installs + settings
  * provides API endpoints for registering external event providers (i.e. SaaS modules)
  * this API runs Scala on Play and Java on Spring Boot
  * most of this API will be heavily concurrent in some form
  * plan to split this out further in the future to facilitate granular deployments:
    * cic-api-registration-micro
    * cic-api-search-micro
    * cic-api-settings-micro
    * before split will confirm development deployment options to run from a single docker image

4. **cic-message-ingest-micro**
  * provides (most of) the message queue ingest logic
  * runs Flume with custom sinks in Java

5. **cic-stream-processing-micro**
  * provides stream processing logic
  * runs primarily Stream D pipeline notation for now
  * will include some DDD influence of some kind in the future (TBD)

6. **cic-notification-service-micro**
  * provides notification service logic (i.e. email, sms, web hooks)
  * runs Scala with Akka to manage heavy concurrency and variable stability of the external APIs it interacts with

7. **cic-ui-micro**
  * provides the UI logic
  * runs from Play now; will run from static HTTP server (Apache)
  * contains primarily UI artifacts (javascript, less/css, html)
  * runs "behind" X-Main
  * will confirm development deployment options to run in the cic-outbound-api-micro docker image
