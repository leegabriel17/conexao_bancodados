package inclusao_bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Inserir {
	public void salvar(Pessoa pessoa) {
		String sql = "insert into pessoa(id_pessoa,nome,idade) values(?,?,?)";//criando um valor igual a do banco ára conexao
		Connection con = null;//conexao com o banco
		PreparedStatement pStat = null; //
		try {
			con = GerenciadorPool.getInstance().getConnection();//conexao
			pStat = con.prepareStatement(sql); 		
			pStat.setInt(1, pessoa.getId_pessoa());				
			pStat.setString(2, pessoa.getNome());
			pStat.setInt(3,pessoa.getIdade());
			pStat.executeUpdate();	//execucao							
		}catch(SQLException erro){
			erro.printStackTrace();
		}finally {
			fecharRecursos(con, pStat);//chamando metodo para fechar a conecxao do banco
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
