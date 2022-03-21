package com.example.parkproject.service;

import com.example.parkproject.model.Request;
import com.example.parkproject.model.Ticked;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkSevice {
    String park(Request request);
    List<Ticked> status();
    String leave(int slot);
}
