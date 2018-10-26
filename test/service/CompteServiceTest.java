/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class CompteServiceTest {
    CompteService instance = new CompteService();
    
    public CompteServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ouvrirCompte method, of class CompteService.
     */
//    @Test
//    public void testOuvrirCompte() {
//        System.out.println("ouvrirCompte");
//        instance.ouvrirCompte("EE1", 10000);
//        instance.ouvrirCompte("EE2", 200);
//        instance.ouvrirCompte("EE3", 500);
//        instance.ouvrirCompte("EE4", 700);
//        instance.ouvrirCompte("EE5", 60000);
//        // TODO review the generated test code and remove the default call to fail.
//    }

    /**
     * Test of fermerCompte method, of class CompteService.
     */
    @Test
    public void testFermerCompte() {
        System.out.println("fermerCompte");
        String rib = "EE2";
        int expResult = -2;
        int result = instance.fermerCompte(rib);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of crediter method, of class CompteService.
     */
    @Test
    public void testCrediter() {
        System.out.println("crediter");
        String rib = "EE3";
        double montantCredit = 100.0;
        int expResult = 1;
        int result = instance.crediter(rib, montantCredit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of debiter method, of class CompteService.
     */
    @Test
    public void testDebiter() {
        System.out.println("debiter");
        String rib = "EE4";
        double montantDebit = 20000.0;
        int expResult = -1;
        int result = instance.debiter(rib, montantDebit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transferer method, of class CompteService.
     */
    @Test
    public void testTransferer() {
        System.out.println("transferer");
        String ribSource = "EE1";
        String ribDestination = "EE2";
        double montant = 35.0;
        int expResult = 1;
        int result = instance.transferer(ribSource, ribDestination, montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
