package org.maia.login.entity;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Messages;

@Model
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 8448984868145770700L;

	private Usuario usuario;

	public UsuarioBean() {
		usuario = new Usuario();
	}

	//login
	public String logar() {
		if (usuario.getNome().equals("m") && usuario.getSenha().equals("12")) {

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("user", usuario);

			return "/pages/index?faces-redirect=true";
		}
		Messages.addGlobalFatal("Usuário Não Encontrado!!!");

		return "/login?faces-redirect=true";

	}

	//logout
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
