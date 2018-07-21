/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author QQ
 */
@Entity
@Table(name = "Book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookBean.findAll", query = "SELECT b FROM BookBean b"),
    @NamedQuery(name = "BookBean.findByCode", query = "SELECT b FROM BookBean b WHERE b.code = :code"),
    @NamedQuery(name = "BookBean.findByTitle", query = "SELECT b FROM BookBean b WHERE b.title = :title"),

    @NamedQuery(name = "BookBean.findByTitleLike", query = "SELECT b FROM BookBean b WHERE b.title LIKE :title"),

    @NamedQuery(name = "BookBean.findByPrice", query = "SELECT b FROM BookBean b WHERE b.price = :price"),
    @NamedQuery(name = "BookBean.findByAuthor", query = "SELECT b FROM BookBean b WHERE b.author = :author")})
public class BookBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Code")
    private String code;
    @Size(max = 50)
    @Column(name = "Title")
    private String title;
    @Column(name = "Price")
    private Integer price;
    @Size(max = 50)
    @Column(name = "Author")
    private String author;

    public BookBean() {
    }

    public BookBean(String code) {
        this.code = code;
    }

    public BookBean(String code, String title, Integer price, String author) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookBean)) {
            return false;
        }
        BookBean other = (BookBean) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookBean[ code=" + code + " ]";
    }

}
