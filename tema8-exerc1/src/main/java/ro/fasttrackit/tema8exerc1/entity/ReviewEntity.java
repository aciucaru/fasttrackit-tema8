package ro.fasttrackit.tema8exerc1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class ReviewEntity
{
	@Id
	@GeneratedValue
	private Integer id;
	private String message;
	private Integer rating;
	private String turist;
	
	public ReviewEntity() {}
	
	public ReviewEntity(String message, Integer rating, String turist)
	{
		if(message != null)
			this.message = message;
		
		if(rating != null)
		{
			if(rating >= 0)
				this.rating = rating;
		}
		
		if(turist != null)
			this.turist = turist;
	}
}
