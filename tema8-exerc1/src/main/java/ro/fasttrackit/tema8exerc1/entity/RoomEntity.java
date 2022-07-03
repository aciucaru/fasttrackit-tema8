package ro.fasttrackit.tema8exerc1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class RoomEntity
{
	@Id
	@GeneratedValue
	private Integer id;
	private String number;
	private Integer etaj;
	private String hotelName;
	@OneToMany
	private ReviewEntity review;
	@OneToOne
	private RoomFacilitiesEntity roomFacilities;
	
	public RoomEntity() {}
	
	public RoomEntity(String number, Integer etaj, String hotelName, ReviewEntity review, RoomFacilitiesEntity roomFacilities)
	{
		if(number != null)
			this.number = number;
		
		if(etaj != null)
		{
			if(etaj >= 0)
				this.etaj = etaj;
		}
		
		if(hotelName != null)
			this.hotelName = hotelName;
		
		if(review != null)
			this.review = review;
		
		if(roomFacilities != null)
			this.roomFacilities = roomFacilities;
	}
}
