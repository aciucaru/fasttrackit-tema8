package ro.fasttrackit.tema8exerc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import ro.fasttrackit.tema8exerc1.repository.*;
import ro.fasttrackit.tema8exerc1.entity.RoomEntity;

@Service
public class RoomService
{
	private final RoomRepository repository;
	private final RoomDAO dao;
	
	public List<RoomEntity> getAll() { return repository.findAll(); }
	
	public List<RoomEntity> getAllBy(String number, Integer etaj, String hotel, Boolean tv, Boolean doubleBed)
	{
		List<RoomEntity> rooms = null;
		if(number != null && etaj != null && hotel != null && tv != null && doubleBed != null)
			rooms = repository.findAllBy(number, etaj, hotel, tv, doubleBed);
		
		return rooms;
	}
	
	public Optional<RoomEntity> getById(Integer id)
	{
		Optional<RoomEntity> optRoom = null;
		
		if(id != null)
			optRoom = repository.findById(id);
		else
			optRoom = Optional.ofNullable(null);
		
		return optRoom;
	}
	
	public Optional<RoomEntity> update(Integer id, JsonPatch updatedRoomEntity)
	{
		return repository.findById(id)
							.map(mapper -> applyPatch(mapper, updatedRoomEntity))
							.map(mapper -> replaceEntity(id, mapper))
							.orElseThrow(() -> new RuntimeException());
	}
	
    public Optional<RoomEntity> replaceEntity(Integer id, RoomEntity newEntity)
    {
    	Optional<RoomEntity> optRoom;
    	if(id != null)
    		optRoom = repository.findById(id);
        return optRoom;
    }
	
	private Optional<RoomEntity> applyPatch(RoomEntity room, JsonPatch updatedRoom)
	{
		try
		{
			ObjectMapper jsonMapper = new ObjectMapper();
			JsonNode jsonNode = jsonMapper.convertValue(room, JsonNode.class);
			JsonNode patchedJsonNode = updatedRoom.apply(jsonNode);
			return Optional.ofNullable(jsonMapper.treeToValue(patchedJsonNode, RoomEntity.class));
//			return jsonMapper.toEntity(jsonMapper.treeToValue(patchedJsonNode, RoomEntity.class));
		}
		catch(JsonProcessingException | JsonPatchException excep)
		{ throw new RuntimeException(excep); }
	}
	
	public Optional<RoomEntity> delete(Integer id)
	{
		Optional<RoomEntity> optRoom = null;
		
		if(id != null)
		{
			optRoom = repository.findById(id);
			if(optRoom.isPresent())
				repository.delete(optRoom.get());
		}
		else
			optRoom = Optional.ofNullable(null);
		
		return optRoom;
	}
}
