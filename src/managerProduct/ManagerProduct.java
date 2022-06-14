package managerProduct;

import product.Product;
import readAndwite.ReadAndWite;
import sort.SortGiam;
import sort.SortTang;
import validateProduct.ValidateProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {

    List<Product> products = new ArrayList<>();
    ValidateProduct validateProduct =new ValidateProduct();
    Scanner scanner = new Scanner(System.in);
    ReadAndWite readAndWite =new ReadAndWite();

    public void manu(){
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. xem danh sách");
        System.out.println("2. thêm mới");
        System.out.println("3. cập nhật");
        System.out.println("4. xóa");
        System.out.println("5. sắp xếp");
        System.out.println("6. tìm kiếm sản phẩm có giá đắt nhất");
        System.out.println("7. đọc từ file");
        System.out.println("8. ghi từ file");
        System.out.println("9. thoát");

        int choice=Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                show();
                break;
            case 2:
                createProduct();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                sort();
                show();
                break;
            case 6:
                search();
                break;
            case 7:
                readAndWite.reader();
                break;
            case 8:
                readAndWite.Write(products);
                break;
            case 9:
                System.exit(0);
                break;
        }
    }
    public void show(){
        for (int i=0; i<products.size();i++){
            if((i+1)%5==0){
                System.out.println(products.get(i));
                scanner.nextLine();
            }else {
                System.out.println(products.get(i));
            }
        }
    }
    public Product create(){
            int id= validateProduct.validateID(products);
            String name = validateProduct.validateName("name: ");
            double price = validateProduct.validatePrice();
            int amount = validateProduct.validateAmount();
            System.out.println("5. Mô tả sản phẩm");
            String describe = scanner.nextLine();

        return new Product(id,name,price,amount,describe);
    }
    public void createProduct(){
        products.add(create());
    }
    public void update(){
        System.out.println(" Nhập id cần cập nhật");
        int id=Integer.parseInt(scanner.nextLine());
        int index=validateProduct.getIndexID(id,products);
        if (index !=-1){
            products.set(index,create());
        }else {
            System.out.println("id không tồn tại");
        }

    }
    public void delete(){
        System.out.println("Nhập id cần xóa");
        int id=Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexID(id,products);
        if(index !=-1){
            products.remove(index);
        }else {
            System.out.println("id không tồn tại");
        }
    }
    public void sort(){
        System.out.println("1. sắp xếp tăng dần");
        System.out.println("2. sắp xếp giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                products.sort(new SortTang());
                break;
            case 2:
                products.sort(new SortGiam());
                break;
        }
    }
    public void search(){
        products.sort(new SortTang());
        int index = products.size()-1;
        System.out.println( products.get(index));
    }
}
