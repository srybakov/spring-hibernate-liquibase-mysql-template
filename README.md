Template project
================================
This project is template that contains following functionality:
1. Login page. Authorization is implemented.
2. Forgot password page. Busines logic of this funtionality should be implemented by youself. 
3. User Cabinet page. You can access this page after successful authorization only. Secured by Spring Security.
4. Backend: the project contains well formed structure with base configuration. It's include:<br>
  *  web.xml<br>
  *  mvc-dispatcher-servlet.xml<br>
  *  static resources<br>
  *  jsp pages<br>
  *  properties for your project<br>
  *  persistense-beans.xml - persistense related beans configuration for DB access<br>
  *  project-beans.xml - project related beans configuration<br>
  *  security-beans.xml - Spring Security related beans configuration<br>
  *  liquibase configuration - for incremental migration of database<br>
  *  Domain, dao, controller, service - beans which implement base login functionality<br>

You can use this project as a "start point" for your applications to save time for base configuration.


Above functionalit is implemented with:<br/>
1. Spring MVC <br/>
2. Spring Security<br/>
3. MySQL as a database<br/>
4. Liquibase for database migration<br/>
5. Hibernate ORM<br/>
6. JSP
7. JavaScript

Default view of project is following (of course you can change it as you wish :)):<br>

1. This is default page when you deploy and accesss application<br>
![Login page](/screenshots/loginPage.png "Login page")<br>
2. A message that password or email incorrect appeared<br>
![Incorrect password page](/screenshots/incorrectMailPassword.png "Incorrect password page")<br>
3. This page appears when you click "Forgot Password" link<br>
![Password restore page](/screenshots/restorePassword.png "Password restore page")<br>
4. After a mail with password reminder was sent<br>
![Password restored page](/screenshots/restoredPassword.png "Password restored page")<br>
5. Finally - user cabinet page :)<br>
![User Cabinet page](/screenshots/userCabinet.png "User Cabinet page")<br>
