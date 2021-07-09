package com.techelevator;

import com.techelevator.Business.InventoryDao;
import com.techelevator.Business.InventoryManager;
import com.techelevator.food.Item;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] SECOND_MENU_OPTION = {"Feed Money", "Select Product", "Finish Transaction"};

	private Menu menu;
	private Map<String, Item> itemMap;
	private InventoryManager manager;
	private Scanner scanner;

	public VendingMachineCLI(Menu menu) {
		this.itemMap = InventoryDao.createMapItems();
		this.manager = new InventoryManager(itemMap);
		this.menu = menu;
		this.scanner = new Scanner(System.in);
	}

	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems();

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
	private void displayItems(){
		for(Item item : itemMap.values()){
			System.out.println(item);

		}
	}
	public void purchaseMenu() {
		String choice2 = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTION);
		if (choice2.equals("Feed Money")) {
			feedMoney();

		} else if (choice2.equals("Select Product")) {
			//do select product
			purchaseItem();
		} else if (choice2.equals("Finish Transaction")) {
			//do finish transaction
			return;
		}
	}
	private void feedMoney(){
		String result = manager.feedMoney(new BigDecimal(10.00));
		System.out.println(result);

	}

	private void purchaseItem(){
		System.out.println("Please enter code: ");
		String code = scanner.nextLine();
		String result = manager.purchaseItem(code);
		System.out.println(result);
	}




	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		cli.purchaseMenu();
	}


}
