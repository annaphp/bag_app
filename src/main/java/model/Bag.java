package model;

public class Bag {
	
	Type type;
	String name;
	String description;
	Long price;
	Long id;
	
	public Bag(Long id, Type type, String name, String descrition, Long price) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = descrition;
		this.price = price;
	
	}

	public Bag(Type type, String name, String description, Long price) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Bag() {
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setFeatures(String features) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bag [type=" + type + ", name=" + name + ", description=" + description + ", price=" + price + ", id="
				+ id + "]";
	}
	
	
	
	
	
	
	
	

}
