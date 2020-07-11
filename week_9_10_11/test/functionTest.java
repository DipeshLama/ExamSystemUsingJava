/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dipesh
 */
public class functionTest {
    
    public functionTest() {
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

    @Test
    public void AdminSignUp(){ 
        student_database d= new student_database();
        int exp=1;
        int r=d.adminSignup("Dipesh Lama","dipeslama@gmail.com","admin");
        assertEquals(exp,r);
    }
    
    @Test
    public void studentSignup(){ 
        student_database d= new student_database();
        int exp=1;
        int r=d.signup("Dipesh Lama","dipeslama32@gmail.com","Pepsicola","Male","25B","student");
        assertEquals(exp,r);
    }
    
     
    @Test
    public void questionSave(){ 
        student_database d= new student_database();
        int exp=1;
        int r=d.java_question_save("Which of these is long data type literal?","0x99fffL","0x99fffa","99671246","abcdefg","0x99fffL");
        assertEquals(exp,r);
    }
}