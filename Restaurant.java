import java.util.*;
class Restaurant
{
	static String name ;
	static long contact ;
	static String address;
	static ArrayList<String> basket = new ArrayList<>();
	
    public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		for (; ; )
		{
			System.out.println();
		    System.out.println("____________Aaba ka Dhaba____________ ");
		    System.out.println("            _____________              ");
			System.out.println("           *Naad Karti Ky*");
			System.out.println();
			System.out.println("1. Create Account");
			System.out.println("2. Existing User");
			System.out.println();
			System.out.print("Enter an option : ");
			int opt=sc.nextInt();
			System.out.println();
			switch(opt)
			{
				case 1 : createAccount(sc);break;
				case 2 : login(sc);break;
				default : System.out.println("Invalid Input");
				         break;
			}
		}
	}
	public static void createAccount(Scanner sc)
	{
		System.out.println("       REGISTRATION");
		System.out.println();
		System.out.print("Name : ");
		name=sc.next();
		System.out.print("Phone : ");
		contact=sc.nextLong();
		System.out.print("Address : ");
		sc.nextLine();
		address=sc.nextLine();
		System.out.println();
		System.out.println("Account Created Successfully!!");
	}
	public static void login(Scanner sc)
	{
		if (name==null)
		{
			System.out.println("CREATE YOUR ACCOUNT FIRST!!");
			return;
		}
		System.out.print("    LOGIN");
		System.out.println();
					
		for (int attempt=3;attempt>=1 ;attempt-- )
		{
			System.out.print ("Username : ");
			String username=sc.next();
			System.out.print("Password : ");
			long phone=sc.nextLong();
			System.out.println();
			if (name.equals(username)&& contact==phone)
			{
				homePage(sc);
			}else{
				System.out.print(" INVALID CREDENTIALS");
				System.out.print(" Attempt left : "+(attempt-1));
				System.out.println();
			}
		}
		System.out.println("THANK YOU & NEVER VISIT AGAIN");
		System.exit(0); //terminate the exec
	}
	public static void homePage(Scanner sc)
	{
		for (; ; ) {
			System.out.println("       HOMEPAGE");
		System.out.println();
		System.out.println("1. Menu");
		System.out.println("2.Orders");
	    System.out.println("3.Table Booking");
		System.out.println("4.Logout");
		System.out.println();
		System.out.println(" Enter the Option ");
		int opt = sc.nextInt();
				
		switch (opt)
		{
		    case 1 : menu(sc);break;
		    case 2 : order(sc);break;
		    case 3 : tableBooking(sc);break;
		    case 4 : System.out.println("THANK U & VISIT AGAIN");
		             System.exit(0);break;
		    default : System.out.println("INVALID INPUT");break;
        }
		}
    }

				public static void menu(Scanner sc)
				{
								for (;;)
								{
									System.out.println();
									System.out.println("___________MENU___________");
									System.out.println("101 : Shahi_Paneer - 250 ");
									System.out.println("102 : Veg_Kolhapuri - 230 ");
									System.out.println("103 : Special_Thali - 120 ");
									System.out.println("104 : Dhavara_Chicken_Thali - 280 ");
									System.out.println("105 : Tehelka Omlette - 120 ");
									System.out.println("106 : Roti - 25 ");
									System.out.println("107 : Exit Menu ");
									System.out.println();
									System.out.print("Enter the Food Id : ");
									int id = sc.nextInt();
									switch(id)
									{
									case 101:{
										basket.add("101 : Shahi_Paneer - 250 ");
										System.out.println("Shahi Paneer added inside the Basket");
										break;
									}
									case 102:{
										basket.add("102 : Veg_Kolhapuri - 230  ");
										System.out.println("Veg_Kolhapuri added inside the Basket");
										break;
									}
									case 103:{
										basket.add("103 : Special_Thali - 120  ");
										System.out.println("Special_Thali added inside the Basket");
										break;
									}
									case 104:{
										basket.add("104 : Dhavara_Chicken_Thali - 280 ");
										System.out.println("Dhavara_Chicken_Thali added inside the Basket");
										break;
									}
									case 105:{
										basket.add("105 : Tehelka Omlette - 120  ");
										System.out.println("Tehelka Omlette added inside the Basket");
										break;
									}
									case 106:{
										basket.add("106 : Roti - 25");
										System.out.println("Roti added inside the Basket");
										break;
									}
								    case 107:{
										return ;
									}
								default:{
									System.out.print("INVALID FOOD ID");
									break;
								}
							}  
						}
					}
					public static void order(Scanner sc)
					{
						System.out.println();
						System.out.println("_____ORDERS_____");
						System.out.println();
						if(basket.size()==0){
							System.out.println("BASKET IS EMPTY ADD FOOD ITEMS");
						}
						for(String foodItem : basket){
							System.out.println(foodItem);
						}
						System.out.println();
						System.out.print("1. Cancel Order");
						System.out.print("2. Remove Food Item");
						System.out.print("3. Proceed To Payment");
						System.out.println();
						System.out.print("Enter the Option");
						int opt=sc.nextInt();
						System.out.println();
						switch(opt)
						{
						case 1 :{
							System.out.println("Order Cancelled");
							basket.clear();
							break;
						}
					    case 2 :{
							System.out.println("Enter FoodId : ");
							int foodId=sc.nextInt();
							removeFoodId(foodId);
							break;
						}
					    case 3 :{
					    	billGenrate();
					    	break;
					    }
					}
						
				}
				public static void removeFoodId(int foodId)
				{
					ArrayList<String> dupBasket = new ArrayList<>(basket);
					int indx=0;
					boolean flag=false;
					for(String foodItem : dupBasket){

						String [] arr=foodItem.split(" ");
						if(arr[0].equals(foodId+""))
						{
							dupBasket.remove(indx);
							flag=true;
							System.out.println("FOOD ITEM REMOVED");
						}
						indx++;
					}
					if(!flag)
						System.out.println("Food Item doesn't Exist in Basket");

					basket=dupBasket;
				}
				public static int tableBooking(Scanner sc)
				{
					System.out.println();
					System.out.println("______TABLE BOOKING_____");
					System.out.println();
					System.out.println("Table no. 1");
					System.out.println("Table no. 2");
					System.out.println("Table no. 3");
					System.out.println("Table no. 4");
					System.out.println("Table no. 5");
					System.out.println();
					System.out.print("Which Table you want to book : ");
					int table=sc.nextInt();
					System.out.println();
					System.out.print("Table no. "+table+" is booked by "+name);
					return table;
				}
				public static void billGenrate()
				{
					double totalBill = 0;
					for(String foodItem : basket)
					{
						String [] arr = foodItem.split(" ");
						totalBill += Double.parseDouble(arr[4]);

					}
					System.out.println("Total Bill : "+ totalBill+" rs.");
				}
}