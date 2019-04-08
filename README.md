## Overview
This repository is using Uncle Bob's clean architecture approach.
Written in Java.

## Description
Clean architecture has four layers.

・Entity  
Entity represent bussiness rules.  
・Usecase  
Usecase represent application specific rules.  
・Controller/Gateway/Presenter  
It is interface adapter.  
・UI/Web/Device/DB/API

This repository has the following four packages.And this repository use Spring Boot Framework.  

## Installation

・Start MySQL container
~~~
docker-compose up -d
~~~

・API Demo Request 
~~~
mvn spring-boot:run
chmod u+x curl.sh
./curl.sh
~~~
