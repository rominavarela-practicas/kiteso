all:
	mvn package
tools:
	sudo add-apt-repository ppa:webupd8team/java
	sudo add-apt-repository ppa:andrei-pozolotin/maven3
	sudo apt-get -y update
	sudo apt-get install -y maven3
	sudo apt-get install -y oracle-java8-installer
	sudo apt-get install -y openjdk-7-jdk
	export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64
deploy:
	export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64
	sudo service apache2 stop
	sudo mvn spring-boot:run