package inclusao_bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public void alterar(Pessoa pessoa) {
		String sql = "update pessoa set nome = ? idade = ? where (id_pessoa) = ?";//altera o nome a idade do id_pessoa selecionada
		Connection con = null;
		PreparedStatement pStat = null;		
		try {
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);
			pStat.setString(1, pessoa.getNome());
			pStat.setInt(2,pessoa.getIdade());
			pStat.setInt(3, pessoa.getId_pessoa());
			pStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos(con, pStat);
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
