#  Flight Application Demo

## About

This Application is for Planing flights and we use 4 flight pieces of information. These are airline_code, source and destination codes, and date of flight.
daily at most 3 flights for an airline between 2 destinations, this is only one rule for planing .
in this application we have 1 method and we can use it for get or post ."localhost:8080/Flights" 
if we call it with get method it shows list of all flights without any filters.
if we call it in post action with json data it will save the flight
if we use given data we we will get an error "There must be daily at most 3 flights for an airline between 2 destinations."
because we have initially inserted 3 flights in same day for that destinations.
For inserting flight you need to chose an other day or other parameters.


## Dependencies

- Spring Boot
- spring-boot-starter-data-jpa    => to connect Spring application with relational database efficiently
- spring-boot-starter-web         => used for building the web application, including RESTful applications
- h2                              => Database 
- spring-boot-devtools            =>includes an embedded LiveReload server that is used to trigger a browser refresh when a resource is changed
- lombok                          =>is an annotation-based Java library that allows you to reduce boilerplate code

### Sample post Request

```json
{
    "airline_code":"TK123",
    "source_airport_code":"SAW",
    "destination_airport_code":"ANK",
    "flight_date":"2022-12-31T13:31:03"
}
```

### Response of the post action

```json
{
    "id": 5,
    "airline_code": "TK123",
    "source_airport_code": "SAW",
    "destination_airport_code": "ANK",
    "flight_date": "2022-12-31T13:31:03.000+00:00"
}
```
