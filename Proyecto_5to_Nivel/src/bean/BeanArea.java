package bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "beanArea")
@SessionScoped
public class BeanArea implements Serializable{
	
	
	public BeanArea() {
		
	}

}
