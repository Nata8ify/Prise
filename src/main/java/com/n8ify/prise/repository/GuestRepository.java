package com.n8ify.prise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n8ify.prise.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
	public List<Guest> findByEventId(int eventId);
}
