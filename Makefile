NAME = be._42belgium.avaj.simulator.Simulator

all:
	find * -name "*.java" > sources.txt
	javac @sources.txt
	java $(NAME) scenario.txt

re: clean all

clean:
	find . -name "*.class" -type f -delete

fclean: clean
	rm -f simulation.txt sources.txt

.PHONY: all re clean fclean
