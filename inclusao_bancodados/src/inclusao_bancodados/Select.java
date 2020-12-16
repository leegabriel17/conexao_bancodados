package inclusao_bancodados;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Select {
	
	
	public List<Pessoa> selecionar() {
		
		String sql = "select * from pessoa";//seleciona o nome a idade do id_pessoa
		Connection con = null;
		PreparedStatement pStat = null;		
		List<Pessoa> list = new ArrayList<Pessoa>();
		try {
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);
			ResultSet rs = pStat.executeQuery();
			
			String nome;
			int idade, id_pessoa;
			
			while(rs.next()) {
				id_pessoa = rs.getInt("id_pessoa");
				nome = rs.getString("nome");
				idade = rs.getInt("idade");
				
				list.add(new Pessoa(id_pessoa,nome,idade));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos(con, pStat);
			return list;
		}
	}
	
	
	private void fecharRecursos(Connection con, PreparedStatement pStat) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException erro){
				erro.printStackTrace();
			}
		}
		if(pStat != null) {
			try {
				pStat.close();
			}catch(SQLException erro) {
				erro.printStackTrace();
			}
		}
		
	}
}
