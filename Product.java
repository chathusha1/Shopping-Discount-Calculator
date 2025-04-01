import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private double basePrice;
    private String membershipType;

    public Product(String productID, String productName, double basePrice, String membershipType) {
        this.productID = productID;
        this.productName = productName;
        this.basePrice = basePrice;
        this.setMembershipType(membershipType);
    }
    public String getMembershipType(){
        return membershipType;
    }
    public void setMembershipType(String membershipType){
        if(membershipType.equals("Premium Member")||membershipType.equals("Regular Member")|| membershipType.equals("Non-Member")){
            this.membershipType = membershipType;
        }else{
            this.membershipType="Non-Member";
        }
    }
    public double calculateFinalPrice(){
        double discount=0.0;
        if(membershipType.equals("Premium Member")){
            discount=0.20;
        }else if(membershipType.equals("Regular Member")){
            discount=0.10;
        }
        return basePrice-(basePrice-discount);
    }
    public double calculateFinalPrice(double seasonalDiscount){
        double priceAfterMemberShipDiscount=calculateFinalPrice();
        return priceAfterMemberShipDiscount-(priceAfterMemberShipDiscount*seasonalDiscount/100);
    }
    public void displayProductDetails(){
        System.out.println("Product ID: "+productID);
        System.out.println("Name: "+productName);
        System.out.println("Base Price: $"+basePrice);
        System.out.println("Membership Type:"+membershipType);
        System.out.println("Final Price(after discount):"+calculateFinalPrice());
        System.out.println();
    }

    public static void main(String[] args) {
         Scanner input=new Scanner(System.in);

         Product[] products=new Product[3];
         products[0]=new Product("P1001","Laptop",1000.0,"Premium Member");
         products[1]=new Product("P1002","Smartphone",600.0,"Regular Member");
         products[2]=new Product("P1003","Headphones",200.0,"Non-Member");

         for(Product product:products){
             product.displayProductDetails();
         }

         System.out.print("Enter seasonal discount(%): ");
         double seasonalDiscount = input.nextDouble();
         System.out.println("Estimated price for Smartphone with extra "+seasonalDiscount+"%seasonal discount:$ "+products[1].calculateFinalPrice(seasonalDiscount));

         input.close();

    }
}
