/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmp", query = "SELECT e FROM Empleado e WHERE e.idEmp = :idEmp")
    , @NamedQuery(name = "Empleado.findByNombreEmp", query = "SELECT e FROM Empleado e WHERE e.nombreEmp = :nombreEmp")
    , @NamedQuery(name = "Empleado.findByApellidoEmp", query = "SELECT e FROM Empleado e WHERE e.apellidoEmp = :apellidoEmp")
    , @NamedQuery(name = "Empleado.findByNip", query = "SELECT e FROM Empleado e WHERE e.nip = :nip")
    , @NamedQuery(name = "Empleado.findByFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Empleado.findByNumImss", query = "SELECT e FROM Empleado e WHERE e.numImss = :numImss")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emp")
    private Integer idEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_emp")
    private String nombreEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido_emp")
    private String apellidoEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nip")
    private int nip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_imss")
    private int numImss;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Sueldo sueldo;

    public Empleado() {
    }

    public Empleado(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Empleado(Integer idEmp, String nombreEmp, String apellidoEmp, int nip, Date fechaIngreso, int numImss) {
        this.idEmp = idEmp;
        this.nombreEmp = nombreEmp;
        this.apellidoEmp = apellidoEmp;
        this.nip = nip;
        this.fechaIngreso = fechaIngreso;
        this.numImss = numImss;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getApellidoEmp() {
        return apellidoEmp;
    }

    public void setApellidoEmp(String apellidoEmp) {
        this.apellidoEmp = apellidoEmp;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getNumImss() {
        return numImss;
    }

    public void setNumImss(int numImss) {
        this.numImss = numImss;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public void setSueldo(Sueldo sueldo) {
        this.sueldo = sueldo;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleado[ idEmp=" + idEmp + " ]";
    }
    
}
