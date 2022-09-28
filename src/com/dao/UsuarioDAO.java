package com.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.factory.ConexaoFactory;
import com.usuario.Usuario;

public class UsuarioDAO {
	
	String senhatest = null;
	
//	Método de criptografia
	public String cripto(String senha){
	
		try {
		StringBuilder hexString = new StringBuilder();
		
		MessageDigest algo = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algo.digest(senha.getBytes("UTF8"));
		
		for(byte b: messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		
		senhatest = hexString.toString();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return senhatest;
		
	}
//	Método para inserir os dados
	public void insert(Usuario user) {
		
		String query = "INSERT INTO usuario3 (nome, senha) VALUES (? , aes_encrypt( ?, '1234'))";
		Connection con = null;
		PreparedStatement pstm = null;
		try {
		con = ConexaoFactory.createConnectionToMySQL();
		pstm = con.prepareStatement(query);
		pstm.setString(1, user.getNome());
		pstm.setString(2, cripto(user.getSenha()));
//		pstm.setString(3, user.getEmail());
		
		pstm.execute();
		
	} catch (Exception e) {
		e.printStackTrace();
	} // Garantindo que a conexão será finalizada
	finally {
//		Fechando conexões
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}
	
}
