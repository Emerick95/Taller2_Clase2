/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicasistemacentralizado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author arwin
 */
public class Test {
    Statement stm;
    ResultSet rs;
    
    public static void main (String[] args){
        Test t=new Test();
        
        t.insertar();
    }
    
    
    public Connection getConexion(){
        Connection conexion=null;
        String servidor="localhost";
        String puerto="5432";
        String baseDatos="supermercado";
        String url="jdbc:postgresql://"+servidor+":"+puerto+"/"+baseDatos;
        String usuario="postgres";
        String password="2407";
        try{
            conexion=DriverManager.getConnection(url, usuario, password);
        }catch(SQLException ex){
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public void insertar () {
        Connection conexion=getConexion();
        String sql="INSERT INTO producto (codigo,nombre,precio) VALUES (2,'papas',12.01)";
        
        //String sql = "insert into producto value (" + codigo  + " ,' " + nombre + " ', '" + precio+"')";
        
        try(Statement st=conexion.createStatement()){
            st.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void actualizar (){ 
        Connection conexion=getConexion();
        
        //String sql = "UPDATE producto SET " + "nombre= " + nombre +" " + ",precio" + precio + "WHERE codigo" + codigo;
        
        String sql="UPDATE producto set nombre='leche' where codigo='2' ";
        
        try (Statement st= conexion.createStatement()){
            st.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar (){
	Connection conexion = getConexion();
        
	//String sql = "DELETE FROM producto WHERE codigo = " + codigo;
        String sql= "delete from producto where codigo = '2'";
	try (Statement st = conexion.createStatement()) {
		st.executeUpdate(sql);
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
    
}
