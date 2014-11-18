package br.jogo.risk.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.UsuarioDao;
import br.jogo.risk.model.Usuario;

@Component
@RequestScoped
public class UsuarioDaoImpl extends GenericDaoImpl implements UsuarioDao{
	@Override
	public boolean jogadorExist(Long usuarioId) {
		Criteria criteria = getSession().createCriteria(Usuario.class, "u")
		.add(Restrictions.eq("u.id", usuarioId));
		return (criteria.list().size() > 0);
	}

	@Override
	public Usuario find(Usuario usuario) {
		return (Usuario) getSession().createCriteria(Usuario.class, "u")
				.add(Restrictions.eq("u.login", usuario.getLogin()))
				.add(Restrictions.eq("u.senha", usuario.getSenha()))
				.add(Restrictions.eq("u.perfil.id", usuario.getPerfil().getId()))
				.uniqueResult();
	}

	@Override
	public boolean verificarDisponibilidade(String login) {
		Criteria criteria = getSession().createCriteria(Usuario.class, "u");
		criteria.add(Restrictions.eq("u.login", login));
		
		return (criteria.list().size() == 0) ;
	}
	
	public void updateByLogin(Usuario jogador){
		String hql = "update Usuario set senha = :senha where login = :login";
        Query query = getSession().createQuery(hql);
        
        query.setString("senha",jogador.getSenha());
        query.setString("login",jogador.getLogin());

        query.executeUpdate();
	}
}
