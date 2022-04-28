import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class LaptopTest {
    // Anda boleh menambahkan atribut yang diperlukan
    private String className;

    public LaptopTest(String className) {
        /**
         * Memeriksa apakah ada kelas dengan nama className.
         * Jika tidak, tuliskan "Tidak ada kelas dengan nama yang diberikan" (tanpa petik) ke layar
         */
        this.className = className;
        try{
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Tidak ada kelas dengan nama yang diberikan");
        }
    }

    public boolean testMethods() {
        boolean isPass = true;
        try{
            Method m[] = Class.forName(className).getDeclaredMethods();
            if (m.length == 1) {
                if (!m[0].getName().equals("getRamSize")) {
                    System.out.println("Nama method harus getRamSize");
                    isPass = false;
                }
                if (!m[0].getReturnType().equals(Integer.class)) {
                    System.out.println("Tipe return method harus Integer");
                    isPass = false;
                }
                // Jika nama method bukan getRamSize, tuliskan "Nama method harus getRamSize" (tanpa petik) ke layar
                // Jika tipe return bukan Integer, tuliskan "Tipe return method harus Integer" (tanpa petik) ke layar
            } else {
                System.out.println("Banyaknya method hanya boleh 1");
                isPass = false;
                // Menuliskan "Banyaknya method hanya boleh 1" (tanpa petik) ke layar
            }
        } catch (Exception e) {
            isPass = false;
        }
        return isPass;
        // Return true jika semua tes berhasil
        // Jika ada 1 yang salah, return false
    }

    public boolean testFields() {
        boolean isPass = true;
        try{
            Field f[] = Class.forName(className).getDeclaredFields();
            if (f.length == 1) {
                // Jika nama field bukan serialNumber, tuliskan "Nama field harus serialNumber" (tanpa petik) ke layar
                if (!f[0].getName().equals("serialNumber")){
                    System.out.println("Nama field harus serialNumber");
                    isPass = false;
                }
                // Jika tipe return bukan String, tuliskan "Tipe field harus String" (tanpa petik) ke layar
                if (!f[0].getType().equals(String.class)) {
                    System.out.println("Tipe field harus String");
                    isPass = false;
                }
            } else {
                // Menuliskan "Banyaknya field hanya boleh 1" (tanpa petik) ke layar
                System.out.println("Banyaknya field hanya boleh 1");
                isPass = false;
            }    
        } catch (Exception e) {
            isPass = false;
        }
        // Return true jika semua tes berhasil
        return isPass;
        // Jika ada 1 yang salah, return false
    }
}