package com.example.discovery_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
public class DemoClientDiscoveryApplication {

    public static void main(String[] args) {
 //       new SpringApplicationBuilder(DemoClientDiscoveryApplication.class)
 //               .web(WebApplicationType.SERVLET).run(args);
        SpringApplication.run(DemoClientDiscoveryApplication.class, args);
    }

 //   @GetMapping("/services/{name}")
  //  @ResponseStatus(HttpStatus.OK)
  //  public String get(@PathVariable String name) {
 //       return "Service name is " + name;
 //   }

}
