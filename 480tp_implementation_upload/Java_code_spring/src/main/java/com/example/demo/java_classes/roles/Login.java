package com.example.demo.java_classes.roles;

import com.example.demo.java_classes.connections.LoginConnection;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
@RequestMapping("/login-role")

public class Login {

	private String userEmail;
	private String password;
	private LoginConnection loginConnector;

	@Autowired
	public Login(String userEmail, String password) {
		this.userEmail = userEmail;
		this.password = password;
		loginConnector = new LoginConnection();
	}

	@GetMapping("/get-email")
	public String getUserEmail() {
        return this.userEmail;
    }

	@PostMapping("/set-email")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

	@GetMapping("/get-password")
	public String getPassword() {
        return this.password;
    }

	@PostMapping("/set-paassword")
    public void setPassword(String password) {
        this.password = password;
    }

	@PostMapping("/create-account")
	public void createNewAccount() {
		loginConnector.createNewAccount(userEmail, password);
	}

	@GetMapping("/get-accounts")
	public String[] getAccountsInfo() {
		return loginConnector.getAllAccounts();
	}
	
	@GetMapping("/run-main")
    public static void main(String[] args) {

		System.out.println("\nstart\n");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("\nEnter 0 to quit the java server, or anything else to keep it running: ");
			String choice = scanner.nextLine();
			if (choice.equals("0")) {
				scanner.close();
				break;
			}
			else {
				continue;
			}
		}

		System.out.println("\nend\n");
	}

}