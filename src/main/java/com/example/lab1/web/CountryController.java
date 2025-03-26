package com.example.lab1.web;

import com.example.lab1.model.Country;
import com.example.lab1.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> findAll(){
        return ResponseEntity.ok(this.countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        Country country = this.countryService.findById(id);
        if(country == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(country);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country country1 = this.countryService.save(country);
        if(country1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(country1);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody Country country){
        Country country1 = this.countryService.update(id, country);
        if (country1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(country1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        Country country1 = this.countryService.findById(id);
        if(country1 != null){
            this.countryService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
