package com.example.week5relations.Controller;

import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.DTO.DetailsDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.Details;
import com.example.week5relations.Service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/details")
@RequiredArgsConstructor
public class DetailsController {

    private final DetailsService detailsService;

    @GetMapping("/get/{id}")
    public ResponseEntity getDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(detailsService.getDetails(id));
    }


    @PostMapping("/add")
    public ResponseEntity addDetails(@RequestBody DetailsDTO detailsDTO){

        detailsService.addDetails(detailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }

    @PutMapping("/Update/{id}")
    public ResponseEntity updateDetails(@RequestBody DetailsDTO detailsDTO){
        detailsService.updateDetails(detailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletedCustomer(@PathVariable Integer id) {
        detailsService.deleteDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }

}
