# spring-scheduler
<h3>Spring Boot project which will use scheduler</h3>
<h4>There are 2 kind of scheduler: </h4>
<p>1 - Static: using @Scheduled(fixedRate)</p>
<p>2 - Dynamic: implementing SchedulingConfigurer</p>
<p> The application is exposing a REST API service: http://localhost:8080/com/scheduler/post/agenda?cron=??? </p>
<p> In the param "cron" you can inform how many milisecond do you want to change your dynamic scheduler </p>
