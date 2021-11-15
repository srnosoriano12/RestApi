package cundi.edu.co.registro.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@Embeddable
@MappedSuperclass
public class AutorEditorialPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="id_autor",nullable= false,foreignKey = @ForeignKey(name="FK_Autor_Editorial"))
	private Autor autor;
	@JoinColumn(name="id_editorial",nullable= false,foreignKey = @ForeignKey(name="FK_Editorial_Autor"))
	@ManyToOne
	private Editorial editorial;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(autor, editorial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorEditorialPK other = (AutorEditorialPK) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(editorial, other.editorial);
	}
					
}
