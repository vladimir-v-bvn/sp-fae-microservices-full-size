# sp-fae-microservices-full-size
full size microservices project
Technologies used:
sp-fae-discovery-server         - eureka discovery server
sp-fae-configuration-server     - config server - takes config from GitHub and sends it via RabbitMQ to servers
sp-fae-config-server-properties - properties files on GitHub
sp-fae-api-gateway-server       - logon server
sp-fae-keycloak-realm-settings  - keycloak realm settings
sp-fae-event-service            - shows list of events
sp-fae-order-service            - connects to inventory service with Feign client and Resilience4j, checks inventory
                                - sends messages through RabbitMQ to e-mail server
sp-fae-inventory-service        - checks inventory
sp-fae-email-service            - gets messages from RabbitMQ, sends e-mails 

