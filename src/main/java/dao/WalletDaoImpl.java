package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;


import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;

import exception.InsufficeintAmountException;
import exception.WalletException;

public class WalletDaoImpl implements WalletDao {


	//Map<Integer, Wallet> wallets = new HashMap<>();

	private List<Wallet> wallets = new ArrayList<>();


	@Override
	public Wallet addWallet(Wallet newWallet) throws WalletException {
		this.wallets.add( newWallet);
		return newWallet;

	}

	@Override
	public Wallet getWalletById(Integer walletId) throws WalletException, InsufficeintAmountException {
		for (int i=0 ; i < wallets.size(); i++ )
			if(wallets.get(i).getId() == walletId)
				return wallets.get(i);
		return new Wallet();
	}

	@Override
	public Wallet updateWallet(Wallet updateWallet) throws WalletException {
		for (int i = 0; i < wallets.size(); i++) {
			Wallet a = wallets.get(i);
			if (a.getId() == updateWallet.getId()) {
				a.setBalance(updateWallet.getBalance());
			}



		}
		return new Wallet();

	}

	@Override
	public Wallet deleteWalletById(Integer walletID) throws WalletException {
		wallets.removeIf(employee -> employee.getId().equals(walletID));
		System.out.println(" delete Account");

		return new Wallet();
	}
}

