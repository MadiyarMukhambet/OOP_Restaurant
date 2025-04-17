package OOP.OurMenu;
import java.util.Scanner;


public class MenuController {
    private static MenuCRUD menuCRUD;

    public MenuController(MenuCRUD menuCRUD) {
        this.menuCRUD = menuCRUD;
    }
    public static void addDishToMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the new dish: ");
        String dishName = scanner.nextLine();
        System.out.print("Enter the price of the new dish: $");
        double dishPrice = scanner.nextDouble();
        System.out.print("Enter the description of the new dish: ");
        String dishDescription = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter to cooking time: ");
        int time = scanner.nextInt();
        MenuItem menuItem = new MenuItem();
        menuItem.setName(dishName);
        menuItem.setPrice(dishPrice);
        menuItem.setDescription(dishDescription);
        menuItem.setTime(time);
        MenuCRUD.addMenuItem(menuItem);
        /*System.out.println("The new dish, " + dishName + ", has been added to the menu with dish number " + newDishNumber);*/
    }
    public static void UpdateMenuItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the menu item you want to update: ");
        int menuItemId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the new name of the menu item: ");
        String newName = scanner.nextLine();

        System.out.print("Enter the new price of the menu item: $");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the new description of the menu item: ");
        String newDescription = scanner.nextLine();
        MenuItem UpdatedMenuItem = new MenuItem();
        UpdatedMenuItem.setName(newName);
        UpdatedMenuItem.setPrice(newPrice);
        UpdatedMenuItem.setDescription(newDescription);
        UpdatedMenuItem.setId(menuItemId);
        menuCRUD.updateMenuItem(UpdatedMenuItem);

    }
    public static void deleteMenuItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the menu item you want to delete: ");
        int menuItemId = scanner.nextInt();
        scanner.nextLine();
        menuCRUD.deleteMenuItem(menuItemId);
    }

        public static void getMenu(){
        MenuCRUD.displayMenu();
    }


}
