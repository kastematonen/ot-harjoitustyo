package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikeis(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test
    public void kortilleVoiLadataRahaa(){
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test 
    public void maksaminenToimiiJosRahaaTarpeeksi(){
        kortti.otaRahaa(4);
        assertEquals("saldo: 0.6", kortti.toString());
    }
    @Test 
    public void maksaminenToimiiJosRahaaEiTarpeeksi(){
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test 
    public void maksaminenPalauttaaTrueJosOnnistuu(){
        Boolean vastaus=kortti.otaRahaa(4);
        assertEquals(true, vastaus);
    }
    @Test 
    public void maksaminenPalauttaaFalseJosEiOnnistu(){
        Boolean vastaus=kortti.otaRahaa(11);
        assertEquals(false, vastaus);
    }
    @Test
    public void saldonPalautusToimii(){
        assertEquals(10, kortti.saldo());
    }
}
