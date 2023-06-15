package com.progettoWeek5.epicode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progettoWeek5.epicode.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
