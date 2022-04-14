public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        // Set seluruh atribut dengan nilai 0
    	this.hour = 0;
    	this.minute = 0;
    	this.second = 0;
    }

    public Time(int hour, int minute, int second) {
    	this.hour = hour;
    	this.minute = minute;
    	this.second = second;
    }

    public Time(Time t) {
        // Set atribut dengan atribut milik t
    	this.hour = t.hour;
    	this.minute = t.minute;
    	this.second = t.second;
    }

    public int getHour() {
    	return this.hour;
    }

    public void setHour(int hour) {
    	this.hour = hour;
    }

    public int getMinute() {
    	return this.minute;
    }

    public void setMinute(int minute) {
    	this.minute = minute;
    }

    public int getSecond() {
    	return this.second;
    }

    public void setSecond(int second) {
    	this.second = second;
    }

    public int convertToSecond() {
    	return ((this.hour * 3600) + (this.minute * 60) + this.second);
    }

    public Time add(Time t) {
        // Return penjumlahan dua objek jam, yaitu *this* dan t.
        // Apabila hasil penjumlahan melebihi 23:59:59, maka Anda harus mengonversinya seperti tampilan jam digital asli.
        // Contoh : 24:00:00 dituliskan 00:00:00, 25:00:00 dituliskan 01:00:00, dst.
    	Time result = new Time();
    	int sec_total = this.second + t.second;
    	int min_total = this.minute + t.minute + (sec_total/60);
    	int hour_total = this.hour + t.hour + (min_total/60);
    	result.setSecond(sec_total % 60);
    	result.setMinute(min_total % 60);
    	result.setHour(hour_total % 24);
    	return result;
    }

    public Time minus(Time t) {
        // Return selisih antara dua objek jam, yaitu *this* dan t.
        // Perhitungan selisih hanya dapat dilakukan jika objek ruas kiri lebih akhir dari atau sama dengan objek ruas kanan.
        // Jika objek ruas kiri lebih awal, maka kembalikan nilai objek ruas kiri.
        // Contoh: 00:00:01 - 00:00:02 = 00:00:01
    	Time result = new Time();
    	int sec_total = this.convertToSecond() - t.convertToSecond();
    	if (sec_total < 0) {
    		return this;
    	}
    	else {
    		result.setHour(sec_total/3600);
    		sec_total = sec_total%3600;
    		result.setMinute(sec_total/60);
    		sec_total = sec_total%60;
    		result.setSecond(sec_total);
    		return result;
    	}
    }

    public boolean lessThan(Time t) {
        // Returns true jika *this* < t menurut definisi waktu
    	return (this.convertToSecond() < t.convertToSecond());
    }

    public boolean greaterThan(Time t) {
        // Returns true jika *this* > t menurut definisi waktu
    	return (this.convertToSecond() > t.convertToSecond());    	
    }

    public void printTime() {
        // Menuliskan jam dalam format hh:mm:ss diakhiri dengan newline. Perhatikan bahwa setiap parameter harus dituliskan 2 digit.
    	System.out.print(String.format("%02d", this.hour));
    	System.out.print(":");
    	System.out.print(String.format("%02d", this.minute));
    	System.out.print(":");
    	System.out.print(String.format("%02d", this.second));
    	System.out.println();
    }
}