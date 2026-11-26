package com.fazon.simplybytespringboot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class TestingController {

    // ===== V2 - TEXT LEVEL CHANGE - Inga maathina Browser la text maarum =====
    // V1 la: "Version 1 - Hello Everyone..."
    // V2 la: "Version 2 - Updated! Automation Success..."
    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of(
            "version", "V2",
            "message", "Version 2 - Updated! Automation Success - Jenkins Deploy Worked!",
            "color", "GREEN",
            "app", "simplybyte-springboot"
        );
    }

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of("version", "V2", "port-inside", "8090", "port-outside", "8097", "java", "17");
    }
}
