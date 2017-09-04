package com.n8ify.prise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n8ify.prise.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	public List<Event> findByUserId(int userId);
}
