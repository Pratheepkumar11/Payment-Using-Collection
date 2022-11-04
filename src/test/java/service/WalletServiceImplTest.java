package service;

import dao.WalletDao;
import dao.WalletDaoImpl;
import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;
import exception.InsufficeintAmountException;
import exception.WalletException;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WalletServiceImplTest {

    static WalletService ws = new WalletServiceImpl();

    static Wallet x;
    static Wallet b;
    static Wallet c;

    static WalletDao wd = new WalletDaoImpl();

    @BeforeEach
    @Test
    void testBeforeAll() throws WalletException, InsufficeintAmountException, AlreadyExistingAccountNumberException {
        x = new Wallet(1, "dsp", 100.0, "d123");
        b = new Wallet(2, "wrt", 1000.0, "pass");
        c = new Wallet(3, "wrt2", 1000.0, "passw");
        ws.registerWallet(x);
        ws.registerWallet(b);
        ws.registerWallet(c);

    }



    @Test
    @DisplayName("Register")
    void test1() throws WalletException, InsufficeintAmountException, AlreadyExistingAccountNumberException {

        assertEquals(x,ws.registerWallet(x));
        assertEquals(b,ws.registerWallet(b));

    }

    @Test
    @DisplayName("withdraw")
    void test4() throws WalletException, InsufficeintAmountException {

        assertEquals(900.0, ws.withdraw(3, 100.00));


    }
    @Test
    @DisplayName("fundtransfer")
    void test3() throws WalletException, InsufficeintAmountException {

        assertEquals(true, ws.fundTransfer(1, 2, 100.00));
        assertEquals(false, ws.fundTransfer(2, 3, 10000.00));


    }

    @Test
    @DisplayName("Login")
    void test2() throws WalletException, InsufficeintAmountException {

        assertTrue(ws.login(1,"d123"));
        assertFalse(ws.login(3,"pass"));


    }





}