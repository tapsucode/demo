package edu.poly.spring.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.spring.entity.New;

public interface NewReponsitory extends JpaRepository<New, Long> {

}
