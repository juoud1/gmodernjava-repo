package com.dobatii.gworkummymodernjava.ws.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Province extends AbstractPersistable<String> {
	private String provinceName;
	private String provinceCode;
	
	@Override
	public int hashCode() {
		return Objects.nonNull(provinceCode) ? provinceCode.hashCode() : 0;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (Objects.equals(this, object))
			return true;
		
		if (!super.equals(object))
			return false;
		
		if (!(object instanceof Province))
			return false;
		
		Province other = (Province) object;
		if (Objects.isNull(provinceCode)) {
			if (Objects.nonNull(other.provinceCode))
				return false;
			
		} else if (!Objects.equals(provinceCode, other.provinceCode)) {
			return false;
		}
			
		
		return true;
	}
}
