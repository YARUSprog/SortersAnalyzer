
package com.mycompany.lb1_sort_arrays.analyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lb1_sort_arrays.LB1_Sort_arrays;

/**
 * The <code>Reflections</code> class designed for implamentation of standart 
 * reflections.    
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class Reflections {
    
    /**
     * Looking classes that implements certain interface in the right package and in subpackage
     * @param pack the package which will look for classes
     * @param interfaceName name of the interface that classes should implement
     * @return a list of classes that implement the interface
     * @throws IllegalArgumentException if param is incorect 
      */
    public List getObjectsImplementers(String pack, String interfaceName) {
        if(pack == null || interfaceName == null || pack.length() == 0 || interfaceName.length() == 0){
            throw new IllegalArgumentException("pack == null or interfaceName == null or pack.length() == 0 or interfaceName.length() == 0");
        }
        List<Class> classes;
        List res;
        Class[] interfaces;
        try {
            classes = findeClasses(pack);
            res = new ArrayList<>();

            for (Class c : classes) {
                if (c == null || c.isInterface()) {
                    continue;
                }
                interfaces = c.getInterfaces();
                for (Class int_face : interfaces) {
                    if (int_face.getSimpleName().equals(interfaceName)) {
                        res.add(c.newInstance());
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(LB1_Sort_arrays.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return res;
    }
    
    /**
     * Looking classes that extendss certain class in the right package and in subpackage
     * @param pack the package which will look for classes
     * @param superclassName name of the class that classes should extend
     * @return a list of classes that extend the superclass
     * @throws IllegalArgumentException if param is incorect
     */
    public List getObjectsSubclasses(String pack, String superclassName) {
        if(pack == null || superclassName == null || pack.length() == 0 || superclassName.length() == 0){
            throw new IllegalArgumentException("pack == null || superclassName == null || pack.length() == 0 || superclassName.length() == 0");
        }        
        List<Class> classes;
        List res = null;        
        try {
            classes = findeClasses(pack);
            res = new ArrayList<>();

            for (Class c : classes) {
                if (c != null && !c.isInterface() && isDescendant(c, superclassName)) {
                    res.add(c.newInstance());
                }
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(LB1_Sort_arrays.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return res;
    }
    
    /**
     * Checks if class is a descendant of the desired class
     * @param cl class parents who want to check
     * @param superclassName the name of the intended superclass
     * @return true(if the class has this ancestor), false(if not)
     */
    public boolean isDescendant(Class cl, String superclassName) {
        if(cl == null || superclassName == null || superclassName.length() == 0){
            throw new IllegalArgumentException("cl == null || superclassName == null || superclassName.length() == 0");
        }
        while (true) {
            if (cl.getSuperclass().getCanonicalName().equals(superclassName)) {
                return true;
            }            
            if (cl.getSuperclass().getCanonicalName().equals(Object.class.getCanonicalName())) {
                return false;
            }
            cl = cl.getSuperclass();
        }
    }
    
    /**
     * Search all classes in the right package and in subpackage
     * @param pack the package which will look for classes
     * @return {@code List<Class>} whith all classes
     */
    public List<Class> findeClasses(String pack){
        if(pack == null || pack.length() == 0){
            throw new IllegalArgumentException("pack == null || pack.length() == 0");
        }        
        List<Class> classes;
        try {
            char sep = File.separatorChar;
            String path = new File(".").getCanonicalPath() + sep + "target" + sep
                    + "classes" + sep + pack.replace('.', sep);
            File dir = new File(path);
            File[] sourceFiles = dir.listFiles();
            classes = new ArrayList<>();
            for (File file : sourceFiles) {
                if (file.isDirectory()) {
                    List<Class> res = findeClasses(pack + "." + file.getName());
                    classes.addAll(res);
                    continue;
                }
                classes.add(Class.forName(pack + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LB1_Sort_arrays.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return classes;
    }
}
