package com.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean exit = false;
		while (!exit) {
			System.out.println(" Press\n 1 ->  Retrieve Data\n 2 -> Update Data\n 3 -> Exit");
			switch (scanner.nextInt()) {
			case 1:
				retrieveData();
				break;
			case 2:
				updateCity();
				break;
			case 3:
				exit = true;
			}
		}
	}

	private static void retrieveData() {
		AddressBook addressBookRepo = new AddressBook();
		List<Contacts> employeeInfoList = addressBookRepo.retrieveData();
		for (Contacts employee : employeeInfoList) {
			System.out.println(employee + "\n");
		}
	}

	private static void updateCity() {
		AddressBook addressBookRepo = new AddressBook();
		System.out.println("Enter the address, city, state, zipto Update");
		addressBookRepo.updateCityByZip(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt());
	}
}