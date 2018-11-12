/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julia
 */
public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti kortti;
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassapaate=new Kassapaate();
        kortti=new Maksukortti(500);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
    
    @Test
    public void luodessaRahamaaraOikea() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void luodessaEdullisetLkmOikea() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void luodessaMaukkaatLkmOikea() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void riittavaKateismaksuEdullisetKassanRahamaaraOikea() {
        kassapaate.syoEdullisesti(240);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    @Test
    public void riittavaKateismaksuMaukkaatKassanRahamaaraOikea() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    @Test
    public void riittavaKateismaksuEdullisetVaihtorahamaaraOikea() {
        int raha=kassapaate.syoEdullisesti(300);
        assertEquals(60, raha);
    }
    @Test
    public void riittavaKateismaksuMaukkaastiVaihtorahamaaraOikea() {
        int raha=kassapaate.syoMaukkaasti(450);
        assertEquals(50, raha);
    }
    @Test
    public void riittavaKateismaksuEdullisetKasvaa() {
        kassapaate.syoEdullisesti(240);
        int lounaat=kassapaate.edullisiaLounaitaMyyty();
        assertEquals(1, lounaat);
    }
    @Test
    public void riittavaKateismaksuMaukkaatKasvaa() {
        kassapaate.syoMaukkaasti(400);
        int lounaat=kassapaate.maukkaitaLounaitaMyyty();
        assertEquals(1, lounaat);
    }
    
    @Test
    public void eiRiittavaKateismaksuEdullisetKassanRahamaaraOikea() {
        kassapaate.syoEdullisesti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    @Test
    public void eiRiittavaKateismaksuMaukkaatKassanRahamaaraOikea() {
        kassapaate.syoMaukkaasti(300);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    @Test
    public void eiRiittavaKateismaksuEdullisetVaihtorahamaaraOikea() {
        int raha=kassapaate.syoEdullisesti(200);
        assertEquals(200, raha);
    }
    @Test
    public void eiRiittavaKateismaksuMaukkaastiVaihtorahamaaraOikea() {
        int raha=kassapaate.syoMaukkaasti(350);
        assertEquals(350, raha);
    }
    @Test
    public void eiRiittavaKateismaksuEdullisetEiKasva() {
        kassapaate.syoEdullisesti(200);
        int lounaat=kassapaate.edullisiaLounaitaMyyty();
        assertEquals(0, lounaat);
    }
    @Test
    public void eiRiittavaKateismaksuMaukkaatEiKasva() {
        kassapaate.syoMaukkaasti(40);
        int lounaat=kassapaate.maukkaitaLounaitaMyyty();
        assertEquals(0, lounaat);
    }
    @Test
    public void riittavaKorttismaksuEdullisetKassanRahamaaraOikea() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    @Test
    public void riittavaKorttismaksuMaukkaatKassanRahamaaraOikea() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    @Test
    public void riittavaKorttismaksuEdullisetKortinRahamaaraOikea() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals("saldo: 2.60", kortti.toString());
    }
    @Test
    public void riittavaKorttismaksuMaukkaatKortinRahamaaraOikea() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    @Test
    public void riittavaKorttismaksuEdullisetPalauttaaTrue() {
        boolean onko = kassapaate.syoEdullisesti(kortti);
        assertEquals(true, onko);
    }
    @Test
    public void riittavaKorttismaksuMaukkaatPalauttaaTrue() {
        boolean onko = kassapaate.syoMaukkaasti(kortti);
        assertEquals(true, onko);
    }
    @Test
    public void riittavaKorttismaksuEdullisetLounaatKasvaa() {
        kassapaate.syoEdullisesti(kortti);
        int lounaat=kassapaate.edullisiaLounaitaMyyty();
        assertEquals(1,lounaat);
    }
    @Test
    public void riittavaKorttismaksuMaukkaatLounaatKasvaa() {
        kassapaate.syoMaukkaasti(kortti);
        int lounaat=kassapaate.maukkaitaLounaitaMyyty();
        assertEquals(1,lounaat);
    }
    @Test
    public void eiRiittavaKorttismaksuEdullisetKortinRahamaaraOikea() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoEdullisesti(kortti);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    @Test
    public void eiRiittavaKorttismaksuMaukkaatKortinRahamaaraOikea() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    @Test
    public void eiRiittavaKorttismaksuEdullisetPalauttaaFalse() {
        kassapaate.syoMaukkaasti(kortti);
        boolean onko = kassapaate.syoEdullisesti(kortti);
        assertEquals(false, onko);
    }
    @Test
    public void eiRiittavaKorttismaksuMaukkaatPalauttaaFalse() {
        kassapaate.syoMaukkaasti(kortti);
        boolean onko = kassapaate.syoMaukkaasti(kortti);
        assertEquals(false, onko);
    }
    @Test
    public void eiRiittavaKorttismaksuEdullisetLounaatEiKasvaa() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoEdullisesti(kortti);
        int lounaat=kassapaate.edullisiaLounaitaMyyty();
        assertEquals(0,lounaat);
    }
    @Test
    public void eiRiittavaKorttismaksuMaukkaatLounaatEiKasvaa() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        int lounaat=kassapaate.maukkaitaLounaitaMyyty();
        assertEquals(1,lounaat);
    }
    @Test
    public void ladattaessaPositiivistaRahaaKortilleSaldoMuuttuu() {
        kassapaate.lataaRahaaKortille(kortti, 10);
        int rahatKortilla=kortti.saldo();
        assertEquals(510,rahatKortilla);
    }
    @Test
    public void ladattaessaPositiivistaRahaaKortilleKassanRahatMuuttuu() {
        kassapaate.lataaRahaaKortille(kortti, 10);
        int rahaa=kassapaate.kassassaRahaa();
        assertEquals(100010,rahaa);
    }
    @Test
    public void ladattaessaNegatiivistaRahaaKortilleSaldoMuutu() {
        kassapaate.lataaRahaaKortille(kortti, -10);
        int rahatKortilla=kortti.saldo();
        assertEquals(500,rahatKortilla);
    }
    @Test
    public void ladattaessaNegatiivistaRahaaKortilleKassanRahatEiMuutu() {
        kassapaate.lataaRahaaKortille(kortti, -10);
        int rahaa=kassapaate.kassassaRahaa();
        assertEquals(100000,rahaa);
    }
}
