## Addressbook-JSF-JPA
This is a java web project. It has been developed to keep notes about names, e-mails, addresses and phone numbers of people in digital form.

#### Prerequisites
* JDK 1.8
* Tomcat 
* Maven 3.0+

#### Used Technologies
* JSF (2.2)
* Hibernate JPA (5.2) 
* MySQL 
* Maven

#### Build and Run
##### 1-Create a MySQL database on linux via command line
```
CREATE DATABASE addressbook_db CHARACTER SET utf8 COLLATE utf8_general_ci;
```

##### 2-From Eclise
Import as Existing Maven Project and right click on Project -> Maven -> Update Project. 

##### 3-Edit src/main/resources/META-INF/persistence.xml file
```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/addressbook_db" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="password" />
```

##### 4-Using the terminal
Go on the project's root folder, then type:
```
$ mvn clean install
```


That's it.

Finally, You can run the project.

