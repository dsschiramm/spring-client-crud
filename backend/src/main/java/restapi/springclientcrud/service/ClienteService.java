package restapi.springclientcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.springclientcrud.exception.UniqueViolationException;
import restapi.springclientcrud.model.Cliente;
import restapi.springclientcrud.model.ClienteRepository;
import java.util.List;
import java.util.Optional;

@Service("countryService")
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) throws UniqueViolationException {

        Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteExistente != null) {
            if (!cliente.getId().equals(clienteExistente.getId())) {
                throw new UniqueViolationException("Já existe um cadastro de cliente com esse CPF.");
            }
        }

        return clienteRepository.save(cliente);
    }

    public List findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById (long id) {
        return clienteRepository.findById(id);
    }

    public void deleteById (long id) {
        clienteRepository.deleteById(id);
    }
}
