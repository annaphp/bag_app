import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import model.Bag;
import model.Type;
import repository.BagRepository;
import repository.TypeRepository;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TypeRepository tr = context.getBean("typeRepository", TypeRepository.class);
		BagRepository br = context.getBean("bagRepository", BagRepository.class);
		
		// testing Type save()
		Type type = new Type("lunch bag");
		System.out.println("===Testing Type save() Start===");
	//	System.out.printf("New Type inserted with id: %d \n", tr.save(type));
		System.out.println("===Testing Type save() End===");
		System.out.println();
		
		// testing Type findAll
		System.out.println("===Testing Type findAll() Start===");
		for(Type t : tr.findAll()){
			System.out.println(t);
		}
		System.out.println("===Testing Type findAll() End===");
		System.out.println();
		
		//testing Bag save()
		Bag bag = new Bag(tr.findByName("messanger bag"),"S Bag", "Very large",(long)600);
		System.out.println("===Testing Bag save() Start===");
	//	System.out.println("New Bag inserted with id:" + br.save(bag));
		System.out.println("===Testing Bag save() End===");
		System.out.println();

		//testing Bag findAll()
		System.out.println("===Testing Bag findAll() Start===");
	    for(Bag b : br.findAll()){
		System.out.println(b);
		}
		System.out.println("===Testing Bag findAll() End===");
		System.out.println();
		
		
		//testing Bag findbyType()
		System.out.println("===Testing Bag findByType() Start===");
		Type t = tr.findByName("messanger bag");
		for(Bag b : br.findByType(t)){
			System.out.println(b);
		}
		System.out.println("===Testing Bag findByType() End===");
		System.out.println();
		

		//testing Bag update()
		System.out.println("===Testing Bag update() Start===");
		Bag bagtoUpdate = br.findByName("S Bag");
		System.out.println("Book before price update: " + bagtoUpdate);
		br.updatePrice(bagtoUpdate, (long)200.00);
		System.out.println("Book after price update: " +br.findByName("S Bag"));
		System.out.println("===Testing Bag update() End===");
		System.out.println();
		
		
		//testing Bag delete()
		System.out.println("===Testing Bag delete() Start===");
		Bag bagToDelete = br.findByName("S Bag");
		br.delete(bagToDelete);
	    System.out.println("Book deleted:  Id: " + bagToDelete.getId() + ", Name:" + bagToDelete.getName());
		System.out.println("Total books in Book table: ");
		for(Bag b : br.findAll()){
			System.out.println(b);
		}
		System.out.println("===Testing Bag delete() End===");
		System.out.println();	
		

	}

}
