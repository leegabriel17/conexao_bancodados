package inclusao_bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public void apagar(Pessoa pessoa) {
		String sql = "delete from pessoa where (id_pessoa) = ?";//deleta todos os dados da id_pessoa selecionada
		Connection con = null;
		PreparedStatement pStat = null;
		try {			
			con = GerenciadorPool.getInstance().getConnection();		
			pStat = con.prepareStatement(sql);
			pStat.setInt(1, pessoa.getId_pessoa());
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
