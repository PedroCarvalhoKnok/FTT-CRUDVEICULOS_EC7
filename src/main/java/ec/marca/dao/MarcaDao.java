package ec.marca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.marca.model.Marca;
import ec.vehicle.util.DBUtil;

public class MarcaDao {

    private Connection connection;

    public MarcaDao() {
        connection = DBUtil.getConnection();
    } //UserDao

    public void addMarca(Marca marca) {
        
    	//https://www.devmedia.com.br/assertions-em-java/28781
    	
    	try {
    		
    		System.out.println("Here we are...");
    		
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO vehiclen1.Marca (DescricaoMarca) VALUES (?)");
            
            // Parameters start with 1
            preparedStatement.setString(1,  marca.getDescricaoMarca());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deleteMarca(Long id) {
    	
    	Marca marca = new Marca();
    	marca.setId(id);
    	
    	deleteMarca(marca);
    	
    } // deleteUser long

    public void deleteMarca(Marca marca) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM vehiclen1.Marca WHERE ID=?");
        	
        	/*
        	 * 
        	 * DELETE FROM `vehiclen1`.`Marca` WHERE <{where_expression}>;

        	 * 
        	 */
            
            // Parameters start with 1
            preparedStatement.setLong(1, marca.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updateMarca(Marca marca) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE vehiclen1.Veiculo SET DescricaoMarca=?, "                    		                         
                                               + "WHERE ID=?");
            
            /*
             * 
             * UPDATE `vehiclen1`.`Veiculo`
				SET
					`ID` = <{Id: }>,
					`Marca` = <{Marca: }>,
					`Modelo` = <{Modelo: }>,
					`Chassi` = <{Chassi: }>,
					`Placa` = <{Placa: }>,
					`DataFabricacao` = <{DataFabricacao: }>,
					`Preco` = <{Preco: }>,
					`Cor` = <{Cor: }>,
					`Condicao` = <{Condicao: }>
					WHERE `ID` = <{expr}>;

             * 
             */
            
            // Parameters start with 1
            preparedStatement.setString(1,  marca.getDescricaoMarca());                      
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<Marca> getAllMarcas() {
        
    	List<Marca> vehicleList = new ArrayList<Marca>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM vehiclen1.Marca");
            while (rs.next()) {
                
            	Marca marca = new Marca();
                
            	marca.getDescricaoMarca();
                
                vehicleList.add(marca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleList;
    } //getAllUser

    public Marca getMarcaById(Long id) {
    	
    	Marca marca = new Marca();
    	marca.setId(id);
    	
    	return getMarcaById(marca);
    	
    } // getUserById long
    
    
    	
    public Marca getMarcaById(Marca marca) {

    	Marca userOutput = new Marca();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from vehiclen1.Marca WHERE ID=?");
            
            preparedStatement.setLong(1, marca.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	userOutput.setId(rs.getLong("Id"));
            	userOutput.setDescricaoMarca(rs.getString("DescricaoMarca"));
            	

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userOutput;
    } //getUserById
    
    public String getDbDate() {

    	String output="";
    	
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT now() NOW");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	output = rs.getString("NOW");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    } //getDbDate
    
} //MarcaDao