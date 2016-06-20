package day24_classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo2MyClassLoader extends ClassLoader {
	private String rootDir;

	public Demo2MyClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {

//		String extname = name.replace(".", "\\");
//		String filename = rootDir + "\\" + extname + ".class";
		
		String extname = name.replace(".", "/");
		String filename = rootDir + "/" + extname + ".class";

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			InputStream is = new FileInputStream(filename);
			int len = -1;
			byte[] b = new byte[1024];

			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			baos.flush();
			baos.close();
			is.close();

			byte[] data = baos.toByteArray();

			return defineClass(name, data, 0, data.length);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
