package templates;

import org.springframework.web.bind.annotation.RequestMapping;

public class HotelController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
