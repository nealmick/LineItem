import java.util.Scanner;

public class LineItemApp
{
    
    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Welcome to the Line Item Calculator");
        System.out.println();

        // create 1 or more line items
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
            Validator v = new Validator();
            String productCode = v.getString(sc,
                "Enter product code: ");
            int quantity = v.getInt(sc,
                "Enter quantity:     ", 0, 1000);

            // get the Product object
            Product product = ProductDB.getProduct(productCode);

            // create the LineItem object
            LineItem lineItem = new LineItem(product, quantity);

            // display the output
            System.out.println();
            System.out.println("LINE ITEM");
            System.out.println("Code:        " + product.getCode());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price:       " + product.getFormattedPrice());
            System.out.println("Quantity:    " + lineItem.getQuantity());
            System.out.println("Total:       " +
                lineItem.getFormattedTotal() + "\n");

            // see if the user wants to continue
            choice = v.getString(sc, "Continue? (y/n): ");
            System.out.println();
        }
    }
}
