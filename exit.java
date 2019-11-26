import java.util.*;
class exit
{
	public static void main (String[] p)
	{
		int gain=0;
		craft[] item=new craft[50];
		int i=0;
		int count=0;
		String name=input("Item "+(i+1)+" :");
		while(!name.equalsIgnoreCase("exit"))
		{
			count++;
			item[i]=createnewitem(name);
			i++;
			name=input("Item "+(i+1)+" :");
		}
		print("\n");
		printmenu(item, count);
		int itemsold=Integer.parseInt(input("what have you just sold?"));
		
		while(itemsold!=0)
		{

			gain+=profit(item,itemsold);
			item=calc(item,itemsold);
			print("\n");
			printmenu(item,count);
			
			itemsold=Integer.parseInt(input("what have you just sold?"));

		}
		print("\n");
		print("You have the following stock left:");
		printmenu(item, count);
		print("\n");
		print("You have taken "+gain+" GBP today");

		System.exit(0);
	}

	public static craft createnewitem(String name)
	{
		craft article=new craft ();
		article.name=name;
		article.amount=Integer.parseInt(input("How much "+name+" have you bought: "));
		article.cost=Integer.parseInt(input("How much does a "+name+" cost in GBP?"));
		return article;
	}
	 
	public static void printmenu(craft[] item, int count)
	{
		for(int i=0; i<count;i++)
		{
			print((i+1)+": "+getname(item[i])+" : "+getamount(item[i])+" left at "+ getcost(item[i])+" GBP");
			
		}
	}
		
	public static craft[] calc(craft[] item, int itemsold)
	{
		item[itemsold-1].amount=item[itemsold-1].amount-1;
		return item;
	}

	public static int profit(craft[] item, int itemsold)
	{
		int g=0;
		g=getcost(item[itemsold-1]);
		return g;
	}



	public static String getname(craft c)
	{
		return c.name;
	}

	public static int getcost(craft c)
	{
		return c.cost;
	}

	public static int getamount(craft c)
	{
		return c.amount;
	}

	public static void print(String m)
	{
		System.out.println(m);
	}

	public static String input(String m)
	{
		Scanner scanner = new Scanner (System.in);
		print(m);
		return scanner.nextLine();
	}


}//end of class

class craft
{
	String name;
	int amount;
	int cost;
}


