package com.chzboi42.deverbose.xml;

import java.util.ArrayList;

import nu.xom.Document;
import nu.xom.Elements;

public class Element {

    protected nu.xom.Element xomElement;

    public Element(String name) {
        xomElement = new nu.xom.Element(name);
    }

    public Element(String name, Attribute... attributes) {
        xomElement = new nu.xom.Element(name);
        for (Attribute a : attributes) {
            xomElement.addAttribute(a);
        }
    }

    public Element(String name, String child) {
        xomElement = new nu.xom.Element(name);
        xomElement.appendChild(child);
    }

    public Element(String name, Attribute[] attributes, String child) {
        xomElement = new nu.xom.Element(name);
        for (Attribute a : attributes) {
            xomElement.addAttribute(a);
        }
        xomElement.appendChild(child);
    }

    public Element(String name, Element... children) {
        xomElement = new nu.xom.Element(name);
        for (Element el : children) {
            xomElement.appendChild(el.xomElement);
        }
    }

    public Element(String name, Attribute[] attributes, Element... children) {
        xomElement = new nu.xom.Element(name);
        for (Attribute a : attributes) {
            xomElement.addAttribute(a);
        }
        for (Element el : children) {
            xomElement.appendChild(el.xomElement);
        }
    }

    protected Element(nu.xom.Element element) {
        xomElement = element;
    }

    public String toXML() {
        Document doc = new Document(xomElement.copy());
        String xml = doc.toXML();
        doc.setRootElement(new nu.xom.Element("null"));
        return xml;
    }

    public String getName() {
        return xomElement.getLocalName();
    }

    public void setName(String name) {
        xomElement.setLocalName(name);
    }

    public void appendChild(Element... el) {
        for (Element e : el) {
            xomElement.appendChild(e.xomElement);
        }
    }

    public void removeChild(Element el) {
        xomElement.removeChild(el.xomElement);
    }

    public void removeChild(int index) {
        xomElement.removeChild(index);
    }

    /**
     * Removes the nth instance of the elements that are named elementName
     * @param elementName
     * @param n
     */
    public void removeChild(String elementName, int n) {
        xomElement.removeChild(getChildElement(elementName, n).xomElement);
    }

    public void addAttribute(String name, String value) {
        nu.xom.Attribute oldAttribute = xomElement.getAttribute(name);
        if (oldAttribute != null) {
            xomElement.removeAttribute(oldAttribute);
        }
        xomElement.addAttribute(new Attribute(name, value));
    }

    public void removeAttribute(Attribute attribute) {
        xomElement.removeAttribute(attribute);
    }

    public void removeAttribute(String name) {
        xomElement.removeAttribute(xomElement.getAttribute(name));
    }

    public Attribute getAttribute(String name) {
        return (Attribute) xomElement.getAttribute(name);
    }

    public Element[] getChildElements() {
        Elements xomChildren = xomElement.getChildElements();
        Element[] children = new Element[xomChildren.size()];
        for (int i = 0; i < children.length; i++) {
            children[i] = new Element(xomChildren.get(i));
        }
        return children;
    }

    public Element[] getChildElements(String... names) {
        ArrayList<Element> children = new ArrayList<>();
        for (Element el : getChildElements()) {
            for (String n : names) {
                if (el.getName().equals(n)) children.add(el);
            }
        }
        return children.toArray(Element[]::new);
    }

    public Element[] getChildElements(int... indices) {
        Elements xomChildren = xomElement.getChildElements();
        ArrayList<Element> children = new ArrayList<>();
        for (int index : indices) {
            children.add(new Element(xomChildren.get(index)));
        }
        return children.toArray(Element[]::new);
    }

    public Element getChildElement(int index) {
        return getChildElements(index)[0];
    }

    /**
     * Gets the nth instance of the child elements with the name.
     * @param name the name of the child element
     * @param n the instance to get
     * @return the specific element. For example, if the name was "worker" and n was 2, it would return the 2nd child element named "worker".
     */
    public Element getChildElement(String name, int n) {
        return getChildElements(name)[n-1];
    }

    public String getValue() {
        return xomElement.getValue();
    }

    public Element detach() {
        nu.xom.Element detached = xomElement.copy();
        detached.detach();
        return new Element(detached);
    }

    public Element getParent() {
        nu.xom.ParentNode parent = xomElement.getParent();
        if (parent instanceof nu.xom.Element element) {
            return new Element(element);
        }
        return null;
    }
}
    