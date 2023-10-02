package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

import org.springframework.ui.Model;

@Controller

@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clientesRepository;

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clientesRepository.findAll();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id) {
        return clientesRepository.darCliente(id);
    }

    // Registrar un cliente
    @PostMapping
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    // Formulario de edición para un cliente
    @GetMapping("/clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") int id, Model model) {
        Cliente cliente = clientesRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";  // Retorna la vista (JSP, Thymeleaf, etc.) correspondiente al formulario de edición
        } else {
            return "redirect:/clientes";  // Si no se encuentra el cliente, redirecciona a la lista de clientes
        }
    }

    // Guardar los cambios del cliente después de editar
    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cliente cliente) {
        clientesRepository.actualizarCliente(id, cliente.getNombre());
        return "redirect:/clientes";  // Redirecciona a la lista de clientes después de guardar los cambios
    }

        // Eliminar un cliente
        @DeleteMapping("/{id}")
        public void eliminarCliente(@PathVariable int id) {
            clientesRepository.eliminarCliente(id);
        }
    }
