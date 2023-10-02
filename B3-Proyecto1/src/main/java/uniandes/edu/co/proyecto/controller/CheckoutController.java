package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import uniandes.edu.co.proyecto.modelo.Checkout;

import uniandes.edu.co.proyecto.repositorio.CheckoutRepository;




@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutRepository checkoutRepository;
    
    @GetMapping("/checkouts")
    public String checkouts(Model model, Integer id){
        model.addAttribute("checkouts", checkoutRepository.darCheckouts());
        return "checkouts";
    }

    @GetMapping("/checkouts/new")
    public String checkoutFrom(Model model){
        model.addAttribute("checkouts", new Checkout());
        return "checkoutNuevo";
    }

    @PostMapping("/checkouts/new/save")
    public String checkoutGuardar(@ModelAttribute Checkout checkout){
        checkoutRepository.insertarCheckout(checkout.getFechaSalida(), checkout.getResponsable(), checkout.getResponsableHotel());
        return "redirect:/checkouts";
    }

    @GetMapping("checkouts/{id}/edit")
    public String checkoutEditarForm(@PathVariable("id") Integer id, Model model){
        Checkout checkout=checkoutRepository.darCheckout(id);
        if(checkout!=null){
            model.addAttribute("checkout", checkout);
            return "checkoutEditar";
        }
        else{
            return "redirect:/checkout" ;
        }
    }

    @PostMapping("/checkouts/{id}/edit/save")
    public String checkoutEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Checkout checkout){
        checkoutRepository.actualizarCheckout(id, checkout.getFechaSalida(), checkout.getResponsable(), checkout.getResponsableHotel());
        return "redirect:/checkouts";
    }

    @GetMapping("/checkout/{id}/delete")
    public String checkoutEliminar(@PathVariable("id") Integer id){
        checkoutRepository.eliminarCheckout(id);
        return "redirect:/checkouts";
    }

}
