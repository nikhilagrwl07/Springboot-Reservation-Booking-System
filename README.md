S.no | Annotation | Meaning | 
--- | --- | --- |
1 | @SpringbootApplication | @Configuration + @ComponentScan + @EnableAutoConfiguration
2 | @Configuration | tags or mark a class as bean definition for application context
3 | @ComponentScan | tells Spring to look for other components, configurations and services in com.nikhil.RestaurantReservation
4 | @EnableAutoConfiguration | tells Spring Boot to start adding beans based on class path settings, other beans, and various property settings.
5 | @RestController | @Controller + @ResponseBody
6 | @PathVariable | is from spring. Used in Spring so it works in MVC and REST. Used with @GetMapping
7 | @PathParam | is from JAX-RS. can use with REST only
8 | @RequestBody | If a method parameter is annotated with @RequestBody, Spring will bind the incoming HTTP request body(for the URL mentioned in @RequestMapping for that method) to that parameter. While doing that, Spring will behind the scenes use HTTP Message converters to convert the HTTP request body into domain object deserialize request body to domain object, based on ACCEPT or Content-Type header present in request.
9 | @ResponseBody | If a method is annotated with @ResponseBody, Spring will bind the return value to outgoing HTTP response body. While doing that, Spring will behind the scenes use HTTP Message converters to convert the return value to HTTP response body serialize the object to response body, based on Content-Type present in request HTTP header. As already mentioned, in Spring 4, you may stop using this annotation.

