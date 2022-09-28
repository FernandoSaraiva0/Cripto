package cripto;

import com.dao.UsuarioDAO;
import com.usuario.Usuario;

public class TesteCript {
	public static void main(String [] args) {
		
		Usuario user = new Usuario();
		UsuarioDAO userDAO = new UsuarioDAO();
		
		user.setNome("Josivaldo da silva");
		user.setSenha("1234");
//		user.setEmail("teste@teste");
		
		userDAO.insert(user);
		
		
		
	}
}
