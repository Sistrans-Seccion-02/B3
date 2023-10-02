package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ProductoTienda;
import uniandes.edu.co.proyecto.repositorio.ProductoTiendaRepository;

@Controller
public class ProductoTiendaController {

    @Autowired
    private ProductoTiendaRepository productoRepository;

    @GetMapping("/productos_tienda")
    public String productos_tienda(Model model){
        model.addAttribute("productos_tienda", productoRepository.darProductos());
        return "productos_tienda";
    }

    @GetMapping("/productos_tienda/new")
    public String productoFrom(Model model){
        model.addAttribute("producto", new ProductoTienda());
        return "productoNuevo";
    }

    @PostMapping("/productos_tienda/new/save")
    public String productoGuardar(@ModelAttribute ProductoTienda producto){
        productoRepository.insertarProducto(producto.getNombre(), producto.getCosto(), producto.getIdServicio());;
        return "redirect:/productos_tienda";
    }

    @GetMapping("productos_tienda/{id}/edit")
    public String productoEditarForm(@PathVariable("id") int id, Model model){
        ProductoTienda producto = productoRepository.darProducto(id);
        if (producto!= null){
            model.addAttribute("producto", producto);
            return "productoEditar";
        }
        else{
            return "redirect:/productos_tienda";
        }
    }
    @PostMapping("/productos_tienda/{id}/edit/save")
    public String productoEditarGuardar(@PathVariable("id") int id, @ModelAttribute ProductoTienda producto){
        productoRepository.actualizarProducto(id, producto.getNombre(), producto.getCosto(), producto.getIdServicio());
        return "redirect:/productos_tienda";

    }

    @GetMapping("/productos_tienda/{id}/delete")
    public String productoEliminar(@PathVariable("id") int id){
        productoRepository.eliminarProducto(id);
        return "redirect:/productos_tienda"; 
    }


    
    
}