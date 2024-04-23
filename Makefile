NAME = Main

all:
	javac ${NAME}.java
	java ${NAME}

re: clean all

clean:
	rm -rf *.class