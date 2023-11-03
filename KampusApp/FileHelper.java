import java.io.File; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper{
    private String namaFileDataMahasiswa = "data_mahasiswa.txt";

    public void simpanKeFile(ArrayList<Mahasiswa>daftarMahasiswa){ //metode ini bertanggung jawab untuk menyimpan file 
        try (PrintWriter Writer = new PrintWriter(new File(namaFileDataMahasiswa))){
            for (Mahasiswa m: daftarMahasiswa){
               Writer.println(m.getNim() +","+ m.getNama() +","+ m.getNoHP());
            }
        }  catch (IOException e){
            System.out.println("Terjadi kesalahan saat menyimpan ke file: " + e.getMessage());
        }
    }

    public ArrayList<Mahasiswa> bacaDariFile(){
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        try (Scanner scanner = new Scanner (new File (namaFileDataMahasiswa))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");      
                if (parts.length == 4){
                    String nim = parts[0];
                    String nama = parts [1];
                    Long NoHP = Long.parseLong(parts[2]);
                    Mahasiswa m =  new Mahasiswa(nim, nama, NoHP);
                    daftarMahasiswa.add(m);
                }
            }   
        } catch (IOException e){

        }
        return daftarMahasiswa;
    }
}