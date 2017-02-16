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

	public void setDescription(String description) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bag other = (Bag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
