package inclusao_bancodados;

public class Pessoa {
	
	Integer id_pessoa;
	String nome;
	int idade;
	
	
	
	public Pessoa(Integer id_pessoa, String nome, int idade) {
		super();
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.idade = idade;
	}
	
	public Integer getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
