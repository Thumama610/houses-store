package com.thumama;

public class House {
	private String type;
	private int size;
	private String location;
	private int rooms;
	private int bathrooms;
	private int floor;
	private int price;
	private int publisher_id;
	private String img_url;
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public House(int publisher_id, String type, int size, String location, int rooms, int bathrooms, int floor, int price, String img_url) {
		super();
		this.type = type;
		this.size = size;
		this.location = location;
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.floor = floor;
		this.price = price;
		this.publisher_id = publisher_id;
		this.img_url = img_url;
	}
	}
