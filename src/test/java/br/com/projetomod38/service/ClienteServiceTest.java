package br.com.projetomod38.service;

import br.com.projetomod38.entity.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteServiceTest {

    private final ClienteService clienteService = new ClienteService();

    @Test
    void deveValidarClienteCorretamente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Victor Affonso");
        cliente.setEmail("victor@email.com");
        cliente.setTelefone("21999999999");

        assertDoesNotThrow(() -> clienteService.validar(cliente));
    }

    @Test
    void deveLancarErroQuandoNomeForInvalido() {
        Cliente cliente = new Cliente();
        cliente.setNome("Vi");
        cliente.setEmail("victor@email.com");
        cliente.setTelefone("21999999999");

        assertThrows(IllegalArgumentException.class, () -> clienteService.validar(cliente));
    }

    @Test
    void deveLancarErroQuandoEmailForInvalido() {
        Cliente cliente = new Cliente();
        cliente.setNome("Victor Affonso");
        cliente.setEmail("victoremail.com");
        cliente.setTelefone("21999999999");

        assertThrows(IllegalArgumentException.class, () -> clienteService.validar(cliente));
    }

    @Test
    void deveLancarErroQuandoTelefoneForInvalido() {
        Cliente cliente = new Cliente();
        cliente.setNome("Victor Affonso");
        cliente.setEmail("victor@email.com");
        cliente.setTelefone("1234");

        assertThrows(IllegalArgumentException.class, () -> clienteService.validar(cliente));
    }
}
