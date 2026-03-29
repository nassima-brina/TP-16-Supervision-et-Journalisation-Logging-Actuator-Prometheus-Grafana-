package ma.ens.tp8monitoring.controller;

import ma.ens.tp8monitoring.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/process")
    public String process() {
        return service.processData();
    }
}