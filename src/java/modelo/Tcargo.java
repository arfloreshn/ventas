package modelo;
// Generated 05-13-2019 07:40:13 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tcargo generated by hbm2java
 */
public class Tcargo  implements java.io.Serializable {


     private Integer id;
     private String nomCargo;
     private Set templeadoses = new HashSet(0);

    public Tcargo() {
    }

    public Tcargo(String nomCargo, Set templeadoses) {
       this.nomCargo = nomCargo;
       this.templeadoses = templeadoses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomCargo() {
        return this.nomCargo;
    }
    
    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }
    public Set getTempleadoses() {
        return this.templeadoses;
    }
    
    public void setTempleadoses(Set templeadoses) {
        this.templeadoses = templeadoses;
    }




}


