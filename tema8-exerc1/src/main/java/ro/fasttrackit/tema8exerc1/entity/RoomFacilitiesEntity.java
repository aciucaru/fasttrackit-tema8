package ro.fasttrackit.tema8exerc1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_facilities")
public class RoomFacilitiesEntity
{
	@Id
	@GeneratedValue
	private Integer id;
	private Boolean hasTv;
	private Boolean hasDoubleBed;
	
	public RoomFacilitiesEntity() {}
	
	public RoomFacilitiesEntity(Boolean hasTv, Boolean hasDoubleBed)
	{
		if(hasTv != null)
			this.hasTv = hasTv;
		if(hasDoubleBed != null)
			this.hasDoubleBed = hasDoubleBed;
	}
}
