package com.visionrent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visionrent.domain.ImageFile;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, String> {

	@EntityGraph(attributePaths = "id") // parametreye id degeri girildiği zaman aynı seviyedeki datalar gelir,
	// bağlı olduğu imageDatalar gelmiş olacak
	List<ImageFile> findAll();
}
