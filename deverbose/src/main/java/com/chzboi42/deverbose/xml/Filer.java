package com.chzboi42.deverbose.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;

public class Filer {

    private final File file;
    private Document doc;

    /**
     * Creates a new Filer that can read and write from the file
     * @param file the file to read/write from
     */
    public Filer(File file) {
        this.file = file;
    }

    /**
     * Creates a new Filer that can read and write from the file
     * @param filePath the path of the file to read/write from
     */
    public Filer(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Saves the string to the Filer's file
     * @param str the string to write
     */
    public void saveToStorage(String str) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
            output.write(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file!" + e.getMessage());
        }
    }

    /**
     * Saves the element to the Filer's file. 
     * This element is treated as the root and it, along with its children, will overwrite anything else in the file.
     * @param el the root element to write to the file
     */
    public void saveToStorage(Element el) {
        saveToStorage(el.toXML());
    }

    /**
     * Converts the read file to XML format.
     * Only to be used when reading an XML file.
     * If you are writing to the file, use {@link Element#toXML()} instead.
     * @return
     */
    public String toXML() {
        if (doc == null) throw new NullPointerException("The file has not yet been moved to memory!");
        return doc.toXML();
    }

    /**
     * Gets the root element. 
     * @return the root element of the XML file.
     */
    public Element getRootElement() {
        if (doc == null) throw new NullPointerException("The file has not yet been moved to memory!");
        return new Element(doc.getRootElement());
    }

    public Filer moveToMemory() {
        try {
            doc = new Builder().build(file);
        } catch (ParsingException | IOException ex) {
            throw new RuntimeException("Error: Could not read file!");
        }
        return this;
    } 

}
