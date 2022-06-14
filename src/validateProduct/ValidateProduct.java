package validateProduct;

import product.Product;

import java.util.List;
import java.util.Scanner;

public class ValidateProduct {
    Scanner scanner=new Scanner(System.in);


    public int validateID(List<Product>products){
        while (true){
            try{
                System.out.println("1. Nhập id: ");
                int id=Integer.parseInt(scanner.nextLine());
                if(getIndexID(id,products)!=-1){
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.out.println("Nhập id sai rồi:");;
            }
        }
    }

    public int getIndexID(int id, List<Product> products) {
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public String validateName(String name){
        while (true){
                System.out.println("2. Nhập tên: ");
                String str=scanner.nextLine();
                if (str.equals("")){
                    System.out.println("không để trống");
                }else {
                    return str;
                }
            }
        }
    public double validatePrice(){
        while (true){
            try {
                System.out.println("3. Nhập giá:");
                Double price=Double.parseDouble(scanner.nextLine());
                return price;
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại giá: ");
            }
        }
    }
    public int validateAmount(){
        while (true){
            try {
                System.out.println("4. Nhập số lượng: ");
                int amount=Integer.parseInt(scanner.nextLine());
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại số lượng: ");
            }
        }
    }

}
