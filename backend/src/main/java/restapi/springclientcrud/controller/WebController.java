package restapi.springclientcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class WebController {

    @GetMapping(path = "/", produces = "application/json")
    public HashMap<String, String> login() {

        HashMap<String, String> response = new HashMap<>();
        response.put("authenticated", "true");
        return response;
    }

    @GetMapping(path = "/source", produces = "application/json")
    public HashMap<String, String>  source() {

        HashMap<String, String> response = new HashMap<>();
        response.put("link", "https://github.com/dsschiramm/spring-client-crud");
        return response;
    }
}
