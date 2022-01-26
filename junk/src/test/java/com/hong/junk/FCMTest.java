package com.hong.junk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FCMTest {
	
	@Test
	public void test() throws IOException {
		
		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .build();

					FirebaseApp.initializeApp(options);
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
