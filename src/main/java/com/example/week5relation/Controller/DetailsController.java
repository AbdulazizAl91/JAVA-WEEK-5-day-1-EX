package com.example.week5relation.Controller;

import com.example.week5relation.Api.ApiException;
import com.example.week5relation.Api.ApiResponse;
import com.example.week5relation.DTO.DetailsDTO;
import com.example.week5relation.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/details")
@RequiredArgsConstructor
public class DetailsController {
    private final DetailsService detailsService;
    @GetMapping("/get")
    public ResponseEntity getAllDetails(){
        return ResponseEntity.status(200).body(detailsService.getAllDetails());
    }
    @PostMapping("/add")
    public ResponseEntity addDetails(@RequestBody @Valid DetailsDTO detailsDTO){

        detailsService.addDetails(detailsDTO);
        return ResponseEntity.status(200).body(new ApiException("Details add"));

    }

    @DeleteMapping("/delete/{customer_id}")
    public ResponseEntity deleteD(@PathVariable Integer customer_id){
        detailsService.delete(customer_id);
        return ResponseEntity.status(200).body(new ApiResponse(" Details delete"));
    }
    @PutMapping("/update/{customer_id}")
    public ResponseEntity updateDetails(@PathVariable Integer customer_id,@RequestBody @Valid DetailsDTO detailsDTO ){
        detailsService.update(customer_id,detailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Details update"));
    }


}
