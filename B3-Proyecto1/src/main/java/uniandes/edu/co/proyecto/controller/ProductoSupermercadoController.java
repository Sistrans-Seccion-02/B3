package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ProductoSupermercado;
import uniandes.edu.co.proyecto.repositorio.ProductoSupermercadoRepository;

@Controller
public class ProductoSupermercadoController {

    @Autowired
    private ProductoSupermercadoRepository productoRepository;

    @GetMapping("/productos_supermercado")
    public String productos_supermercado(Model model){
        model.addAttribute("productos_supermercado", productoRepository.darProductos());
        return "productos_supermercado";
    }

    @GetMapping("/productos_supermercado/new")
    public String productoFrom(Model model){
        model.addAttribute("plato", new ProductoSupermercado());
        return "productoNuevo";
    }

    @PostMapping("/productos_supermercado/new/save")
    public String productoGuardar(@ModelAttribute ProductoSupermercado producto){
        productoRepository.insertarProducto(producto.getNombre(), producto.getCosto(), producto.getIdServicio());;
        return "redirect:/productos_supermercado";
    }

    @GetMapping("productos_supermercado/{id}/edit")
    public String productoEditarForm(@PathVariable("id") int id, Model model){
        ProductoSupermercado producto = productoRepository.darProducto(id);
        if (producto!= null){
            model.addAttribute("producto", producto);
            return "productoEditar";
        }
        else{
            return "redirect:/productos_supermercado";
        }
    }
    @PostMapping("/productos_supermercado/{id}/edit/save")
    public String productoEditarGuardar(@PathVariable("id") int id, @ModelAttribute ProductoSupermercado producto){
        productoRepository.actualizarProducto(id, producto.getNombre(), producto.getCosto(), producto.getIdServicio());
        return "redirect:/productos_supermercado";

    }

    @GetMapping("/productos_supermercado/{id}/delete")
    public String productoEliminar(@PathVariable("id") int id){
        productoRepository.eliminarProducto(id);
        return "redirect:/productos_supermercado"; 
    }


    
    
}