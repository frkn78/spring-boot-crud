package com.frkn78.urun;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir
@Table(name = "urunler") // Veritabanındaki tablo adını belirtir
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Urun {

    @Id // Bu alanın birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Birincil anahtarın otomatik olarak veritabanı tarafından oluşturulacağını belirtir
    private Long id;

    @Column(name = "ad", nullable = false) // Veritabanındaki sütun adını ve zorunlu olduğunu belirtir
    private String ad;

    @Column(name = "fiyat", nullable = false, precision = 10, scale = 2)
    private double fiyat;

    // Boş constructor (Lombok ile otomatik oluşturulacak)
    public Urun() {
    }

    public Urun(Long id, String ad, double fiyat) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
    }

    // Getter ve Setter metotları (Lombok ile otomatik oluşturulacak)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
