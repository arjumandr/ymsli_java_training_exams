package test_module_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ques1 {
	public static void main(String[] args) {
		File data = new File("/C:/Users/VE00YN363/Desktop/spring/java/day1/src/test_module_1/input.txt");
		List<MerchandiseInventory> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;
            while((line = br.readLine()) != null) {
            	String[] words = line.split(" ");
            	MerchandiseInventory merch = new MerchandiseInventory(words[0], Integer.valueOf(words[1]), Double.parseDouble(words[2]));
            	list.add(merch);
            	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("Items sorted in asc order of ItemID: ");
		list.sort(new MerchandiseIdComparator());
		System.out.println(list);
		System.out.println("Items sorted in desc order of Price: ");
		list.sort(new MerchandisePriceComparator());
		System.out.println(list);
	}
}
