package com.frkn78.urun;

public class Urun {
    private Long id;
    private String ad;
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
