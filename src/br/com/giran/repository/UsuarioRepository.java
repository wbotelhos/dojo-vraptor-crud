package br.com.giran.repository;

import java.util.Collection;

import br.com.giran.model.Usuario;

public interface UsuarioRepository {

	Usuario save(Usuario usuario) throws Exception;

	Collection<Usuario> loadAll() throws Exception;

	Usuario loadById(Long id) throws Exception;

}