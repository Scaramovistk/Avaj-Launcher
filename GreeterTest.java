public class GreeterTest
{
	public static void main(String[] args)
	{
		Greeter test = new Greeter("World");
		String message = test.sayHello();
		System.out.println(message);
	}
}