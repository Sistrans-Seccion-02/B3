package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model, Integer id){
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioFrom(Model model){
        model.addAttribute("usuarios", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getEmail(), usuario.getUsuario(), usuario.getContraseña(), usuario.getIdTipoUsuario());
        return "redirect:/usuarios";
    }

    @GetMapping("usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") Integer id, Model model){
        Usuario usuario=usuarioRepository.darUsuarioID(id);
        if(usuario!=null){
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        }
        else{
            return "redirect:/usuarios";
        }

        
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Usuario usuario){
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getEmail(), usuario.getUsuario(), usuario.getContraseña(), usuario.getIdTipoUsuario());
        return "redirect:/usuarios";

    }

    

   
}