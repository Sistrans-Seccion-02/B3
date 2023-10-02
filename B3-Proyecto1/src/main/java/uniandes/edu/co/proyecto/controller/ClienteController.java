package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model, Integer id){
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clienteFrom(Model model){
        model.addAttribute("clientes", new Usuario());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente){
        clienteRepository.insertarCliente(cliente.getNumAcompañantes());
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Cliente cliente){
        clienteRepository.actualizarCliente(id, cliente.getNumAcompañantes());
        return "redirect:/clientes";
    }

    @GetMapping("clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") Integer id, Model model){
        Usuario cliente=clienteRepository.darClienteID(id);
        if(cliente!=null){
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        }
        else{
            return "redirect:/cliente";
        }

        
    }


   
    
}
