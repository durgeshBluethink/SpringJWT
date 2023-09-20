package com.security.springSecurity;

import com.security.springSecurity.entitys.User;
import com.security.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("working");
		User user1=new User();

	//User user= new User("durgesh", "asdf", "asdf@gmail.com");
		//System.out.println(user1);
      user1.setEmail("durgesh@gmail.com");
	  user1.setUserName("durgesh");
	  user1.setPassword(this.bCryptPasswordEncoder.encode("bluethink"));
	  user1.setRole("role_Normal");
	  this.userRepository.save(user1);
		User user2=new User();
		user2.setEmail("kumar@gmail.com");
		user2.setUserName("kumar");
		user2.setPassword(this.bCryptPasswordEncoder.encode("bluethink@12"));
		user2.setRole("role_Admin");
		this.userRepository.save(user2);




	}
}
