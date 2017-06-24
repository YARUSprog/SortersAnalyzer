
package com.mycompany.lb1_sort_arrays.analyzer;

import com.mycompany.lb1_sort_arrays.sorters.Sorter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YARUS
 */
public class ReflectionsTest {
    
    public ReflectionsTest() {
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
     * Test of getObjectsImplementers method, of class Reflections.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testGetObjectsImplementersTime() {
        System.out.println("getObjectsImplementers");
        String pack = "com.mycompany.lb1_sort_arrays.fillers";
        String interfaceName = "Generator";
        Reflections instance = new Reflections();        
        instance.getObjectsImplementers(pack, interfaceName);
    }

    /**
     * Test of getObjectsImplementers method, of class Reflections.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGetObjectsImplementersInputBadParams() {
        System.out.println("getObjectsImplementers");
        String pack = "";
        String interfaceName = "";
        Reflections instance = new Reflections();        
        instance.getObjectsImplementers(pack, interfaceName);
        instance.getObjectsImplementers(null, null);        
    }
    
    /**
     * Test of getObjectsImplementers method, of class Reflections.
     */
    @Test
    public void testGetObjectsImplementers() {
        System.out.println("getObjectsImplementers");
        String pack = "com.mycompany.lb1_sort_arrays.fillers";
        String interfaceName = "Generator";
        Reflections instance = new Reflections();
        int expResult = 1;
        List result = instance.getObjectsImplementers(pack, interfaceName);
        assertEquals(expResult, result.size());
    }
    
    /**
     * Test of getObjectsSubclasses method, of class Reflections.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testGetObjectsSubclassesTime() {
        System.out.println("getObjectsSubclasses");
        String pack = "com.mycompany.lb1_sort_arrays.sorters";
        String superclassName = Sorter.class.getCanonicalName();
        Reflections instance = new Reflections();        
        instance.getObjectsSubclasses(pack, superclassName);
    }

    /**
     * Test of getObjectsSubclasses method, of class Reflections.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testgetObjectsSubclassesInputBadParams() {
        System.out.println("getObjectsImplementers");
        String pack = "";
        String superclassName = "";
        Reflections instance = new Reflections();        
        instance.getObjectsImplementers(pack, superclassName);
        instance.getObjectsImplementers(null, null);      
    }
    
    /**
     * Test of getObjectsSubclasses method, of class Reflections.
     */
    @Test
    public void testGetObjectsSubclasses() {
        System.out.println("getObjectsSubclasses");
        String pack = "com.mycompany.lb1_sort_arrays.sorters";
        String superclassName = Sorter.class.getCanonicalName();
        Reflections instance = new Reflections();
        int expResult = 7;
        List result = instance.getObjectsSubclasses(pack, superclassName);
        assertEquals(expResult, result.size());        
    }
    
    /**
     * Test of isDescendant method, of class Reflections.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testIsDescendantTime() {
        System.out.println("isDescendant");
        Class cl = Integer.class;
        String superclassName = Number.class.getCanonicalName();
        Reflections instance = new Reflections();        
        instance.isDescendant(cl, superclassName);
    }    

    /**
     * Test of IsDescendant method, of class Reflections.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIsDescendantInputBadParams() {
        System.out.println("isDescendant");
        Class cl = Integer.class;
        String superclassName = "";
        Reflections instance = new Reflections();        
        boolean result = instance.isDescendant(cl, superclassName);        
        instance.getObjectsImplementers(null, null);      
    }
    
    /**
     * Test of isDescendant method, of class Reflections.
     */
    @Test
    public void testIsDescendant() {
        System.out.println("isDescendant");
        Class cl = Integer.class;
        String superclassName = Number.class.getCanonicalName();
        Reflections instance = new Reflections();
        boolean expResult = true;
        boolean result = instance.isDescendant(cl, superclassName);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.isDescendant(cl, Long.class.getCanonicalName());
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findeClasses method, of class Reflections.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testFindeClassesTime() {
        System.out.println("findeClasses");
        String pack = "com.mycompany.lb1_sort_arrays.sorters";
        Reflections instance = new Reflections();        
        instance.findeClasses(pack);        
    }

    /**
     * Test of findeClasses method, of class Reflections.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testFindeClassesInputBadParams() {
        System.out.println("findeClasses");        
        String pack = "";
        Reflections instance = new Reflections();        
        instance.findeClasses(pack);        
        instance.findeClasses(null);        
    }
    
    /**
     * Test of findeClasses method, of class Reflections.
     */
    @Test
    public void testFindeClasses() {
        System.out.println("findeClasses");
        String pack = "com.mycompany.lb1_sort_arrays.sorters";
        Reflections instance = new Reflections();
        int expResult = 8;
        List<Class> result = instance.findeClasses(pack);
        assertEquals(expResult, result.size());
    }
    
}
