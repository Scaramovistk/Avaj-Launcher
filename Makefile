NAME = Main

all:
	find . -name "*.java" > sources.txt
	javac -sourcepath . @sources.txt
	java ${NAME} scenario.txt

re: clean all

clean:
	find . -name \*.class -type f -delete

fclean: clean
	rm -rf *.html
	rm -rf *.js
	rm -rf *.css
	rm -rf *.zip
	rm -rf resources
	rm -rf simulation.txt
	rm -rf sources.txt
