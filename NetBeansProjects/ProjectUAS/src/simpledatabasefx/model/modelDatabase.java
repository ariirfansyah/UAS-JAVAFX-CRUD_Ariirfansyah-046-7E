
package simpledatabasefx.model;
 
import javafx.beans.property.SimpleStringProperty;
 
/**
 *
 * @author arief
 */
public class modelDatabase {
    public final SimpleStringProperty nim;
    public final SimpleStringProperty nama;
    public final SimpleStringProperty jurusan;
    public final SimpleStringProperty alamat;
   
    public modelDatabase(String fnim,String fnama,String fjurusan,String falamat){
        this.nim = new SimpleStringProperty(fnim);
        this.nama = new SimpleStringProperty(fnama);
        this.jurusan = new SimpleStringProperty(fjurusan);
        this.alamat = new SimpleStringProperty(falamat);
    }
   
    public String getNim() {
        return nim.get();
    }
 
    public void setNim(String value) {
        nim.set(value);
    }
   
 
    public String getNama() {
        return nama.get();
    }
 
    public void setNama(String value) {
        nama.set(value);
    }
   
 
    public String getJurusan() {
        return jurusan.get();
    }
 
    public void setJurusan(String value) {
        jurusan.set(value);
    }
   
 
    public String getAlamat() {
        return alamat.get();
    }
 
    public void setAlamat(String value) {
        alamat.set(value);
    }
 
}