import java.util.Random;

/** An inventory tracking system to be used by In-N-Out
    @author Jordan Skaar
    @version 1.0
*/
public class InNOutDemo {
    
	public static void main(String[] args) throws EmptyStackException {
        // Random number generator
        Random r = new Random();
        int totalDeliveryItems = 0;     // Number of items in a delivery. Between 700 and 1000.
        int ingredient = 0;             // Number associated with an ingredient. Between 1 and 6.
        int daysUntilNextDelivery = 0;  // Number of days until next delivery. Between 3 and 6.
        int day = 1201;                 // Keeps track of the day of the month. Starts at Dec 1st.
        int expirationDate = 0;         // Date that an ingredient expires.
        int customer = 0;               // Keeps track of the customer number in a day.
        int customers = 0;              // Keeps track of the number of customers in an hour.
        int order = 0;                  // An order placed by a customer.
        int lostCustomerDay = 0;        // Keeps track of how many customers are lost in one day.
        int lostCustomerTotal = 0;      // Total lost customers in December.
        int wastedBuns = 0;             // wasted buns.
        int wastedPatties = 0;          // wasted patties.
        int wastedLettuce = 0;          // wasted lettuce.
        int wastedTomatoes = 0;         // wasted tomatoes.
        int wastedOnions = 0;           // wasted onions.
        int wastedCheese = 0;           // wasted cheese.
        int countItemOne = 0;           // How many burgers are ordered successfully.
        int countItemTwo = 0;           // How many cheeseburgers are ordered successfully.
        int countItemThree = 0;         // How many vegan lettuce wraps are ordered successfully.
        int countItemFour = 0;          // How many burgers without onions are ordered.
        int countItemFive = 0;          // How many cheese burgers without onions are ordered successfully.
        int countItemSix = 0;           // How many burgers without tomatoes are successfully ordered.
        String value;                   // Only there for the ArrayDictionary output from the add method.
        int previousCustomerOrdersSize = 0;     // Used in printing customer orders for each day.
        
		// Menu items
        // 1. Burger
        String[] burgerIngredients = {"bun", "patty", "lettuce", "tomato", "onion"};
        ArrayList<String> burger = new ArrayList<>(burgerIngredients.length);
        for (int i = 0; i < burgerIngredients.length; i++) {
            burger.add(burgerIngredients[i]);
//            System.out.println(burger.getLength());
//            System.out.println(burgerIngredients[i]);
        }
        System.out.print("\n");
        // 2. Cheeseburger
        String[] cheeseburgerIngredients = {"cheese", "bun", "patty", "lettuce", "tomato", "onion"};
        ArrayList<String> cheeseburger = new ArrayList<>(cheeseburgerIngredients.length);
        for (int i = 0; i < cheeseburgerIngredients.length; i++) {
            cheeseburger.add(cheeseburgerIngredients[i]);
//            System.out.println(cheeseburger.getLength());
//            System.out.println(cheeseburgerIngredients[i]);
        }
        System.out.print("\n");
        // 3. Vegan lettuce wrap
        String[] veganlettucewrapIngredients = {"lettuce", "lettuce", "tomato", "onion"};
        ArrayList<String> veganlettucewrap = new ArrayList<>(veganlettucewrapIngredients.length);
        for (int i = 0; i < veganlettucewrapIngredients.length; i++) {
            veganlettucewrap.add(veganlettucewrapIngredients[i]);
//            System.out.println(veganlettucewrap.getLength());
//            System.out.println(veganlettucewrapIngredients[i]);
        }
        System.out.print("\n");
        // 4. Burger without onion
        String[] burgerNoOnionIngredients = {"bun", "patty", "lettuce", "tomato"};
        ArrayList<String> burgerNoOnion = new ArrayList<>(burgerNoOnionIngredients.length);
        for (int i = 0; i < burgerNoOnionIngredients.length; i++) {
            burgerNoOnion.add(burgerNoOnionIngredients[i]);
//            System.out.println(burgerNoOnion.getLength());
//            System.out.println(burgerNoOnionIngredients[i]);
        }
        System.out.print("\n");
        // 5. Cheeseburger without onion
        String[] cheeseburgerNoOnionIngredients = {"cheese", "bun", "patty", "lettuce", "tomato"};
        ArrayList<String> cheeseburgerNoOnion = new ArrayList<>(cheeseburgerNoOnionIngredients.length);
        for (int i = 0; i < cheeseburgerNoOnionIngredients.length; i++) {
            cheeseburgerNoOnion.add(cheeseburgerNoOnionIngredients[i]);
//            System.out.println(cheeseburgerNoOnion.getLength());
//            System.out.println(cheeseburgerNoOnionIngredients[i]);
        }
        System.out.print("\n");
        // 6. Burger without tomato
        String[] burgerNoTomatoIngredients = {"bun", "patty", "lettuce", "onion"};
        ArrayList<String> burgerNoTomato = new ArrayList<>(burgerNoTomatoIngredients.length);
        for (int i = 0; i < burgerNoOnionIngredients.length; i++) {
            burgerNoTomato.add(burgerNoTomatoIngredients[i]);
//            System.out.println(burgerNoTomato.getLength());
//            System.out.println(burgerNoTomatoIngredients[i]);
        }
        System.out.print("\n");
        
        // Ingredient stacks
        // buns
        ArrayStack<Integer> buns = new ArrayStack();
        // patties
        ArrayStack<Integer> patties = new ArrayStack();
        // lettuce
        ArrayStack<Integer> lettuce = new ArrayStack();
        // tomatoes
        ArrayStack<Integer> tomatoes = new ArrayStack();
        // onions
        ArrayStack<Integer> onions = new ArrayStack();
        // cheese
        ArrayStack<Integer> cheese = new ArrayStack();
        
//        int bunnnnnn = 0;
//        int pattieee = 0;
//        int lettucee = 0;
//        int tomatooo = 0;
//        int onionnnn = 0;
//        int cheeseee = 0;
        // Initial delivery
        totalDeliveryItems = r.nextInt(300) + 701;
//        System.out.println(totalDeliveryItems);
        for (int i = 0; i < totalDeliveryItems; i++) {
            ingredient = r.nextInt(6) + 1;
//            System.out.println(ingredient);
            if (ingredient == 1) {
                // bun
//                System.out.println("Bun");
                expirationDate = day + 5;
                buns.push(expirationDate);
//                bunnnnnn++;
            }
            else if (ingredient == 2) {
                // patty
//                System.out.println("Patty");
                expirationDate = day + 4;
                patties.push(expirationDate);
//                pattieee++;
            }
            else if (ingredient == 3) {
                // lettuce
//                System.out.println("Lettuce");
                expirationDate = day + 3;
                lettuce.push(expirationDate);
//                lettucee++;
            }
            else if (ingredient == 4) {
                // tomato
//                System.out.println("Tomato");
                expirationDate = day + 3;
                tomatoes.push(expirationDate);
//                tomatooo++;
            }
            else if (ingredient == 5) {
                // onion
//                System.out.println("Onion");
                expirationDate = day + 5;
                onions.push(expirationDate);
//                onionnnn++;
            }
            else {
                // cheese
//                System.out.println("Cheese");
                expirationDate = day + 2;
                cheese.push(expirationDate);
//                cheeseee++;
            }
        }
// Show stacks of expiration dates. Checking to see if it's working properly
//        // buns
//        int i = 0;
//        int[] array = new int[buns.getLength()];
//        while (!buns.isEmpty()) {
//            array[i++] = buns.pop();
//        }
//        for (int j = array.length; j > 0; j--) {
//            System.out.println(array[j]);
//       }
//        System.out.println(bunnnnnn);
//        // patties
//        i = 0;
//        int[] array2 = new int[patties.getLength()];
//        while (!patties.isEmpty()) {
//            array2[i++] = patties.pop();
//       }
//        for (int j = array2.length; j > 0; j--) {
//            System.out.println(array2[j]);
//        }
//        System.out.println(pattieee);
//        // lettuce
//        i = 0;
//        int[] array3 = new int[lettuce.getLength()];
//        while (!lettuce.isEmpty()) {
//            array3[i++] = lettuce.pop();
//        }
//        for (int j = array3.length; j > 0; j--) {
//            System.out.println(array3[j]);
//        }
//        System.out.println(lettucee);
//        // tomatoes
//        i = 0;
//        int[] array4 = new int[tomatoes.getLength()];
//        while (!tomatoes.isEmpty()) {
//            array4[i++] = tomatoes.pop();
//        }
//        for (int j = array4.length; j > 0; j--) {
//            System.out.println(array4[j]);
//        }
//        System.out.println(tomatooo);
//        // onions
//        i = 0;
//        int[] array5 = new int[onions.getLength()];
//        while (!onions.isEmpty()) {
//            array5[i++] = onions.pop();
//        }
//        for (int j = array5.length; j > 0; j--) {
//            System.out.println(array5[j]);
//        }
//        System.out.println(onionnnn);
//        // cheese
//        i = 0;
//        int[] array6 = new int[cheese.getLength()];
//        while (!cheese.isEmpty()) {
//            array6[i++] = cheese.pop();
//        }
//        for (int j = array6.length; j > 0; j--) {
//            System.out.println(array6[j]);
//        }
//        System.out.println(cheeseee);
//        int check = bunnnnnn + pattieee + lettucee + tomatooo + onionnnn + cheeseee;
//        System.out.println(check);
        // Back to the program
        
        // Queue of customers
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        
        // Dictionary of customer's orders
        ArrayDictionary<String, String> customerOrders = new ArrayDictionary<>();
        String orderrrr;    // used in printing dictionary of customer orders
        for (int d = 1201; d <= 1231; d++) {     // increment each day of December
            System.out.println("Day " + (d - 1200));    // Print day number
            // Reset count of each menu item
            countItemOne = 0;
            countItemTwo = 0;
            countItemThree = 0;
            countItemFour = 0;
            countItemFive = 0;
            countItemSix = 0;
            if (daysUntilNextDelivery == 0) {
                // newDelivery
                totalDeliveryItems = r.nextInt(300) + 701;
                for (int i = 0; i < totalDeliveryItems; i++) {
                    ingredient = r.nextInt(6) + 1;
                    if (ingredient == 1) {
                        // bun
                        expirationDate = day + 5;
                        buns.push(expirationDate);
                    }
                    else if (ingredient == 2) {
                        // patty
                        expirationDate = day + 4;
                        patties.push(expirationDate);
                    }
                    else if (ingredient == 3) {
                        // lettuce
                        expirationDate = day + 3;
                        lettuce.push(expirationDate);
                    }
                    else if (ingredient == 4) {
                        // tomato
                        expirationDate = day + 3;
                        tomatoes.push(expirationDate);
                    }
                    else if (ingredient == 5) {
                        // onion
                        expirationDate = day + 5;
                        onions.push(expirationDate);
                    }
                    else {
                        // cheese
                        expirationDate = day + 2;
                        cheese.push(expirationDate);
                    }
                }
                daysUntilNextDelivery = r.nextInt(4) + 3;
            }
            lostCustomerDay = 0;
            for (int h = 10; h <= 19; h++) {    // increment hours in the day
                // customers that arrive
                customers = r.nextInt(100) + 1; // between 1 and 100 customers arrive
                if (customers > 50) {
                    lostCustomerDay += (customers - 50);    // lost customers in the day
                    customers = 50;
                }
                while (customers > 0) {
                    customer++;
                    order = r.nextInt(6) + 1;
                    // 1 = Burger, 2 = Cheeseburger, 3 = Vegan wrap, 4 = Burger no onions
                    // 5 = Cheeseburger no onions, 6 = Burger no tomatoes
                    if (order == 1) {
                        value = customerOrders.add("Customer " + customer + ":", "#1");
                        if ((buns.getLength() > 0) && (patties.getLength() > 0) && (lettuce.getLength() > 0) &&
                            (tomatoes.getLength() > 0) && (onions.getLength() > 0)) {
                                countItemOne += 1;
                                // Remove ingredients
                                buns.pop();
                                patties.pop();
                                lettuce.pop();
                                tomatoes.pop();
                                onions.pop();
                        }
                        else
                            lostCustomerDay += 1;
                    }
                    else if (order == 2) {
                        value = customerOrders.add("Customer " + customer + ":", "#2");
                        if ((cheese.getLength() > 0) && (buns.getLength() > 0) && (patties.getLength() > 0) &&
                            (lettuce.getLength() > 0) && (tomatoes.getLength() > 0) && (onions.getLength() > 0)) {
                                countItemTwo += 1;
                                // Remove ingredients
                                cheese.pop();
                                buns.pop();
                                patties.pop();
                                lettuce.pop();
                                tomatoes.pop();
                                onions.pop();
                        }
                        else
                            lostCustomerDay += 1;
                    }
                    else if (order == 3) {
                        value = customerOrders.add("Customer " + customer + ":", "#3");
                        if ((lettuce.getLength() > 0) && (tomatoes.getLength() > 0) && (onions.getLength() < 0)) {
                            countItemThree += 1;
                            // Remove ingredients (double lettuce)
                            lettuce.pop();
                            lettuce.pop();
                            tomatoes.pop();
                            onions.pop();
                        }
                        else
                            lostCustomerDay += 1;
                    }
                    else if (order == 4) {
                        value = customerOrders.add("Customer " + customer + ":", "#4");
                        if ((buns.getLength() > 0) && (patties.getLength() > 0) && (lettuce.getLength() > 0) &&
                            (tomatoes.getLength() > 0)) {
                                countItemFour += 1;
                                // Remove ingredients
                                buns.pop();
                                patties.pop();
                                lettuce.pop();
                                tomatoes.pop();
                        }
                        else
                            lostCustomerDay += 1;
                    }
                    else if (order == 5) {
                        value = customerOrders.add("Customer " + customer + ":", "#5");
                        if ((cheese.getLength() > 0) && (buns.getLength() > 0) && (patties.getLength() > 0) &&
                            (lettuce.getLength() > 0) && (tomatoes.getLength() > 0)) {
                                countItemFive += 1;
                                // Remove ingredients
                                cheese.pop();
                                buns.pop();
                                patties.getLength();
                                lettuce.getLength();
                                tomatoes.getLength();
                        }
                        else
                            lostCustomerDay += 1;
                    }
                    else {
                        value = customerOrders.add("Customer " + customer + ":", "#6");
                        if ((buns.getLength() > 0) && (patties.getLength() > 0) && (lettuce.getLength() > 0) &&
                            (onions.getLength() > 0)) {
                                countItemSix += 1;
                                // Remove ingredients
                                buns.pop();
                                patties.pop();
                                lettuce.pop();
                                onions.pop();
                        }
                        else
                            lostCustomerDay += 1;
                    }
                    customers--;
                }
            }
            // Wasted ingredients
            
            // Print number of customers lost today
            System.out.print("Lost customers on day " + (d - 1200) + ": ");
            System.out.println(lostCustomerDay);
            // Print wasted ingredients
            System.out.println("Number of wasted buns: 0");
            System.out.println("Number of wasted patties: 0");
            System.out.println("Number of wasted lettuce: 0");
            System.out.println("Number of wasted tomatoes: 0");
            System.out.println("Number of wasted onions: 0");
            System.out.println("Number of wasted cheese: 0");
            // Print number of each menu item that was successfully ordered
            System.out.println("Number of burgers served today: " + countItemOne);
            System.out.println("Number of cheeseburgers served today: " + countItemTwo);
            System.out.println("Number of vegan wraps served today: " + countItemThree);
            System.out.println("Number of burgers without onions served today: " + countItemFour);
            System.out.println("Number of cheeseburgers without onions served today: " + countItemFive);
            System.out.println("Number of burgers without tomatoes served today: " + countItemSix);
//            System.out.print("Total customers served: ");
//            System.out.println(customerOrders.getSize());
            // Print all customer orders for today
            for (int j = previousCustomerOrdersSize; j < customerOrders.getSize(); j++) {
                orderrrr = customerOrders.getValue("Customer " + (j + 1) + ":");
                System.out.println("Customer " + (j+1) + " -> " + orderrrr);
            }
            previousCustomerOrdersSize = customerOrders.getSize();
            daysUntilNextDelivery--;
        }
    }
}