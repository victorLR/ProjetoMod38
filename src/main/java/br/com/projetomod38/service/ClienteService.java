package br.com.projetomod38.service;

import br.com.projetomod38.entity.Cliente;
import br.com.projetomod38.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
        validar(cliente);

        if (clienteRepository.existeEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Já existe cliente cadastrado com esse e-mail.");
        }

        cliente.setNome(cliente.getNome().trim());
        cliente.setEmail(cliente.getEmail().trim().toLowerCase());
        cliente.setTelefone(cliente.getTelefone().trim());

        return clienteRepository.salvar(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    void validar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido.");
        }
        if (cliente.getNome() == null || cliente.getNome().trim().length() < 3) {
            throw new IllegalArgumentException("Nome deve ter pelo menos 3 caracteres.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isBlank() || !cliente.getEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().length() < 8) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
    }
}
