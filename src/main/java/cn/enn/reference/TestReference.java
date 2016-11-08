package cn.enn.reference;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestReference extends ClassLoader {
	private String name;
	private String path = "D:/workspace/springServlet/target/classes/cn/enn/reference/";
	private final String fileType = ".class";

	public TestReference(String name) {
		super();
		this.name = name;
	}

	public TestReference(ClassLoader parent, String name) {
		super(parent);
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String toString() {
		return this.name;
	}

	private byte[] loaderClassData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		this.name = this.name.replace(".", "/");
		try {
			is = new FileInputStream(new File(path + name + fileType));
			int c = 0;
			while (-1 != (c = is.read())) {
				baos.write(c);
			}
			data = baos.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		 byte[] data = loaderClassData(name);
	     return this.defineClass(name, data, 0, data.length);
	}

	public static void main(String[] args) throws Exception {
		
		//TestReference loader1 = new TestReference("TestReference");
       // loader1.setPath("D:/workspace/springServlet/target/classes/cn/enn/reference/");
        System.out.println(TestReference.class.getClassLoader().getClass().getName());
       // TestReference loader2 = new TestReference(loader1, "User");
       // loader2.setPath("D:/workspace/springServlet/target/classes/cn/enn/reference/");
      //  System.out.println(loader2.getClass().getClassLoader().getParent());
        TestReference loader3 = new TestReference(null, "User");
        loader3.setPath("D:/workspace/springServlet/target/classes/cn/enn/reference/");
        System.out.println(loader3.getClass().getClassLoader());

        /*Class clazz = loader2.loadClass("Sample");
        Object object = clazz.newInstance();*/
		
		
		
		
		/*User user = new User();
		user.setName("zb");
		user.setAge(22);
		SoftReference<Object> reference = new SoftReference<Object>(user);
		System.out.println(((User) reference.get()).getName());
		TestReference loader = new TestReference();

		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		System.out.println(loader.getClass().getClassLoader());
		System.out.println(loader.getClass().getClassLoader());
*/
	}
	
	public class Sample {

	    public Sample(){
	        System.out.println("Sample is loaded by " + this.getClass().getClassLoader());
	        new A();
	    }
	}
	public class A {

	    public A(){
	        System.out.println("A is loaded by " + this.getClass().getClassLoader());
	    }
	}
}
