package logic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//@JsonIgnoreProperties(ignoreUnknown = true)

public class MetadataOdata {
	    @JsonProperty("odata.metadata")
		  private String odataMetadata; 
	    @JsonProperty("value")
		  private List<Employee> values; 

		  public String getOdataMetadata(){
		  	return odataMetadata; 
		  }
		  public void setOdataMetadata(String input){
		  	 this.odataMetadata = input;
		  }
		  public List<Employee> getValue(){
		  	return values; 
		  }
		  public void setValue(List<Employee> input){
		  	 this.values = input;
		  }
}
