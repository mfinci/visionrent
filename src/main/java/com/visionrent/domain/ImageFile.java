package com.visionrent.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_imagefile")
public class ImageFile {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;

	private String type;

	private long length;
	@OneToOne(cascade = CascadeType.ALL) // ImageFile silinirse , imagedata da silisin
	private ImageData imageData;
	
	
	public ImageFile(String name,String type, ImageData imageData) {
		this.name=name;
		this.type=type;
		this.imageData=imageData;
		this.length=imageData.getData().length;//ImageFile uzunluğu imageData dan çekiyor
	}
	
	

}
