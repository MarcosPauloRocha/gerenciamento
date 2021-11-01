package br.com.polissacarideo.controlepermissao.model;

import java.util.List;

import br.com.polissacarideo.controlepermissao.model.enums.PermissaoEnum;

public class Papel extends EntityAbstract {

	private String nome;
	private List<PermissaoAcao> permissaoAcaoList;
	private Boolean desenvolvedor;
	private Boolean administrador;

	public Papel() {
		super();
	}

	public Papel(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Boolean desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
		PermissaoAcao permissaoUsuario = new PermissaoAcao(PermissaoEnum.USUARIO, true, true, true);
		PermissaoAcao permissaoPapel = new PermissaoAcao(PermissaoEnum.PAPEL, true, true, true);
		if (isExiste(permissaoUsuario)) {
			permissaoAcaoList.add(permissaoUsuario);
		}
		if (isExiste(permissaoPapel)) {
			permissaoAcaoList.add(permissaoPapel);
		}

	}

	public boolean isExiste(PermissaoAcao permissao) {
		for (PermissaoAcao permissaoAcao : permissaoAcaoList) {
			if (permissaoAcao.equals(permissao)) {
				return true;
			}

		}
		return false;
	}

	public List<PermissaoAcao> getPermissaoAcaoList() {
		return permissaoAcaoList;
	}

	public void setPermissaoAcaoList(List<PermissaoAcao> permissaoAcaoList) {
		this.permissaoAcaoList = permissaoAcaoList;
	}

	public void addPermissaoAcaoList(PermissaoAcao permissaoAcao) {
		if (permissaoAcao.getPermissao().getAcao().equals(false)) {
			permissaoAcao.setVisualizar(null);
			permissaoAcao.setSalvar(null);
			permissaoAcao.setListar(null);
		}
		this.permissaoAcaoList.add(permissaoAcao);
	}

	/**
	 * Pega os valores da lista de permissoes e examina para ver se for,
	 * desenvolvedor(ja retorna true), administrador(se o usuario e papel for true
	 * ele retorna true)
	 * 
	 * @param listaPermissoes
	 * @return
	 */
	public boolean existePermissao(String... listaPermissoes) {
		if (Boolean.TRUE.equals(desenvolvedor)) {
			return true;
		}

		if (Boolean.TRUE.equals(administrador)) {
			for (String permissao : listaPermissoes) {
				if (PermissaoEnum.valueOf(permissao).equals(PermissaoEnum.USUARIO)
						|| PermissaoEnum.valueOf(permissao).equals(PermissaoEnum.PAPEL)) {
					return true;
				}

			}
		}

		for (PermissaoEnum p : PermissaoEnum.values()) {
			for (String permissao : listaPermissoes) {
				if (PermissaoEnum.valueOf(permissao).equals(p)) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean verificarPermissao(String permissao, String acao) {
		PermissaoEnum permissaoEnum = PermissaoEnum.valueOf(permissao);
		if (permissaoEnum != null) {
			for (PermissaoAcao permissaoAcao : permissaoAcaoList) {
				if (permissaoEnum.equals(permissaoAcao.getPermissao())) {
					if (acao.toLowerCase().trim().equals("salvar")) {
						return permissaoAcao.getSalvar();
					}
					switch (acao.toLowerCase().trim()) {
					case "salvar":
						return permissaoAcao.getSalvar();
					case "visualizar":
						return permissaoAcao.getVisualizar();
					case "listar":
						return permissaoAcao.getListar();
					default:
						return false;
					}

				}
			}

		}
		return false;
	}

}
