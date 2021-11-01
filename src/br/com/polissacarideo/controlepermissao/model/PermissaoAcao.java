package br.com.polissacarideo.controlepermissao.model;

import br.com.polissacarideo.controlepermissao.model.enums.PermissaoEnum;

public class PermissaoAcao {
	private PermissaoEnum permissao;
	private Boolean salvar;
	private Boolean visualizar;
	private Boolean listar;

	public PermissaoAcao(PermissaoEnum permissao) {
		super();
		this.permissao = permissao;
	}

	public PermissaoAcao(PermissaoEnum permissao, Boolean salvar, Boolean visualizar, Boolean listar) {
		super();
		this.salvar = salvar;
		this.visualizar = visualizar;
		this.listar = listar;
		this.permissao = permissao;
	}

	public Boolean getSalvar() {
		return salvar;
	}

	public void setSalvar(Boolean salvar) {
		this.salvar = salvar;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}

	public Boolean getListar() {
		return listar;
	}

	public void setListar(Boolean listar) {
		this.listar = listar;
	}

	public PermissaoEnum getPermissao() {
		return permissao;
	}

	public void setPermissao(PermissaoEnum permissao) {
		this.permissao = permissao;
	}
	

}
