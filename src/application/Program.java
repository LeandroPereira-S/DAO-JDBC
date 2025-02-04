package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("---- Test 2: Seller findByDepartment ----");
		
		Department department = new Department(2, null);
		
		List <Seller> sell = sellerDao.findByDepartment(department);
		
		for(Seller s : sell) {
			System.out.println(s);
		}
		
		System.out.println("---- Test 3: findAll ---- ");
		
		sell = sellerDao.findAll();
		
		for(Seller s : sell) {
			System.out.println(s);
		}
		
		System.out.println("---- Test 4: Inset ----");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	
		System.out.println(" ---- Test 5: seller update ----");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
	
		System.out.println(" ---- Test 6: deleteById ----");
		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
	
	
		


