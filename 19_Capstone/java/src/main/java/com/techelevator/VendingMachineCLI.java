package com.techelevator;

import com.techelevator.Business.InventoryDao;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] SECOND_MENU_OPTION = {"Feed Money", "Select Product", "Finish Transaction"};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				InventoryDao inv = new InventoryDao();
				inv.createMapItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchaseMenu();
			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				// exit program
				System.exit(1);
			}
		}
	}
	public void purchaseMenu(){
		String choice2 = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTION);
		if (choice2.equals("Feed Money")){
			//do feed money
		}else if(choice2.equals("Select Product")){
			//do select product
		}else if(choice2.equals("Finish Transaction")){
			//do finish transaction
		}

}
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


}
