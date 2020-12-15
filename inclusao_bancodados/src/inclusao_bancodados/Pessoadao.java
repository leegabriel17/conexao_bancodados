package inclusao_bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Pessoadao {

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
