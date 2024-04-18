public class Greeter
{
	/**
	A class that make a simple great.
	@param aName
	 */
	public Greeter(String aName)
	{
		name = aName;
	}

	/**
	 Greet with a hello message.
	 @return a message that has "Hello, "
	 */
	public String sayHello()
	{
		return "Hello, " +  name + "!";
	}

	private String name;
}
