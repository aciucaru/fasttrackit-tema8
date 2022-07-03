package ro.fasttrackit.tema8exerc1.repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ro.fasttrackit.tema8exerc1.entity.*;

@Configuration
public class DataProvider
{
	@Bean
	CommandLineRunner initDataBase(RoomRepository repository)
	{
		ReviewEntity review1 = new ReviewEntity("Camera luxoasa si curata", 9, "Andrei");
		RoomFacilitiesEntity facilities1 = new RoomFacilitiesEntity(true, true);
		RoomEntity room1 = new RoomEntity("A1", 1, "Union Plaza", review1, facilities1);
		
		ReviewEntity review2 = new ReviewEntity("Camera foarte curata, mobilier modern si luxos", 10, "Mihai");
		RoomFacilitiesEntity facilities2 = new RoomFacilitiesEntity(true, true);
		RoomEntity room2 = new RoomEntity("A2", 1, "Union Plaza", review2, facilities2);
		
		ReviewEntity review3 = new ReviewEntity("Camera 5*, servire ireprosabila, recomand", 10, "Alex");
		RoomFacilitiesEntity facilities3 = new RoomFacilitiesEntity(true, true);
		RoomEntity room3 = new RoomEntity("B5", 2, "Union Plaza", review3, facilities3);
		
		ReviewEntity review4 = new ReviewEntity("Camera destul de curata, locatie centrala", 7, "Radu");
		RoomFacilitiesEntity facilities4 = new RoomFacilitiesEntity(true, false);
		RoomEntity room4 = new RoomEntity("12", 1, "Ambiance Hotel", review4, facilities4);
		
		ReviewEntity review5 = new ReviewEntity("Destul de ok petrnu 3*, baie curata", 8, "Olivia");
		RoomFacilitiesEntity facilities5 = new RoomFacilitiesEntity(true, false);
		RoomEntity room5 = new RoomEntity("13", 1, "Ambiance Hotel", review5, facilities5);
		
		ReviewEntity review6 = new ReviewEntity("Camera ingrijita, mobilier modern", 9, "Cosmin");
		RoomFacilitiesEntity facilities6 = new RoomFacilitiesEntity(true, false);
		RoomEntity room6 = new RoomEntity("28", 2, "Ambiance Hotel", review6, facilities6);
		
		return args -> {
			repository.save(room1);
			repository.save(room2);
			repository.save(room3);
			repository.save(room4);
			repository.save(room5);
			repository.save(room6);
		};
	}
}
