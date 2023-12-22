# SpringApp AWS

## Maven commands
> Generated documentation
* `mvn clean package`
> Built app-shaded.jar and ready to deploy it as aws lambda
* `mvn clean package shade:shade`

## Local deploy
> You can find each service under
* http://localhost:8080 

### Sample Request
> POST http://localhost:8080/rob \
--header 'Content-Type: application/json' \
--data '{
"money" : [5, 5, 10, 100, 10, 5]
}'