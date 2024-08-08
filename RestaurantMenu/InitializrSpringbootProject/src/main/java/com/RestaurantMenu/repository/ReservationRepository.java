package com.RestaurantMenu.repository;

import com.RestaurantMenu.entities.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    /*
     *  Filter by a date range
     */
    @Query(value = "SELECT p.* FROM tbl_reservation p WHERE p.appointment >= :dateMin AND p.appointment <= :dateMax", nativeQuery = true)
    public List<Reservation> findAppointmentDateRange(@Param("dateMin") String dateMin, @Param("dateMax") String dateMax);

    /*
     *  Verify limit reservation on time MAX RESERVATION 10
     */
    @Query(value = "SELECT count(*) nReservation  FROM tbl_reservation p WHERE p.appointment = :date AND p.time = :time", nativeQuery = true)
    public Long limitReservation(@Param("date") String date, @Param("time") String time);

}
