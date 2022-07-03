package ro.fasttrackit.tema8exerc1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cleaning_procedures")
public class CleaningProcedureEntity
{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private boolean outcome;
	
	public CleaningProcedureEntity() {}
	
	public CleaningProcedureEntity(String name, boolean outcome)
	{
		if(name != null)
			this.name = name;
		
		this.outcome = outcome;
	}
}
