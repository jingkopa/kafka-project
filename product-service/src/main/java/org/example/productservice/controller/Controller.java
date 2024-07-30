package org.example.productservice.controller;



import org.example.productservice.Service.ProductService;
import org.example.productservice.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaProducer kafkaProducer;
    private final ProductService productService;

    public Controller(KafkaProducer kafkaProducer, ProductService productService) {
        this.kafkaProducer = kafkaProducer;
        this.productService = productService;
    }


    @PostMapping("/kafka/send")
    public String send(@RequestParam long id) {
        var product = productService.getProductById(id);
        //Нужно десериализовать, но тут можно обойтись простым String
        kafkaProducer.sendMessage(product.toString());
        return "Success";
    }


//    @PostMapping("/kafka/send")
//    public String send(@RequestBody String message) {
//        kafkaProducer.sendMessage(message);
//        return "Success";
//    }
}

