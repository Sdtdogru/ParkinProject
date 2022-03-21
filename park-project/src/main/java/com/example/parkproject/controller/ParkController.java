package com.example.parkproject.controller;

import com.example.parkproject.model.Request;
import com.example.parkproject.model.Ticked;
import com.example.parkproject.service.ParkSevice;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkController {

    @Autowired
     ParkSevice parkSevice;

    @PostMapping("/park")
    public String park(@RequestBody Request request) {
        return parkSevice.park(request);
    }

    @GetMapping("/status")
    public List<Ticked> status() {
        return parkSevice.status();
    }

    @DeleteMapping("/leave/{id}")
    public String leave(@PathVariable int id) {
        System.out.println(id);
        return parkSevice.leave(id);
    }

}
