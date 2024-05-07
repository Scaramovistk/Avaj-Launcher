NAME = Main

all:
	javac ${NAME}.java
	java ${NAME} scenario.txt

re: clean all

clean:
	rm -rf *.class
	rm -rf *.html
	rm -rf *.js
	rm -rf *.css
	rm -rf *.zip
	rm -rf resources
	rm -rf simulation.txt