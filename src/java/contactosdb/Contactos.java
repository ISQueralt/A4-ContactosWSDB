/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactosdb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Queralt
 */
@Entity
@Table(name = "Contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c")
    , @NamedQuery(name = "Contactos.findByTel\u00e9fono", query = "SELECT c FROM Contactos c WHERE c.tel\u00e9fono = :tel\u00e9fono")
    , @NamedQuery(name = "Contactos.findByNombre", query = "SELECT c FROM Contactos c WHERE c.nombre = :nombre")})
public class Contactos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "Tel\u00e9fono")
    private String teléfono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre")
    private String nombre;

    public Contactos() {
    }

    public Contactos(String teléfono) {
        this.teléfono = teléfono;
    }

    public Contactos(String teléfono, String nombre) {
        this.teléfono = teléfono;
        this.nombre = nombre;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teléfono != null ? teléfono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.teléfono == null && other.teléfono != null) || (this.teléfono != null && !this.teléfono.equals(other.teléfono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contactosdb.Contactos[ tel\u00e9fono=" + teléfono + " ]";
    }
    
}
