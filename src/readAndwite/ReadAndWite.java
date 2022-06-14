package readAndwite;

import product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWite {
    File file = new File("product.csv");

    public void Write(List<Product> products){
        try{
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("mã sản phẩm,tên,giá,số lượng,mô tả");
            bufferedWriter.newLine();
            for (Product p:products){
                bufferedWriter.write(p.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Product> reader() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double price =Double.parseDouble(arr[2]);
                int amount = Integer.parseInt(arr[3]);
                String describe = arr[4];

                products.add(new Product(id, name, price, amount, describe));
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
