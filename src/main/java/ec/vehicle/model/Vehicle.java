package ec.vehicle.model;

import java.time.LocalDate;
import java.util.Objects;

//JavaBean >> Serializable, Geters Seters, default contructor, [toString, equals, hash]
//POJO - Plain Old Java Objects

//https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
//https://sites.google.com/site/sureshdevang/java-bean-v-s-pojo
//https://pt.wikipedia.org/wiki/Plain_Old_Java_Objects
//https://pt.wikipedia.org/wiki/JavaBeans


public class Vehicle {

	private long id;
	private String marca,
	               modelo,
	               chassi,
	               placa,
	               cor,
	               preco,
	               condicao;
		
	private String dataFabricacao;
	
	public Vehicle() {
		
	}
	public Vehicle(String id, String marca, String modelo, String chassi,String placa,String cor,String condicao,String dataFabricacao,String preco) {
		super();
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setChassi(chassi);
		setPlaca(placa);
		setCor(cor);
		setCondicao(condicao);
		setDataFabricacao(dataFabricacao);
		setPreco(preco);
	}
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		
		if (id.length()==0)
			setId(0);
		else
			setId(Long.valueOf(id));
	}
	/**
	 * @return the name
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param name the name to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the email
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param email the email to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the color
	 */
	public String getChassi() {
		return chassi;
	}
	/**
	 * @param color the color to set
	 */
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param color the color to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	/**
	 * @param color the color to set
	 */
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	public String getCor() {
		return cor;
	}
	/**
	 * @param color the color to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCondicao() {
		return condicao;
	}
	/**
	 * @param color the color to set
	 */
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	
	public String getPreco() {
		return preco;
	}
	/**
	 * @param color the color to set
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", chassi=" + chassi + ","
				+ "placa=\" + placa + \" + cor=\" + cor + \" + condicao=\" + condicao + \" + dataFabricação=\" + dataFabricacao + \" + Preço=\" + Preco + \"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo, id, chassi,placa,cor,condicao,dataFabricacao,preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo) && id == other.id
				&& Objects.equals(chassi, other.chassi) && Objects.equals(placa, other.placa) && Objects.equals(preco, other.preco);
	}
	
	
	
	
}
