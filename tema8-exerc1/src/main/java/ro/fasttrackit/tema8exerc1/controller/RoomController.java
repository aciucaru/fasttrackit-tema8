package ro.fasttrackit.tema8exerc1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.fge.jsonpatch.JsonPatch;

import ro.fasttrackit.tema8exerc1.entity.*;
import ro.fasttrackit.tema8exerc1.service.*;

@RestController
@RequestMapping("rooms")
public class RoomController
{
	private final RoomService service;
	
	public RoomController(RoomService service)
	{
		this.service = service;
	}
	
	@GetMapping
	List<RoomEntity> getAll() { return service.getAll(); }
	
	@GetMapping(value = "", params = {"number", "etaj", "hotel", "tv", "doubleBed"})
	List<RoomEntity> getAllBy(@RequestParam("number") String number,
								@RequestParam("etaj") Integer etaj,
								@RequestParam("hotel") String hotel,
								@RequestParam("tv") Boolean tv,
								@RequestParam("doubleBed") Boolean doubleBed)
	{
		return service.getAllBy(number, etaj, hotel, tv, doubleBed);
	}
	
	@GetMapping("{id}")
	RoomEntity getById(@PathVariable Integer id)
	{
		Optional<RoomEntity> optRoom = service.getById(id);
		
		if(optRoom.isPresent())
			return optRoom.get();
		else
			return null;
	}
	
	@PatchMapping("{id}")
	RoomEntity update(@PathVariable Integer id, @RequestBody JsonPatch updatedRoomEntity)
	{
		Optional<RoomEntity> optRoom = null;
		
		if(id != null && updatedRoomEntity != null)
			optRoom = service.update(id, updatedRoomEntity);
		
		if(optRoom.isPresent())
			return optRoom.get();
		else
			return null;
	}
	
	@DeleteMapping("{id}")
	RoomEntity delete(@PathVariable Integer id)
	{
		Optional<RoomEntity> optRoom = null;
		
		if(id != null)
			optRoom = service.delete(id);
		
		if(optRoom.isPresent())
			return optRoom.get();
		else
			return null;
	}
	
}
