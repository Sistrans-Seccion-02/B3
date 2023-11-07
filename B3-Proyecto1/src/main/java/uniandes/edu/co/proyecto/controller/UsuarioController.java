package uniandes.edu.co.proyecto.controller;

import java.util.Collections;

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
    public String usuarios(Model model){
           model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    
        

    @GetMapping("/req9")
    public String req9(Model model, String idservicio, String fechain, String fechafin){
        if((idservicio==null || idservicio.equals(""))||(fechain==null || fechain.equals(""))||(fechafin==null || fechafin.equals(""))){
             model.addAttribute("usuariosConServicio", Collections.emptyList());
        
        }
        else {
            model.addAttribute("usuariosConServicio", usuarioRepository.usuariosServicios(Integer.parseInt(idservicio), fechain, fechafin));
        }
        return "req9";
    }

    @GetMapping("/usuarios/new")
    public String usuarioFrom(Model model){
        model.addAttribute("usuarios", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getEmail(), usuario.getUsuario(), usuario.getContraseña(), usuario.gettipousuario());
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
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getEmail(), usuario.getUsuario(), usuario.getContraseña(), usuario.gettipousuario());
        return "redirect:/usuarios";

    }

    


   
}