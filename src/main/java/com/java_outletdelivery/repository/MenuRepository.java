package com.java_outletdelivery.repository;

import com.java_outletdelivery.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByStock(Long stock);

    @Query("SELECT m from Menu m WHERE " +
        " m.name LIKE CONCAT('%', :query, '%') OR " +
        " m.description LIKE CONCAT('%', :query, '%')")
    List<Menu> searchMenus(String query);

}
