package photoapp.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;

public class PhotoUtil {
	public static String getStringFromFile(ServletContext servletContext, String resourcePath) {
		byte[] content = null;
		URL url = null;
		File file = null;
		Path filePath = null;
		try {
			url = servletContext.getResource(resourcePath);
			file = new File(url.toURI());
			filePath = Paths.get(file.getPath());
			content = Files.readAllBytes(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new String(content);
	}

	public static byte[] loadImageFile(ServletContext servletContext, String resourcePath) {
		byte[] imageData = null;
		URL url = null;
		File file = null;
		Path filePath = null;
		try {
			url = servletContext.getResource(resourcePath);
			file = new File(url.toURI());
			filePath = Paths.get(file.getPath());
			imageData = Files.readAllBytes(filePath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageData;
	}

	public static String genSha256Code(String s) {
		String hashedStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(s.getBytes(StandardCharsets.UTF_8));
			hashedStr = DatatypeConverter.printHexBinary(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashedStr;
	}
}

