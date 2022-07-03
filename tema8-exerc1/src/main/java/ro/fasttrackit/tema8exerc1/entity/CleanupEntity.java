package ro.fasttrackit.tema8exerc1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "cleanups")
public class CleanupEntity
{
	@Id
	@GeneratedValue
	private Integer id;
	LocalDate date;
	@OneToMany
	private CleaningProcedureEntity cleaningProcedure;
	
	public CleanupEntity() {}
	
	public CleanupEntity(LocalDate date, CleaningProcedureEntity cleaningProcedure)
	{
		if(date != null)
			this.date = date;
		
		if(cleaningProcedure != null)
			this.cleaningProcedure = cleaningProcedure;
	}
}
