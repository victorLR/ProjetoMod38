package br.com.projetomod38.repository;

import br.com.projetomod38.config.JPAUtil;
import br.com.projetomod38.entity.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    public Cliente salvar(Cliente cliente) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            return cliente;
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public List<Cliente> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Cliente> query = entityManager.createQuery(
                    "select c from Cliente c order by c.id desc", Cliente.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public boolean existeEmail(String email) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            Long quantidade = entityManager.createQuery(
                    "select count(c) from Cliente c where lower(c.email) = lower(:email)", Long.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return quantidade != null && quantidade > 0;
        } finally {
            entityManager.close();
        }
    }
}
