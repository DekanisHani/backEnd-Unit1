package com.progettoWeek5.epicode.model;

import jakarta.persistence.*;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @SequenceGenerator(name = "device_sequence", sequenceName = "device_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_sequence")
    private Long id;

    private String name;
    private String type;
    private String status;
	public Device(Long id, String name, String type, String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
