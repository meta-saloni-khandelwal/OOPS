package dom;

import java.util.ArrayList;
import java.util.List;
/**
 * Class name-DOMHierarchy
 * Created on - 06/02/18
 * Reference no - OOPS-1
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */
 
/*
 * A class of Document Object Model Hierarchy
 */
public class DOMHierarchy {
	/**
	 * Below functions returns the object if id is equal to id if any object in hierarchy.
	 * @param id - stores the id of an element
	 * @param domList - list having all element of Document Object Model
	 * @return object of Element if id is found otherwise returns null
	 */
	public Element findElementById(String id, List<Element> domList){
		for(Element element : domList){
			if(id == element.getId()){
				return element;					//returns object of Element
			}
		}
		return null;
	}
	/**
	 * Below function returns list of object having class equals to cssClass in hierarchy.
	 * @param cssClass - stores the class of an element
	 * @param domList - list having all element of Document Object Model
	 * @return list of objects having same class
	 */
	
	public List<Element> findElementsByClass(String cssClass, List<Element> domList){
		List<Element> elementsOfClass = new ArrayList<Element>();		//List to store Elements having same class.
		for(Element element : domList){
			if(cssClass == element.getCssClassName()){
				elementsOfClass.add(element);
			}
		}
		return elementsOfClass;				//returns final list of Element
	}
}
