import java.util.ArrayList;

public class ScraperThread implements Runnable {
	private Website website;
	private ThreadListener listener;
	private String prefix;
	private String year;
	private int suffixFirst;
	private int suffixLast;
	private ArrayList<Student> list_student;
	// TODO: constructor
	public ScraperThread(Website website, ThreadListener listener, String prefix, String year, int suffixFirst, int suffixLast) {
		this.website = website;
		this.listener = listener;
		this.prefix = prefix;
		this.year = year;
		this.suffixFirst = suffixFirst;
		this.suffixLast = suffixLast;
		this.list_student = new ArrayList<Student>();
	}

	// TODO: thread method
	// PROCEDURE:
	// 1. Construct NIM from given prefix, year, and suffixes.
	// 2. For each NIM constructed, get data from website.
	// 3. For each student data got from website, store in ArrayList
	public void run() {
		for (int i = suffixFirst; i <= suffixLast; i++) {
			String nim = prefix + year + String.format("%3d", i);
			Student student = this.website.getStudentDataByNIM(nim);
			list_student.add(student);
		}
		listener.onSuccess(list_student);
	}
}