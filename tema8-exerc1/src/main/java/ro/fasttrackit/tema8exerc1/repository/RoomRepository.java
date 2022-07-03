package ro.fasttrackit.tema8exerc1.repository;

import ro.fasttrackit.tema8exerc1.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer>
{
	@Query("""
			select r from RoomEntity r where r.number=:number and
											r.etaj=:etaj and
											r.hotel=:hotel and
											r.tv=:tv and
											r.doubleBed=:doubleBed
			""")
	List<RoomEntity> findAllBy(@Param("number") String number,
								@Param("etaj")Integer etaj,
								@Param("hotel") String hotel,
								@Param("tv")Boolean tv,
								@Param("doubleBed")Boolean doubleBed);
}
