all:
	mvn package
run:
	mvn spring-boot:run
koding:
	export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64
	sudo service apache2 stop
	sudo mvn spring-boot:run