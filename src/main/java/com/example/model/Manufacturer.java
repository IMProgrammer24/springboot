package com.example.model;

public class Manufacturer {
	private int id;
	private String title;
	private String model;
	private String description;
	private String imageData;
	
	public Manufacturer() {
		super();
	}

	public Manufacturer(int id, String title, String model, String description, String imageData) {
		super();
		this.id = id;
		this.title = title;
		this.model = model;
		this.description = description;
		this.imageData = imageData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", title=" + title + ", model=" + model + ", description=" + description
				+ ", imageData=" + imageData + "]";
	}
}
