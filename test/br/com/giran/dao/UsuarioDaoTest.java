package br.com.giran.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.giran.model.Usuario;
import br.com.giran.repository.UsuarioRepository;

public class UsuarioDaoTest {

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private UsuarioRepository repository;
	private Usuario usuario;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		repository = new UsuarioDao(manager);
	}

	@Test
	public void deveriaSaveTest() throws Exception{
		// given
		dadoQueTenhoUmUsuarioChamado("M‡rcio");

		// when // then
		when(repository.save(usuario)).thenReturn(usuario);
	}

	@Test
	public void deveriaLoadAllTest() throws Exception{
		// given
		dadoQueTenhoUmUsuarioChamado("Botelho");

		// when // then
		when(manager.createQuery("from " + Usuario.class.getName())).thenReturn(query);
		when(query.getResultList()).thenReturn(Collections.singletonList(usuario));
	}

	@Test
	public void deveriaLoadByIdTest() throws Exception{
		// given
		dadoQueTenhoUmUsuarioChamado("Rodolfo");

		// when
		repository.loadById(usuario.getId());

		// then
		verify(manager).find(Usuario.class, usuario.getId());
	}

	private void dadoQueTenhoUmUsuarioChamado(String nome) {
		usuario = new Usuario();
		usuario.setId(42l);
		usuario.setNome(nome);
	}

}