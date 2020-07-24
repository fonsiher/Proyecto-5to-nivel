package bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "beanProvincia")
@SessionScoped
public class BeanProvincia implements Serializable{
	
	public BeanProvincia() {
		
	}

}
