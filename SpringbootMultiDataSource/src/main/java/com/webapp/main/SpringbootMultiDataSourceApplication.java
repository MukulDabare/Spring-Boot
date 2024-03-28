package com.webapp.main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.main.book.repository.BookRepository;
import com.webapp.main.model.book.Book;
import com.webapp.main.model.user.User;
import com.webapp.main.user.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@RestController

public class SpringbootMultiDataSourceApplication {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User(222, "john"),new User(55,"eva"))
				.collect(Collectors.toList()));
		
		bookRepository.saveAll(Stream.of(new Book(56, "Spring "),new Book(25,"SprinBoot"))
				.collect(Collectors.toList()));
	}
	
	@GetMapping("/getUser")
	public List<User> getUser(){
		return userRepository.findAll();
	}
	@GetMapping("/getBook")
	public List<Book> getBook(){
		return bookRepository.findAll();
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMultiDataSourceApplication.class, args);
		
	}

}
