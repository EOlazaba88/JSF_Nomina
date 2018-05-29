/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "sueldo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sueldo.findAll", query = "SELECT s FROM Sueldo s")
    , @NamedQuery(name = "Sueldo.findByIdEmp", query = "SELECT s FROM Sueldo s WHERE s.idEmp = :idEmp")
    , @NamedQuery(name = "Sueldo.findByTipoEmp", query = "SELECT s FROM Sueldo s WHERE s.tipoEmp = :tipoEmp")
    , @NamedQuery(name = "Sueldo.findBySueldoEmp", query = "SELECT s FROM Sueldo s WHERE s.sueldoEmp = :sueldoEmp")
    , @NamedQuery(name = "Sueldo.findByFondoEmp", query = "SELECT s FROM Sueldo s WHERE s.fondoEmp = :fondoEmp")
    , @NamedQuery(name = "Sueldo.findByDiasVaca", query = "SELECT s FROM Sueldo s WHERE s.diasVaca = :diasVaca")})
public class Sueldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_emp")
    private Integer idEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_emp")
    private String tipoEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo_emp")
    private int sueldoEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fondo_emp")
    private int fondoEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_vaca")
    private int diasVaca;
    @JoinColumn(name = "id_emp", referencedColumnName = "id_emp", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado;

    public Sueldo() {
    }

    public Sueldo(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Sueldo(Integer idEmp, String tipoEmp, int sueldoEmp, int fondoEmp, int diasVaca) {
        this.idEmp = idEmp;
        this.tipoEmp = tipoEmp;
        this.sueldoEmp = sueldoEmp;
        this.fondoEmp = fondoEmp;
        this.diasVaca = diasVaca;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public String getTipoEmp() {
        return tipoEmp;
    }

    public void setTipoEmp(String tipoEmp) {
        this.tipoEmp = tipoEmp;
    }

    public int getSueldoEmp() {
        return sueldoEmp;
    }

    public void setSueldoEmp(int sueldoEmp) {
        this.sueldoEmp = sueldoEmp;
    }

    public int getFondoEmp() {
        return fondoEmp;
    }

    public void setFondoEmp(int fondoEmp) {
        this.fondoEmp = fondoEmp;
    }

    public int getDiasVaca() {
        return diasVaca;
    }

    public void setDiasVaca(int diasVaca) {
        this.diasVaca = diasVaca;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmp != null ? idEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sueldo)) {
            return false;
        }
        Sueldo other = (Sueldo) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sueldo[ idEmp=" + idEmp + " ]";
    }
    
}
