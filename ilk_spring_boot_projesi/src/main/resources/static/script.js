document.addEventListener('DOMContentLoaded', function() {
    fetch('/api/urunler') // Spring Boot API endpoint'i
        .then(response => response.json())
        .then(data => {
            const urunListesi = document.getElementById('urunListesi');
            data.forEach(urun => {
                const li = document.createElement('li');
                li.innerHTML = `<span>${urun.ad} - Fiyat: ${urun.fiyat}</span>`;
                urunListesi.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Ürünleri getirirken bir hata oluştu:', error);
            const urunListesi = document.getElementById('urunListesi');
            urunListesi.innerHTML = '<p>Ürünler yüklenirken bir hata oluştu.</p>';
        });
});