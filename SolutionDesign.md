## API


### 1、CustomerRemoteController

- this is an API for customers
* the first interface is ***register***
  * it means customer must register in our system at first,then he/she can do the business.

request:

| param name |  type  |  description   | required |
|:----------:|:------:|:--------------:|:--------:|
|    name    | String | customer name  |    Y     |
|   phone    | String | customer phone |    Y     |

response:

| param name |  type  |             description             | required |
|:----------:|:------:|:-----------------------------------:|:--------:|
|    code    | String | response code(200=success,500=fail) |    Y     |
|  message   | String |          response message           |    N     |
|    data    | Object |            response data            |    Y     |

<br/>

* the second interface is ***log off***
    * it means customer can log off from our system. when he/she don`t want to use our system.

request:

| param name |  type  |  description   | required |
|:----------:|:------:|:--------------:|:--------:|
|    name    | String | customer name  |    Y     |
|   phone    | String | customer phone |    Y     |

response:

| param name |  type  |             description             | required |
|:----------:|:------:|:-----------------------------------:|:--------:|
|    code    | String | response code(200=success,500=fail) |    Y     |
|  message   | String |          response message           |    N     |
|    data    | Object |            response data            |    Y     |


### 2、RentalCarRemoteController

- this is an API for rental business
* the first interface is ***rental car***
    * anybody wants to rental car, should call this interface.

request:

| param name        |  type   |              description               | required |
|:------------------|:-------:|:--------------------------------------:|:--------:|
| Customer          | Object  |             customer info              |    Y     |
| ---- name         | String  |             customer name              |    Y     |
| ---- phone        | String  |             customer phone             |    Y     |
| RentalInfo        | Object  |              rental info               |    Y     |
| ---- carModel     | String  |               car model                |    Y     |
| ---- rentalNumber | Integer |    how many cars you want to rental    |    Y     |
| ---- startTime    |  Date   |    when do you want to get the car     |    Y     |
| ---- durationTime |  Date   | how long do you want to rental the car |    Y     |
| ---- startArea    | String  | which area do you want to get the car  |    Y     |

response:

| param name |  type  |             description             | required |
|:----------:|:------:|:-----------------------------------:|:--------:|
|    code    | String | response code(200=success,500=fail) |    Y     |
|  message   | String |          response message           |    N     |
|    data    | Object |       response object is Car        |    Y     |

<br/>

* the second interface is ***return car***
    * anybody wants to return car, should call this interface.

request:

| param name        |  type   |              description               | required |
|:------------------|:-------:|:--------------------------------------:|:--------:|
| Customer          | Object  |             customer info              |    Y     |
| ---- name         | String  |             customer name              |    Y     |
| ---- phone        | String  |             customer phone             |    Y     |
| RentalInfo        | Object  |              rental info               |    Y     |
| ---- carModel     | String  |               car model                |    Y     |
| ---- rentalNumber | Integer |    how many cars you want to rental    |    Y     |
| ---- startTime    |  Date   |    when do you want to get the car     |    Y     |
| ---- durationTime |  Date   | how long do you want to rental the car |    Y     |
| ---- startArea    | String  | which area do you want to get the car  |    Y     |

response:

| param name |  type  |             description             | required |
|:----------:|:------:|:-----------------------------------:|:--------:|
|    code    | String | response code(200=success,500=fail) |    Y     |
|  message   | String |          response message           |    N     |
|    data    | Object |            response data            |    Y     |