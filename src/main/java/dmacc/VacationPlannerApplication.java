package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Activities;
import dmacc.beans.Customer;
import dmacc.beans.Resort;
import dmacc.beans.Vacations;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.ActivitiesRepository;
import dmacc.repository.CustomerRepository;
import dmacc.repository.ResortRepository;
import dmacc.repository.VacationsRespository;

@SpringBootApplication
public class VacationPlannerApplication  { // implements CommandLineRunner

	public static void main(String[] args) {
		SpringApplication.run(VacationPlannerApplication.class, args);
	}
	/*
	@Autowired
	VacationsRespository VacationsRepo;
	
	@Autowired
	CustomerRepository CustomerRepo;
	
	@Autowired
	ResortRepository ResortRepo;
	
	@Autowired
	ActivitiesRepository ActivitiesRepo;
	
	@Override
	public void run(String... args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Create Customer using bean
		Customer c = appContext.getBean("customer", Customer.class);
		c.setName("Lisa Simpson");
		c.setAddress1("742 Evergreen Terrace");
		c.setCity("Springfield");
		c.setState("IL");
		c.setZip(65619);
		CustomerRepo.save(c);
		
//		Customer c2 = appContext.getBean("customer", Customer.class);
//		c.setName("Marsha Brady");
//		c.setAddress1("11222 Dilling Street");
//		c.setCity("North Holywood");
//		c.setState("CA");
//		c.setZip(91602);
//		CustomerRepo.save(c);
		
//		List<Customer> allMyCustomers = CustomerRepo.findAll();
//		for(Customer customer: allMyCustomers) {
//			System.out.println(customer.toString());
//		}
		
		//Create resort using bean
		Resort r = appContext.getBean("resort", Resort.class);
		r.setName("Jazz City Inn");
		r.setAddress1("29 Blue Street");
		r.setCity("New Orleans");
		r.setState("LA");
		r.setZip("70042");
		r.setCost(450.00);
		ResortRepo.save(r);
		
//		Resort r = appContext.getBean("resort", Resort.class);
//		r.setName("Brady's Campsite");
//		r.setAddress1("2600 Franklin Canyon Drive");
//		r.setCity("Beverly Hills");
//		r.setState("CA");
//		r.setZip("90210");
//		r.setCost(120.00);
//		ResortRepo.save(r);
		
//		List<Resort> allMyResorts = ResortRepo.findAll();
//		for(Resort resort: allMyResorts) {
//			System.out.println(resort.toString());
//		}
		
		//Create activity using bean
		Activities a = appContext.getBean("activities", Activities.class);
		a.setName("Jazz Camp");
		a.setType("Art");
		a.setCost(50.00);
		ActivitiesRepo.save(a);
		
//		Activities a2 = appContext.getBean("activities", Activities.class);
//		a.setName("Blended Family Camp");
//		a.setType("Night Life");
//		a.setCost(120.00);
//		ActivitiesRepo.save(a);
		
//		List<Activities> allMyActivities = ActivitiesRepo.findAll();
//		for(Activities activity: allMyActivities) {
//			System.out.println(activity.toString());
//		}
		
		//Create vacation using bean
//		Vacations v1 = appContext.getBean("vacations", Vacations.class);
//		v1.setCustomer(c1);
//		v1.setResort(r1);
//		v1.setActivity(a1);
//		VacationsRepo.save(v1);
//		
//		List<Vacations> allMyVacations = VacationsRepo.findAll();
//		for(Vacations vacation: allMyVacations) {
//			System.out.println(vacation.toString());
//		}

		

		((AbstractApplicationContext) appContext).close();
		
	}
	*/

}
