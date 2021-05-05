package ec.vehicle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.vehicle.model.Vehicle;
import ec.vehicle.util.DBUtil;

public class VehicleDao {

    private Connection connection;

    public VehicleDao() {
        connection = DBUtil.getConnection();
    } //UserDao

    public void addUser(Vehicle vehicle) {
        
    	//https://www.devmedia.com.br/assertions-em-java/28781
    	
    	try {
    		
    		System.out.println("Here we are...");
    		
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO vehiclen1.Veiculo (Marca, Modelo, Chassi,Placa,DataFabricacao,Preco,Cor,Condicao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1,  vehicle.getMarca());
            preparedStatement.setString(2,  vehicle.getModelo());
            preparedStatement.setString(3,  vehicle.getChassi());
            preparedStatement.setString(4,  vehicle.getPlaca());
            preparedStatement.setString(5,  vehicle.getDataFabricacao().toString());
            preparedStatement.setString(6,  vehicle.getPreco().toString());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setString(7,  vehicle.getCor());
            preparedStatement.setString(8,  vehicle.getCondicao());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deleteUser(Long id) {
    	
    	Vehicle user = new Vehicle();
    	user.setId(id);
    	
    	deleteUser(user);
    	
    } // deleteUser long

    public void deleteUser(Vehicle vehicle) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM vehiclen1.Veiculo WHERE ID=?");
        	
        	/*
        	 * 
        	 * DELETE FROM `vehiclen1`.`Veiculo` WHERE <{where_expression}>;

        	 * 
        	 */
            
            // Parameters start with 1
            preparedStatement.setLong(1, vehicle.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updateUser(Vehicle vehicle) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE vehiclen1.Veiculo SET Marca=?, " 
                    		                          + "Modelo=?, " 
                    		                          + "Chassi=? " 
                    		                          + "Placa=? "
                    		                          + "DataFabricacao=? "
                    		                          + "Preco=? "
                    		                          + "Cor=? "
                    		                          + "Condicao=? "
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
            preparedStatement.setString(1,  vehicle.getMarca());
            preparedStatement.setString(2,  vehicle.getModelo());
            preparedStatement.setString(3,  vehicle.getChassi());
            preparedStatement.setString(4,  vehicle.getPlaca());
            preparedStatement.setString(5,  vehicle.getDataFabricacao().toString());
            preparedStatement.setString(6,  vehicle.getPreco().toString());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setString(7,  vehicle.getCor());
            preparedStatement.setString(8,  vehicle.getCondicao());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<Vehicle> getAllUser() {
        
    	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM vehiclen1.Veiculo");
            while (rs.next()) {
                
            	Vehicle vehicle = new Vehicle();
                
            	vehicle.getMarca();
                vehicle.getModelo();
                vehicle.getChassi();
                vehicle.getPlaca();
                vehicle.getDataFabricacao().toString();
                vehicle.getPreco().toString();
                //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
                vehicle.getCor();
                vehicle.getCondicao();
                vehicle.getPreco();
                vehicleList.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleList;
    } //getAllUser

    public Vehicle getUserById(Long id) {
    	
    	Vehicle vehicle = new Vehicle();
    	vehicle.setId(id);
    	
    	return getUserById(vehicle);
    	
    } // getUserById long
    
    
    	
    public Vehicle getUserById(Vehicle vehicle) {

    	Vehicle userOutput = new Vehicle();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from vehiclen1.Veiculo WHERE ID=?");
            
            preparedStatement.setLong(1, vehicle.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	userOutput.setId(rs.getLong("Id"));
            	userOutput.setMarca(rs.getString("Marca"));
            	userOutput.setModelo(rs.getString("Modelo"));
            	//userOutput.setDob(rs.getDate("DOB"));
            	userOutput.setChassi(rs.getString("Chassi"));
            	userOutput.setPlaca(rs.getString("Placa"));
            	userOutput.setDataFabricacao(rs.getString("DataFabricacao"));
            	userOutput.setCor(rs.getString("Cor"));
            	userOutput.setCondicao(rs.getString("Condicao"));
            	userOutput.setPreco(rs.getString("Preco"));

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
    
} //UserDao