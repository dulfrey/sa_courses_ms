package sa.center.model;

import javax.persistence.*;

@Entity
@Table(name = "center")
@NamedQueries({@NamedQuery(name = Center.FIND_ALL, query = "SELECT u FROM Course u")})
public class Center {

    public static final String FIND_ALL = "Center.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private Double lat;
	private Double lon;
    private String address;

    public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
    public String getAddress(){
        return address;
      }
      public void setAddress(String address){
        this.address = address;
      }
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }
    
}