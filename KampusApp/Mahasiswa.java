public class Mahasiswa {
    // improving : tambah jenis-jenis data 
    // variabel ini bersifat private, sehingga hanya dapat diakses dalam kelas "Mahasiswa"
    private String nim; 
    private String nama;
    private Long NoHP; 

    // untuk menginisialisasi variabel 'Nim' dan 'Nama' 'Jenis kelamin' 'No hanphone'
    public Mahasiswa(String nim, String nama, Long NoHP){
        this.nama = nama;
        this.nim = nim;
        this.NoHP = NoHP;
    }

    public String getNim(){ 
        return nim;
    }

    public String getNama(){ 
        return nama;
    }

    public Long getNoHP(){ 
        return NoHP;
    }
}