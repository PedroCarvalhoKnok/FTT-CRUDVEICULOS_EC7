package ec.marca.model;

import java.util.Objects;

import ec.vehicle.model.Vehicle;

public class Marca {
	
	private long id;
	private String descricaoMarca;
	
	
	public Marca() {
		
	}

	public Marca(String id,String descricaoMarca) {
		super();
		setId(id);
		setDescricaoMarca(descricaoMarca);
	}
	
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
public void setId(String id) {
		
		if (id.length()==0)
			setId(0);
		else
			setId(Long.valueOf(id));
	}
	
	public String getDescricaoMarca() {
		return descricaoMarca;
	}
	/**
	 * @param id the id to set
	 */
	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", descricaoMarca=" + descricaoMarca + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,descricaoMarca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Marca other = (Marca) obj;
		return Objects.equals(descricaoMarca, other.descricaoMarca);
	}

}





