package br.com.giran.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.giran.model.Usuario;
import br.com.giran.repository.UsuarioRepository;

@Component
public class UsuarioDao implements UsuarioRepository {

	private EntityManager manager;

	protected UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario save(Usuario usuario) throws Exception {
		try {
			return manager.merge(usuario);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar o usu‡rio", e);
		}
	}

	public Collection<Usuario> loadAll() throws Exception {
		try {
			Query query = manager.createQuery("from Usuario");
			
			@SuppressWarnings("unchecked")
			List<Usuario> resultList = query.getResultList();
			
			return resultList;
		} catch (Exception e) {
			throw new Exception("Erro ao listar os usu‡rios", e);
		}
	} 
	
	public Usuario loadById(Long id) throws Exception {
		try {
			return manager.find(Usuario.class, id);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar o usu‡rio", e);
		}
	}

}