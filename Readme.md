Behind this project:
Used https://start.spring.io/ for structure of the project
Used https://www.db4free.net/ for MySQL Database
Installed Maven through Homebrew
Installed Tomcat via Homebrew
Installed JDK 17

Took a couple of hours in the morning today for learning and understanding. Initially thought of using a boilerplate but decided to go with building from scratch as I can learn a lot on the way.
Referred to this article for setting up the first API: https://stackabuse.com/build-a-spring-boot-rest-api-with-java-full-guide/
After countless errors and browsing for solutions on Google, majorly Stackoverflow, I was able to get the project up and running.

Couldn't get time to add the following features:
Get slots (Tried doing that in a MySQL Query, wasted some time. Couldn't figure out how to loop through the result since it was of type List<Appointment>)
Auto assign an operator (Was running out of time, will try to add tomorrow if I get some time)

Future Scope:
JWT authorization for the APIs
Holiday and Work timings to be considered