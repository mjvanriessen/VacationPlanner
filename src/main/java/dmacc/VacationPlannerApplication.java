package dmacc;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//
//import dmacc.beans.Activities;
//import dmacc.beans.Customer;
//import dmacc.beans.Resort;
//import dmacc.beans.Vacations;
//import dmacc.controller.BeanConfiguration;
//import dmacc.repository.ActivitiesRepository;
//import dmacc.repository.CustomerRepository;
//import dmacc.repository.ResortRepository;
//import dmacc.repository.VacationsRespository;

@SpringBootApplication
public class VacationPlannerApplication { // implements CommandLineRunner

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
		Customer c1 = appContext.getBean("customer", Customer.class);
		c1.setName("Lisa Simpson");
		c1.setAddress1("742 Evergreen Terrace");
		c1.setCity("Springfield");
		c1.setState("IL");
		c1.setZip("65619");
		CustomerRepo.save(c1);
		
		List<Customer> allMyCustomers = CustomerRepo.findAll();
		for(Customer customer: allMyCustomers) {
			System.out.println(customer.toString());
		}
		
		//Create resort using bean
		Resort r1 = appContext.getBean("resort", Resort.class);
		r1.setName("Jazz City Inn");
		r1.setAddress1("29 Blue Street");
		r1.setCity("New Orleans");
		r1.setState("LA");
		r1.setZip("70042");
		r1.setCost(450.00);
		ResortRepo.save(r1);
		
		List<Resort> allMyResorts = ResortRepo.findAll();
		for(Resort resort: allMyResorts) {
			System.out.println(resort.toString());
		}
		
		//Create activity using bean
		Activities a1 = appContext.getBean("activities", Activities.class);
		a1.setName("Jazz Camp");
		a1.setType("Art");
		a1.setCost(50.00);
		ActivitiesRepo.save(a1);
		
		List<Activities> allMyActivities = ActivitiesRepo.findAll();
		for(Activities activity: allMyActivities) {
			System.out.println(activity.toString());
		}
		
		//Create vacation using bean - couldn't get this to work, so didn't include
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
