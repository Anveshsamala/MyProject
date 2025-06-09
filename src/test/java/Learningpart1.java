import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learningpart1 {
	static WebDriver driver;

	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		int z = 10;
		byte b = (byte) z;
		System.out.println(b);
		reverseString("Anvesh");
	}

	public static void ArrayandStringconceptsandpremitivetype() {
		// String(Non Premitive) Immutable case-When we create String object with same
		// name it will create only one object
		String a = "Anvesh";
		String b = "ANVESH";
		String k = b;
		System.out.println(k);
		String c = new String("Anvesh");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		// premitive-
		int x = 10;
		int y = x;
		y = 120;
		System.out.println(x);
		System.out.println(y);
		// Array(Mutable)-Non Premitive-Each and every time new object created here
		int[] d = { 1, 2, 3, 4, 5 };
		int[] e = d;
		int[] f = { 5, 6, 7, 8 };
		int[] g = { 5, 6, 7, 8 };

	}

	public static String reverseString(String x) {
		String y = "";
		for (int i = x.length() - 1; i >= 0; i--) {
			y = y + x.charAt(i);
		}
		System.out.println(y);
		return y;

	}

	public WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("browser is not available for ur test");
		}
		return driver;
	}

	public int add(int a, int b) {

		return a + b;
	}
	public double add(double c, double d) {
		return c+d;
	}
	public double add(double x, double y, double z) {
		return x+y-z;
	}
	public double add(int g, double h) {
		return g-h;
	}
	

}
