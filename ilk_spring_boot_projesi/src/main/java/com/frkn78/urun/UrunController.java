package com.frkn78.urun;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/urunler") // Temel API yolu

public class UrunController {
    private List<Urun> urunler = new ArrayList<>();
    private long nextId = 1;

    @GetMapping // Tüm ürünleri listeleme (GET /api/urunler)
    public List<Urun> getAllUrunler() {
        return urunler;
    }

    @GetMapping("/{id}") // Belirli bir ürünü getirme (GET /api/urunler/{id})
    public ResponseEntity<Urun> getUrunById(@PathVariable Long id) {
        Optional<Urun> urun = urunler.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (urun.isPresent()) {
            return new ResponseEntity<>(urun.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping // Yeni bir ürün oluşturma (POST /api/urunler)
    public ResponseEntity<Urun> createUrun(@RequestBody Urun urun) {
        urun.setId(nextId++);
        urunler.add(urun);
        return new ResponseEntity<>(urun, HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // Mevcut bir ürünü güncelleme (PUT /api/urunler/{id})
    public ResponseEntity<Urun> updateUrun(@PathVariable Long id, @RequestBody Urun guncellenenUrun) {
        Optional<Urun> existingUrun = urunler.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (existingUrun.isPresent()) {
            Urun urun = existingUrun.get();
            urun.setAd(guncellenenUrun.getAd());
            urun.setFiyat(guncellenenUrun.getFiyat());
            return new ResponseEntity<>(urun, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}") // Bir ürünü silme (DELETE /api/urunler/{id})
    public ResponseEntity<Void> deleteUrun(@PathVariable Long id) {
        boolean removed = urunler.removeIf(u -> u.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
