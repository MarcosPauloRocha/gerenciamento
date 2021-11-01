package br.com.polissacarideo.controlepermissao.model.enums;

public enum PermissaoEnum {
	// ADMINISTRATIVO
	USUARIO("Usuario", ModuloEnum.ADMINISTRATIVO), 
	PERMISSAO("Permissao", ModuloEnum.ADMINISTRATIVO),
	PESSOA("Pessoa", ModuloEnum.ADMINISTRATIVO),
	PAPEL("Papel", ModuloEnum.ADMINISTRATIVO),
	
	// VENDAS
	VENDAS("Vendas", ModuloEnum.VENDAS),
	DESCONTO("Desconto",ModuloEnum.VENDAS,false),
	VENDAS_RELATORIO("Vendas Relatorio",ModuloEnum.VENDAS,false);
	// ESTOQUE
	
	private String nome;
	private ModuloEnum modulo;
	private Boolean acao;

	private PermissaoEnum(String nome, ModuloEnum modulo) {
		this.nome = nome;
		this.modulo = modulo;
	}

	private PermissaoEnum(String nome, ModuloEnum modulo, Boolean acao) {
		this.nome = nome;
		this.modulo = modulo;
		this.acao = acao;
	}

	public String getNome() {
		return nome;
	}

	public ModuloEnum getModulo() {
		return modulo;
	}

	public Boolean getAcao() {
		return acao;
	}
	
	public static PermissaoEnum nomeToEnum(String nome) {
        for (PermissaoEnum permissao : PermissaoEnum.values()) {
            if (permissao.getNome().equals(nome)) {
                return permissao;
            }
        }
        return null;
    }
	
	

}
