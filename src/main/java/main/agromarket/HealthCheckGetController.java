package main.agromarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckGetController {
    @GetMapping("/health-check")
    public HashMap<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "okay");

        return status;
    }
}