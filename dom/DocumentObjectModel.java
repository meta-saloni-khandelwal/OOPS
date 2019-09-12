package dom;

import java.util.ArrayList;
/**
 * Class name-DocumentObjectModel
 * Created on - 06/02/18
 * Reference no - OOPS-1
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */
import java.util.List;
/*
 * Class to return id and cssClass of an element
 */
class SpanElement implements Element{
	public String id;
	public String cssClass;
	/**
	 * @param id -stores the id of an element
	 * @param cssClass - stores the class of an element
	 */
	public SpanElement(String id, String cssClass) {
    	this.id = id;
    	this.cssClass = cssClass;
	}
	public String getId(){
		return this.id;
	}
	public String getCssClassName(){
		return this.cssClass;
	}
	
	public Element getObject(){
		return new SpanElement(this.id,this.cssClass);
	}

}
/*
 * Class to return id and cssClass of an element
 */
class DivElement implements Element{
	public String id;
	public String cssClass;
	public List<Element> listOfInnerElements = new ArrayList<Element>();
	/**
	 * @param id -stores the id of an element
	 * @param cssClass - stores the class of an element
	 */
	public DivElement(String id, String cssClass) {
    	this.id = id;
    	this.cssClass = cssClass;
	}
	public String getId(){
		return this.id;
	}
	public String getCssClassName(){
		return this.cssClass;
	}
	public Element getObject(){
		return new DivElement(this.id,this.cssClass);
	}
}
/*
 * Class to return id and cssClass of an element
 */
class ButtonElement implements Element{
	public String id;
	public String cssClass;
	/**
	 * @param id -stores the id of an element
	 * @param cssClass - stores the class of an element
	 */
	public ButtonElement(String id, String cssClass) {
    	this.id = id;
    	this.cssClass = cssClass;
	}
	public String getId(){
		return this.id;
	}
	public String getCssClassName(){
		return this.cssClass;
	}
	public Element getObject(){
		return new ButtonElement(this.id,this.cssClass);
	}
	
}
/*
 * Class to return id and cssClass of an element
 */
class ImageElement implements Element{
	public String id;
	public String cssClass;
	public String source;
	/**
	 * @param id -stores the id of an element
	 * @param cssClass - stores the class of an element
	 */
	public ImageElement(String id, String cssClass, String src) {
    	this.id = id;
    	this.cssClass = cssClass;
    	this.source = source;
	}
	public String getId(){
		return this.id;
	}
	public String getCssClassName(){
		return this.cssClass;
	}
	public Element getObject(){
		return new ImageElement(this.id,this.cssClass, this.source = source);
	}
}

/*
 * class to implement Document Object Model
 */
public class DocumentObjectModel {

	public static void main(String []args){
		List<Element> domList = new ArrayList<Element>();					//List to store Elements in hierarchy
		DOMHierarchy DOM = new DOMHierarchy();
		
		Element div1 = new DivElement("div1", "border");					
		Element div2 = new DivElement("div2", "border");
		Element span1 = new SpanElement("span1", "color");
		Element img = new ImageElement("img1", "height", "D:\\img1.jpg");
		Element div3 = new SpanElement("div3", "color");
		Element button = new SpanElement("btn1", "padding");
		//Adding Elements to list
		domList.add(div1);
		domList.add(div2);
		domList.add(span1);
		domList.add(img);
		domList.add(div3);
		domList.add(button);
		
		Element foundElement = DOM.findElementById("div1", domList);
		
		List<Element> objectsOfClass = DOM.findElementsByClass("color", domList);
		
		System.out.println(foundElement.getId());
		System.out.println(foundElement);
		
		for(Element i : objectsOfClass){
	    	System.out.println(i.getId());
	    	System.out.println(i.getCssClassName());
		}
		
	}
	
}
