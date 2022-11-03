package controller;



import dao.WalletDao;
import dao.WalletDaoImpl;
import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;
import exception.InsufficeintAmountException;
import exception.WalletException;
import service.WalletService;
import service.WalletServiceImpl;


import java.util.Scanner;


public class Controller {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		WalletService ws = new WalletServiceImpl();

		Wallet a,b,c;
		try {
			a = new Wallet(1, "dsp", 100.0, "d123");
			b = new Wallet(2, "wrt", 1000.0, "pass");

			System.out.println("After Calling Register");
			System.out.println(ws.registerWallet(a));
			System.out.println(ws.registerWallet(b));
			System.out.println(" 1. Login , 2. Register");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("After Login");


				boolean d;
				d = ws.login(2, "pass");
				System.out.println(d);
				System.out.println("Login Successfully ");
				if (d) {
					{
						System.out.println("1. Add Fund , 2. ShowBalance , 3. FundTransfer ,  4. Withdraw , 5. UnRegister ");
						int ch = sc.nextInt();

						if (ch == 1) {
							System.out.println("After Calling Add funds Wallet");
							System.out.println(ws.addFundsToWallet(1, 20.0));
						} else if (ch == 2) {
							System.out.println("After Calling ShowWalletBalance");
							System.out.println(ws.showWalletBalance(1));
						} else if (ch == 3) {

							System.out.println("After Calling Fund Transfer");
							System.out.println(ws.fundTransfer(1, 2, 40.0));
							System.out.println("From Wallet");
							System.out.println(ws.showWalletBalance(1));
							System.out.println("After To Wallet");
							System.out.println(ws.showWalletBalance(2));
						} else if (ch == 4) {
							System.out.println("After Calling Withdraw");
							System.out.println(ws.withdraw(2, 100.0));
						} else if (ch == 5) {
							System.out.println("After Calling delete Account");
							System.out.println(ws.unRegisterWallet(2, "pass"));
						}
					}


				}

			}
			else if (choice == 2) {
				c = new Wallet(3, "prathe8", 108.0, "password");
				System.out.println(ws.registerWallet(c));
			}













		}catch (WalletException | AlreadyExistingAccountNumberException | InsufficeintAmountException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}




	}
}


